<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestión Avícola</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="sidebar">
        <ul>
            <li><a href="#">Menu inicial</a></li>
            <li><a href="#">Aves</a></li>
            <li><a href="#">Producción</a></li>
            <li><a href="#">Proveedores</a></li>
            <li><a href="#">Insumos</a></li>
            <li><a href="#">Tareas</a></li>
            <li><a href="#">Reportes</a></li>
        </ul>
    </div>
    <div class="content">
        <div class="header">
            <h1>Gestión Avícola</h1>
            <p>Toda la información de tu granja al instante</p>
        </div>
        <div class="form">
            <form action="tasks" method="post">
                <label for="description">Descripción:</label>
                <input type="text" id="description" name="description" required>
                <label for="datetime">Fecha y Hora:</label>
                <input type="datetime-local" id="datetime" name="datetime" required>
                <button type="submit">Guardar Tarea</button>
            </form>
        </div>
        <div class="task-list">
            <ul>
                <c:forEach var="task" items="${tasks}">
                    <li>${task.description} - ${task.datetime}
                        <form action="tasks" method="post" style="display:inline;">
                            <input type="hidden" name="_method" value="delete">
                            <input type="hidden" name="id" value="${task.id}">
                            <button type="submit">Eliminar</button>
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>
