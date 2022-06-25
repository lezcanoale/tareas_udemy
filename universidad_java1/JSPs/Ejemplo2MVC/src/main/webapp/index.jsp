<%-- 
    Document   : index
    Created on : 10 jun. 2022, 11:49:34
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC 2</title>
    </head>
    <body>
        <h1>Ejemplo MVC 2</h1>
        <br/>
        <div style="color: red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al servlet controlador SIN parametros
        </a><br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">
            Link al servlet controlador para agregar las variables
        </a><br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
            Link al servlet controlador para listar variables
        </a>       
    </body>
</html>
