<%-- 
    Document   : manejoErrores
    Created on : 7 jun. 2022, 11:47:52
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>
<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo Errores</title>
    </head>
    <body>
        <h1>Manejo Errores</h1>
        <br/>
        Ocurrio una excepcion: <%= exception.getMessage()%>
        <br/>
        <textarea cols="30" rows="5">
            <pre>
                <% exception.printStackTrace(new PrintWriter(out));%>
            </pre>
        </textarea>
        
    </body>
</html>
