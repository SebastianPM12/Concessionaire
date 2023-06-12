
package Modelo;

/**
 *
 * @author 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Conexion {
    
    Connection con;
    String url = "jdbc:mysql://localhost:3307/consecionaria?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String pass = "";

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = java.sql.DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return con;
    }
    
    
}
