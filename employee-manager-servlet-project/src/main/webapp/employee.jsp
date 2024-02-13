<!DOCTYPE html>
<%@page import="com.ty.user.entity.User"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:  #e0f7fa;
            margin: 20px;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
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
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <% User user = (User) session.getAttribute("employee"); %>
    <h2>Welcome to the employee dashboard, <%=user.getUserName() %>!</h2>
    <a href="EmployeeViewTask.jsp"><button>View Task</button></a>
    <a href="logout"><button>Logout</button></a>
</body>
</html>
