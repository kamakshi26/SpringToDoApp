<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Todo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Todo</h2>
        <form:form modelAttribute="todo" method="post">
        
            <form:label for="description" path="description">Todo Description:</form:label>
            <form:input path="description" id="description" required="true"/>
            <form:errors path="description" cssClass="error"/>
           
            
            <form:label for="targetDate" path="targetDate">Target Date:</form:label>
            <form:input path="targetDate" type="date" id="targetDate" required="true"/>
            <form:errors path="targetDate" cssClass="error"/>
            
            <form:label for="username" path="username">username</form:label>
            <form:input path="username"  id="username"/>
             
             <form:label for="isDone" path="isDone">isDone</form:label>
            <form:input path="isDone" id="isDone"/>
           
            
            <button type="submit"> add todo </button>
        </form:form>
    </div>
</body>
</html>
