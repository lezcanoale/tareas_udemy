<%-- primero importamos el taglib que es importante para
usar el JSTL --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL CORE</title>
    </head>
    <body>
        <h1>JSTL CORE (JSP Standard Tag Library)</h1>
        <%-- Manipulacion de variables --%>
        <%-- Definimos la variable --%>
        <c:set var="nombre" value="Alejandra" />
        <%--Imprimimos la variable --%>
        Varaible nombre: <c:out value="${nombre}"/>
        <br/><!-- comment -->
        <br/><!-- comment -->
        Variable con codigo HTML:
        <c:out value="<h4>Hola</h4>" escapeXml="false" />
        <!-- Codigo condicionado, uso de switch -->
        <c:if test="${param.opcion!=null}">
            <c:choose>
                <c:when test="${param.opcion==1}">
                    <br/><!-- comment -->
                    Opcion 1 seleccionada:
                </c:when>
                <c:when test="${param.opcion==3}">
                    <br/><!-- comment -->
                    Opcion 2 seleccionada:
                </c:when>
                <c:otherwise>
                    <br/><!-- comment -->
                    Opcion no disponible: ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>
        <!-- Iteracion de un arreglo -->
        <%
            String nombres[]={"Alejandra","Junior","Alana"};
            request.setAttribute("nombres", nombres);
        %>
        <br/><!-- comment -->
        Lista Nombres:
        <br/><!-- comment -->
        <br/><!-- comment -->
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>Nombre: ${persona}</li>
            </c:forEach>
        </ul>
        <br/><!-- comment -->
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
