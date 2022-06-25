
package domain;

public class Usuario { //DAO Data Access Object (clase que modifica la BD)
    //Atributos
    private int idUsuario;
    private String usuario;
    private String password;
    
    //Constructores
    public Usuario() {
    }
    //para eliminar un registro, ya que solo se necesita de su id
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    //para agg un registro, solo se necesita de eso ya que el id es autoincrementable
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    //en el caso de que se desee modificar un registro 
    public Usuario(int idUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }
    
    //Metodos
    public int getidUsuario() {
        return this.idUsuario;
    }

    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
}
