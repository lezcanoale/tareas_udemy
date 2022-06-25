package datos;

import static datos.Conexion.*;
import java.util.*;
import domain.Usuario;
import java.sql.*;

public class UsuarioDAO {
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_usuario, usuario,password FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(usuario,password)VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario= ?";

    public UsuarioDAO() {
    }

    public UsuarioDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    
    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario user = null;
        List<Usuario> users = new ArrayList<>();

        try {
            if(conn!=null){
                conn =this.conexionTransaccional;
            }else{
                conn=Conexion.getConnection();
            }
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("usuario");
                String apellido = rs.getString("password");
                user = new Usuario(idUsuario, nombre, apellido);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                if(this.conexionTransaccional==null){
                   Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return users;
    }

    public int insertar(Usuario user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int reg = 0;
        try {
            if(conn!=null){
                conn =this.conexionTransaccional;
            }else{
                conn=Conexion.getConnection();
            }
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getPassword());
            reg = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if(this.conexionTransaccional==null){
                   Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return reg;
    }

    public int actualizar(Usuario user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int reg = 0;
        try {
            if(conn!=null){
                conn =this.conexionTransaccional;
            }else{
                conn=Conexion.getConnection();
            }
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,user.getUsuario());
            stmt.setString(2,user.getPassword());
            stmt.setInt(3, user.getidUsuario());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if(this.conexionTransaccional==null){
                   Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return reg;
    }

    public int eliminar(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int reg = 0;
        try {
            if(conn!=null){
                conn =this.conexionTransaccional;
            }else{
                conn=Conexion.getConnection();
            }
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            reg = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if(this.conexionTransaccional==null){
                   Conexion.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return reg;
    }


}
