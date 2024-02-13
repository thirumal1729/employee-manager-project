<!DOCTYPE html>
<%@page import="com.ty.user.entity.User"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manager Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa; /* Light gray background color */
            margin: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        button {
            background-color: #4CAF50; /* Green */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin: 0 10px;
        }

        button:hover {
            background-color: #45a049; /* Darker green on hover */
        }

        a {
            text-decoration: none;
            color: #333;
        }

        a:hover {
            color: #4CAF50; /* Green on hover */
        }

        button, a {
            display: inline-block;
        }
    </style>
</head>
<body>
    <% User user = (User) session.getAttribute("manager"); %>
    <h2>Welcome to the manager dashboard, <%=user.getUserName() %>!</h2>
    <a href="task.jsp"><button>Add Task</button></a><br><br>
    <a href="ManagerViewTask.jsp"><button>View Task</button></a><br><br>
    <a href="logout"><button>Logout</button></a>
</body>
</html>
