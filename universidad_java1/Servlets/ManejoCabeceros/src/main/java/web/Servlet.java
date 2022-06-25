
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        String metodoHttp=request.getMethod();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Headers Http</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Headers Http</h1>");
        out.print("Metodo Http:"+metodoHttp);
        String uri=request.getRequestURI();
        out.print("<br>");
        out.print("Uri solicitada: "+uri);
        //Imprimimos todos lso cabeceros disponibles
        out.print("<br>");
        out.print("<br>");
        Enumeration cabeceros=request.getHeaderNames();
       while(cabeceros.hasMoreElements()){
           String nombreCabecero=(String)cabeceros.nextElement();
           out.print("<b>"+nombreCabecero+"</b>");
           out.print(request.getHeader(nombreCabecero));
           out.print("<br>");
       }
        out.print("</body>");
        out.print("</html>");
        out.close();  
    }
}
