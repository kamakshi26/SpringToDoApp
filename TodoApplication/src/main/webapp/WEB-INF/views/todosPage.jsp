
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
                <th>Description</th>
                <th>isCompleted</th>
                <th>targetDate</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="todo" items="${todolist}">
           		<tr>
           		<td>${todo.getDescription()}</td>
           		<td>${todo.getTargetDate()}</td>
           		<td>${todo.getIsDone()}</td>
           		<td><a href="delete-todo?id=${todo.getId()}"><button>delete</button></a></td>
           		<td><a href="update-todo?id=${todo.getId()}"><button>update</button></a></td>
           		</tr>
           </c:forEach>
         
        </tbody>
    </table>
      <a href="add-todo"><button > Add Todo </button></a>
</body>
</html>
