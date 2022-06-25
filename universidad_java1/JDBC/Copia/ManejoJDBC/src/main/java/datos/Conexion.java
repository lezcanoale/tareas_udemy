
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    private static final String JDBC_url="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_user="root";
    private static final String JDBC_pass="admin";
    //metodo para obtener conexion con la bd
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_url, JDBC_user, JDBC_pass);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }


}
