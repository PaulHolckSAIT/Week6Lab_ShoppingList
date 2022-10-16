<%-- 
    Document   : shoppingList
    Created on : 14-Oct-2022, 11:57:14 AM
    Author     : paulh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h2>Shopping List</h2>
        <p>Hello ${username}</p>
        <p><a href = "ShoppingList?action=logout">Logout</a></p>
        <form action="" method ="POST">
              <h2>Add Items</h2>
            <input type  ="text" name="item">
            <input type ="submit" value ="Add Item">
            <input type  ="hidden" name="shoppingaction" value ="add">
        </form>
        <form action=""method="POST">
            <ul>
                <c:forEach var ="item" items="${itemList}" var="item">
                    <li> <input type  ="radio" name="item" value ="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type  ="submit"  value ="Delete">
            <input type  ="hidden" name="shoppingaction" value ="delete">
        </form>
        <div>${message}</div>
    </body>
</html>
