<%-- 
    Document   : login
    Created on : 7-Feb-2022, 6:08:56 PM
    Author     : kinza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="login" method="post">
            
            <p>
                <label for="username">Username: </label>
                <input type="text" name="username" id="username" value="" required>
            </p>
             <p>
                <label for="password">Password: </label>
                <input type="text" name="password" id="password" required>
            </p>
            
            <button type="Submit">Submit</button>
        
        </form>
            
        <p>${message}</p>
            
            
    </body>
    
    
    
</html>
