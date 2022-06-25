<%-- 
    Document   : resporteExcel
    Created on : 6 jun. 2022, 22:13:37
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>
<%@page errorPage= "/WEB-INF/manejoErrores.jsp"%>
<%@page import="utilerias.Conversiones,java.util.Date" %>
<%@page contentType="application/vnd.ms-excel"%>
<%
    String nombreArchivo="reporte.xls";
    response.setHeader("Content-Disposition","inline;filename="+nombreArchivo);
%>
    
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <table border="1">
            <th>Curso</th>
            <th>Descripcion</th>
            <th>Fecha</th>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis de Java</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
            <tr>
                <td>2. Programacion en Java</td>
                <td>Pondremos en practica conceptos de la programacion orientada a objetos Java</td>
                <td><%= Conversiones.format("500")%></td>
            </tr>
            
        </table>
    </body>
</html>
