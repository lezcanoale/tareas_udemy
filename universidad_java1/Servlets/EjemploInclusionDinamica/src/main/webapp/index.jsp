<%-- 
    Document   : index
    Created on : 8 jun. 2022, 12:58:46
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo inclusion Dinamica</title>
    </head>
    <body>
        <h1>Ejemplo inclusion Dinamica</h1>
        <jsp:include page="paginas/recursoPublico.jsp" />
        <br/>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/> 
        </jsp:include>
    </body>
</html>
