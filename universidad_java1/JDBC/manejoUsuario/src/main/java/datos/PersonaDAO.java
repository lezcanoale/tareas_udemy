package datos;

import static datos.Conexion.*;
import java.util.*;
import domain.Persona;
import java.sql.*;





public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_persona, nombre,apellido FROM persona";
    private static final String SQL_INSERT="INSERT INTO persona(nombre,apellido)VALUES(?,?)";
    private static final String SQL_UPDATE="UPDATE persona SET nombre = ?, apellido = ? WHERE id_persona = ?";
    private static final String SQL_DELETE="DELETE FROM persona WHERE id_persona= ?";
    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                persona = new Persona(idPersona, nombre, apellido);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return personas;
    }
    public int insertar(Persona persona){
        Connection conn=null;
        PreparedStatement stmt=null;
        int reg=0;
        try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            reg=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }   
        }
           return reg;
    }
    public int actualizar(Persona per){
        Connection conn=null;
        PreparedStatement stmt=null;
        int reg=0;
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, per.getNombre());
            stmt.setString(2, per.getApellido());
            stmt.setInt(3, per.getIdPersona());
            reg=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return reg;
    }
    public int eliminar(int id){
        Connection conn=null;
        PreparedStatement stmt=null;
        int reg=0;
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            reg=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return reg;
    }
}
