<!DOCTYPE html>
<%@page import="com.ty.user.entity.Task"%>
<%@page import="com.ty.user.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.user.helper.UserFactory"%>
<%@page import="com.ty.user.dao.UserDao"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h1, h2, h3 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Task Details</h1>
    <% UserDao userDao = UserFactory.getUserDaoObject();
       List<User> users = userDao.getEmployeeList();
       for(User user: users){
           List<Task> tasks = user.getTasks();
    %>
    <h2><u>Task Assigned To</u></h2>
    <h3>Employee ID is: <%= user.getUserId() %></h3>
    <h3>Employee Name is: <%= user.getUserName() %></h3>
    <table>
        <tr>
            <th>Task ID</th>
            <th>Task Description</th>
            <th>Assigned Time</th>
            <th>Status</th>
            <th>Completed Time</th>
        </tr>
        <% for(Task task: tasks){
               String status = task.getStatus();
        %>
        <tr>
            <td><%= task.getTaskId() %></td>
            <td><%= task.getDescription() %></td>
            <td><%= task.getCreatedDateTime() %></td>
            <td><%= status %></td>
            <% if(!(status.equals("assigned"))){ %>
                <td><%= task.getCompletedDateTime() %></td>
            <% } else { %>
                <td></td>
            <% } %>
        </tr>
        <% } %>
    </table>
    <% } %>
    <a href="logout"><button>Logout</button></a>
</body>
</html>
