package com.granja.gestionavicola.controllers;

import com.granja.gestionavicola.models.Task;
import com.granja.gestionavicola.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/tasks")
public class TaskController extends HttpServlet {
    private TaskService taskService = new TaskService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String datetime = request.getParameter("datetime");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(datetime, formatter);

        Task task = new Task();
        task.setDescription(description);
        task.setDatetime(dateTime);

        taskService.addTask(task);
        response.sendRedirect("tasks");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = taskService.getTasks();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        taskService.removeTask(id);
        response.sendRedirect("tasks");
    }
}
