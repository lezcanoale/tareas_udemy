<%-- 
    Document   : index
    Created on : 6 jun. 2022, 10:46:46
    Author     : @author Alejandra Lezcano https://github.com/lezcanoale/
--%>
<!-- Agregamos una declaracion de JSP -->
<%!
    //Declaramos una variable con su metodo get 
    private String usuario="ALberto";
public String getUsuario(){
    return this.usuario;
}
    //Declaramos un contador de visitas
private int contadorVisitas=1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de declaraciones</title>
    </head>
    <body>
        <h1>Uso de declaraciones</h1>
        Valor de usuasrio por medio de atributo: <%= this.usuario%>
        <br>
        Valor usuario por medio del metodo: <%= this.getUsuario()%>
        <br>
        Contador de visitas: <%= this.contadorVisitas++ %>
        
    </body>
</html>
