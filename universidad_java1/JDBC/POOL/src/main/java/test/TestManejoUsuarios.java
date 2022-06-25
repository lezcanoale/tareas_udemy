
package test;
import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        Connection conn=null;
        try {
            conn=Conexion.getConnection();
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            UsuarioDAO userDao= new UsuarioDAO(conn);
            Usuario user=new Usuario();
            user.setusuario("Gladys64111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
            user.setpassword("crucigrama");
            userDao.insertar(user);
            conn.commit();//hacemos commit
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
    public static void verificar(List <Usuario> users,UsuarioDAO usDao,Usuario user, Usuario nuser){
        var usid=user.getidUsuario();
        var usnom=user.getUsuario();
        var uspass=user.getPassword();
        int nusid=users.get(usid-1).getidUsuario();
        String nusnom=users.get(usid-1).getUsuario();
        String nuspass=users.get(usid-1).getPassword();
        if(usid==nusid && usnom.equals(nusnom)&&uspass.equals(nuspass)){
            usDao.actualizar(nuser);
        }else{
            System.out.println("El usuario o la contraseña no son correctos");
        }
    }
}
