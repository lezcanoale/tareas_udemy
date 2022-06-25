<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica el JavaBeans</title>
    </head>
    <body>
        <h1>JSP que modifica el JavaBeans</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <br/><!-- comment -->
        <br/><!-- comment -->
        <% 
            int baseValor=5;
            int alturaValor=10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>" />
        <br/><!-- comment -->
        Nuevo Valor Base: <%=baseValor%>
        Nuevo Valor Altura: <%=alturaValor%>
        <br/><!-- comment -->
        <br/><!-- comment -->
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
