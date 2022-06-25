<%-- 
    Document   : scriplets
    Created on : 6 jun. 2022, 08:25:37
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriplets</title>
    </head>
    <body>
        <h1>JSP con Scriplets</h1>
        <%--Scriplet para enviar informacion al navegador--%>
        <% 
            out.print("Saludos desde un scriplet");
        %>
        <%-- Scriplet para manipular los objetos implicitos --%>
        <% 
            String nombreAplicacion=request.getContextPath();
            out.print("nombre de la aplicacion: "+nombreAplicacion);
        %>
        <%
            if(session!=null && session.isNew()){ 
        %>
        la sesion es nueva
        <% 
            }else if(session!=null){
        %>
        la sesion NO es nueva
        <% } %>  
    </body>
</html>
