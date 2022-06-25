
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/ContVisitasServlet")
public class ContVisitasServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
      int cont=0;
      //Revisar si ya existe la cookie contadorVisitas
      Cookie[] cookies=request.getCookies();
      if(cookies!=null){
          for(Cookie c:cookies){
              if(c.getName().equals("contadorVisitas")){
                  cont=Integer.parseInt(c.getValue());
              }
          }
      }
      //incrementamos el contador
      cont++;
      //agregamos la respuesta al navegador
      Cookie c=new Cookie("contadorVisitas",Integer.toString(cont));
      //la cookie se almacenara en el cliente por 1 h(3600s)
      c.setMaxAge(3600);
      response.addCookie(c);
      //Mandamos el mensaje al navegador
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out= response.getWriter();
      out.print("Contador de visitas de cada cliente: "+cont);
      
    }
}
