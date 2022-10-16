<%-- 
    Document   : register
    Created on : 14-Oct-2022, 11:57:56 AM
    Author     : paulh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h2>Shopping List</h2>
        <form action = "ShoppingList" method = "POST">
            Username: <input type ="text" name="username" ><br>
            <input type  ="hidden" name="action" value ="register">
            <input type  ="submit"  value ="Register">
        </form>
        <div>${message}</div>
    </body>
</html>