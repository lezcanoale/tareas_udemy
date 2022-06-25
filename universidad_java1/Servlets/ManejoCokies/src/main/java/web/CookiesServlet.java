
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Suponer que el ususario ingresa por primera vez
        boolean nuevoUsuario=true;
        //Obtenemos el arrreglo de cookies
        Cookie[] cookies=request.getCookies();
        //Buscamos si ya existe una cookies creada antes
        //llamada visitanteRecurrente
        if(cookies!=null){
            for(Cookie c:cookies){
                if(c.getName().equals("visitanteRecurrente")&&c.getValue().equals("si")){
                    //si ya existe la cookie 
                    nuevoUsuario=false;
                    break;
                }
            }
        }
        String mensaje=null;
        if(nuevoUsuario){
            Cookie visitanteCookie=new Cookie("visitanteRecurrente","si");
            mensaje="Gracias por visitar por primera vez nuestro sitio";
            
        }else{
            mensaje="Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje"+mensaje);
        out.close();
    }
}
