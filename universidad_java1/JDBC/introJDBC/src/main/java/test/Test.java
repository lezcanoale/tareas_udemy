
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
       String url= "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion= DriverManager.getConnection(url,"root","admin");
            Statement instruccion=conexion.createStatement();
            var sql="SELECT id_persona,nombre,apellido FROM persona";
            ResultSet resultado=instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.println("Id persona:"+resultado.getInt("id_persona")+" Nombre persona:"+resultado.getString("nombre")+" Apellido:"+resultado.getString("apellido"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
