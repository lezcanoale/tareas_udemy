<%-- 
    Document   : procesaFormulario
    Created on : 5 jun. 2022, 21:43:37
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Procesa Formulario</h1>
        Usuario: <%= request.getParameter("usuario")%>
        <br>
        Password: <%= request.getParameter("password")%>
        <br>
        <br>
        <a href="index.html">Regresar al inicio</a>
                
    </body>
</html>
