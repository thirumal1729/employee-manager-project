<!DOCTYPE html>
<%@page import="com.ty.user.helper.UserFactory"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.user.entity.User"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Task Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        form {
            width: 50%;
            margin: auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        select, textarea, input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
        form h1{
        	text-align: center;
        }
        button, a {
            display: inline-block;
            background-color: skyblue;
            width: 100px;
            height: 40px;
            color: white;
            border-radius: 5px;
        }
    </style>
</head>
<body>

	<%
		List<User> users = UserFactory.getUserDaoObject().getEmployeeList();
	%>
	
    <form action="addTask" method="post">
    	<h1>Assign Task</h1>
        <label for="employeeId">Assign to:</label>
        <select name="employeeId">
            <% for(User user : users) { %>
                <option value="<%=user.getUserId()%>"><%=user.getUserId() %></option>
            <% } %>
        </select><br><br>
        
        <label for="description">Description:</label>
        <textarea rows="3" cols="30" name="description"></textarea><br><br>
        
        <label for="status">Status:</label>
        <input type="text" name="status" value="assigned" disabled="disabled"><br><br>
        
        <input type="submit" value="Add Task">
    </form><br><br>
    <center><a href="manager.jsp"><button id="back-btn">Back</button></a></center>
</body>
</html>
