<%-- 
    Document   : recursoPublico
    Created on : 8 jun. 2022, 12:59:27
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>
<%--Como es una inclusion dinamica, los jsp se ejecutan por separado
debido a que se ejecutan en diferente servlets, se pueden manterner las 
etiquetas de html--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recurso Publico</title>
    </head>
    <body>
        <br/>
        Inclusion de Contenido dinamico desde un JSP Publico
        <br/><!-- comment -->
        Nombre de la aplicacion: <%= request.getContextPath() %>
        <h1>Hello World!</h1>
    </body>
</html>
