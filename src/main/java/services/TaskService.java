package com.granja.gestionavicola.services;

import com.granja.gestionavicola.dao.TaskDAO;
import com.granja.gestionavicola.models.Task;

import java.util.List;

public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();

    public void addTask(Task task) {
        taskDAO.save(task);
    }

    public List<Task> getTasks() {
        return taskDAO.getAll();
    }

    public void removeTask(Long id) {
        taskDAO.delete(id);
    }
}
