<%-- 
    Document   : login
    Created on : Feb 11, 2023, 11:10:39 PM
    Author     : Jaz Baliola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        <h1>Login</h1>

        <form action="login" method="post">
            
            <label>Username: </label>
            <input type="text" name="username" value="${username}"><br>
        
            <label>Password: </label>
            <input type="password" name="password" value="${password}"><br>
        
            <input type="submit" name="submit" value="Log In">    
        
        </form>
            
        <p>${message}</p>
        
    </body>
</html>
