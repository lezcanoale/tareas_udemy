
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("application/vnd.ms-excel");//indicamos el tipo de contenido que vamos a generar
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        //attachment: indica que se tiene que descargar
        //filename: el nombre del excel a descargar
        //para un uso mas profesional de excel poi.apache.org
        
        response.setHeader("Pragma","no-cache");//para que cada que se haga click en el link no se guarde cache en el navegador
        response.setHeader("Cache-control", "no-store");
        response.setDateHeader("Expires", -1);
        //Desplegamos informcion al cliente
        PrintWriter out=response.getWriter();
        out.print("\tValores");//escribimos en una celda
        out.print("\t1");
        out.print("\t2");
        out.print("Total\t=SUMA(b2:b3)");
        out.close(); 
    }
}
