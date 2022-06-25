package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

/**
 *
 * @author Alejandra Lezcano https://github.com/lezcanoale/
 */
@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Creamos o recuperamos el objeto http sesion
        HttpSession sesion = request.getSession();
        //Recuperamos la lista de articulos agregados si es que existen 
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }
        //Procesamos el nuevo articulo
        String nuevoArticulo = request.getParameter("articulo");
        //revisamos y agregamos al articulo nuevo
        if (nuevoArticulo != null && !nuevoArticulo.trim().equals("")) {
            articulos.add(nuevoArticulo);
        }
        //iteramos todos los articulos
        try ( //imprimimos la lista de articulos
                 PrintWriter out = response.getWriter()) {
            //iteramos todos los articulos
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }
            //agregamos un link para regresar al inicio
            out.print("<a href='/EjemploCarrito'>Regresar a inicio</a>");
        }
    }
}
