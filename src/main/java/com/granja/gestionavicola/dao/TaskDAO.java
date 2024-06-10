package com.granja.gestionavicola.dao;

import com.granja.gestionavicola.models.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TaskDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion_avicola_pu");

    public void save(Task task) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
        em.close();
    }

    public List<Task> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Task> tasks = em.createQuery("from Task", Task.class).getResultList();
        em.close();
        return tasks;
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Task task = em.find(Task.class, id);
        if (task != null) {
            em.remove(task);
        }
        em.getTransaction().commit();
        em.close();
    }
}
