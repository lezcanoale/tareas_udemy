<%-- 
    Document   : expresiones
    Created on : 5 jun. 2022, 21:43:11
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        Concatenacion: <%="Saludos"+""+"JSP" %>
        <br>
        Operacion Matematica: <%= 2*3/2 %>
        <br>
        Session id: <%= session.getId() %>
        <br>     
        <<a href="index.html">Regresar al inicio</a>
        
    </body>
</html>
