
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>MyTodo</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>your todolist ${username}</h1>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Description</th>
                <th>isCompleted</th>
                <th>targetDate</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="todo" items="${todolist}">
           		<tr>
           		<td>${todo.getId()}</td>
           		<td>${todo.getDescription()}</td>
           		<td>${todo.getTargetDate()}</td>
           		<td>${todo.isDone()}</td>
           		</tr>
           </c:forEach>
        </tbody>
    </table>
</body>
</html>
