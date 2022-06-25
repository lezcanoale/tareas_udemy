
package domain;

public class Persona { //DAO Data Access Object (clase que modifica la BD)
    //Atributos
    private int idPersona;
    private String nombre;
    private String apellido;
    
    //Constructores
    public Persona() {
    }
    //para eliminar un registro, ya que solo se necesita de su id
    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }
    //para agg un registro, solo se necesita de eso ya que el id es autoincrementable
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    //en el caso de que se desee modificar un registro 
    public Persona(int idPersona, String nombre, String apellido) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    //Metodos
    public int getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
}
