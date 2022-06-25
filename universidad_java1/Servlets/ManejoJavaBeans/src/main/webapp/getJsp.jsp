<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee los valores del JavaBeans</title>
    </head>
    <body>
        <h1>JSP que lee los valores del JavaBeans</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <br/><!-- comment -->
        <br/><!-- comment -->
        Valor Base: <jsp:getProperty name="rectangulo" property="base" />
        <br/><!-- comment -->
        Valor Altura: <jsp:getProperty name="rectangulo" property="altura" />
        <br/><!-- comment -->
        Valor Area: <jsp:getProperty name="rectangulo" property="area" />
        <br/><!-- comment -->
        <br/><!-- comment -->
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
