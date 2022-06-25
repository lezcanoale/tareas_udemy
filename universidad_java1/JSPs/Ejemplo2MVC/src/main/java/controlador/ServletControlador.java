package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        //1. Porcesamos parametros
        //en este caso el de accion
        String accion=request.getParameter("accion");
        
        //2.Creamos los JavaBeans
        Rectangulo recRequest=new Rectangulo(1,2);
        Rectangulo recSesion=new Rectangulo(3,4);  
        Rectangulo recAplication=new Rectangulo(5,6);
        //3. Agregamos el JavaBeans a algun alcance 
        //revisamos la accion proporcionada
        if("agregarVariables".equals(accion)){
            //alcance request
            request.setAttribute("rectanguloRequest", recRequest);
            //alcance sesion
            HttpSession sesion=request.getSession();
            sesion.setAttribute("rectanguloSesion", recSesion);
            //alcance aplication
            ServletContext application=request.getServletContext();
            application.setAttribute("rectanguloAplicacion",recAplication);
            //agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregados");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if("listarVariables".equals(accion)){
            //4. Redireccionamos al jsp que despliega las vriables
            RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp"); 
            rd.forward(request, response);
        }else{
            //4.Redireccionamos a la pagina de inicio
            request.setAttribute("mensaje", "Accion no proporcionada");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
        
    }
}
