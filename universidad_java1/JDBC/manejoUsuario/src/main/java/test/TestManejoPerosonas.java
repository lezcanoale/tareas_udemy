
package test;
import datos.PersonaDAO;
import domain.Persona;
import java.util.List;
public class TestManejoPerosonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        personaDao.eliminar(5);
        //Persona per=new Persona(5,"Sergio","Elizalde");
        //personaDao.actualizar(per);
        List<Persona> personas = personaDao.seleccionar();
        
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
        //Insertando un nuevo objeto de tipo Persona
//        Persona personaNueva = new Persona("Carlos", "Esparza", "cesparza@mail.com", "554456587");
//        personaDao.insertar(personaNueva);

        //Modificar un objeto de persona existente
/*        Persona personaModificar = new Persona(4, "Juan Carlos", "Esparza");
        personaDao.actualizar(personaModificar);*/
        
        //Listado Persona
        //List<Persona> personas = personaDao.seleccionar();
        
    }
}
