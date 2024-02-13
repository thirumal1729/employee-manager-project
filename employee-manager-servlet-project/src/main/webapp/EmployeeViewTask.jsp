<!DOCTYPE html>
<%@page import="com.ty.user.entity.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.user.helper.UserFactory"%>
<%@page import="com.ty.user.dao.UserDao"%>
<%@page import="com.ty.user.entity.User"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h1, h2, h3 {
            color: #333;
            text-align: center;
        }

        .task-table {
            width: 50%;
            margin: auto;
            background-color: white;
            margin-top: 20px;
        }

        .task-table td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        select {
            padding: 8px;
            font-size: 14px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }

        a {
            text-decoration: none;
            color: #333;
        }

        button, a {
            display: inline-block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1><u>Task List</u></h1>
    <% User user = (User) session.getAttribute("employee");
       UserDao userDao = UserFactory.getUserDaoObject();
       List<Task> tasks = userDao.viewAllTasks(user.getUserId());
    %>
    <% for(Task task : tasks) { %>
        <table class="task-table" border="solid" cellspacing="0">
            <tr>
                <td>
                    <strong>Task Id:</strong> <%=task.getTaskId() %><br>
                </td>
            </tr>
            <tr>
                <td>
                    <strong>Description:</strong> <%=task.getDescription() %><br>
                </td>
            </tr>
            <tr>
                <td>
                    <strong>Created Time:</strong> <%=task.getCreatedDateTime() %><br>
                </td>
            </tr>
            <tr>
                <td>
                    <strong>Status:</strong> <%=task.getStatus() %><br>
                </td>
            </tr>
            <tr>
                <td>
                    <form action="editStatus" method="post">
                        <label for="status"><strong>Edit Status:</strong></label>
                        <select name="status">
                            <option value="assigned">assigned</option>
                            <option value="completed">completed</option>
                        </select>
                        <button name="taskId" value="<%=task.getTaskId() %>">Edit</button>
                    </form>
                </td>
            </tr>
        </table>
    <% } %>

    <br>
    <center><a href="logout"><button>Logout</button></a></center>
</body>
</html>
