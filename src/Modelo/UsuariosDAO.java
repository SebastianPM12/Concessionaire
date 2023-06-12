
package Modelo;

/**
 *
 * @author 
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class UsuariosDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    
    Conexion con=new Conexion();
    Connection acceso;
    
    public ClassUsuarios validarUsuario(String usuario,String contra){
        ClassUsuarios clase = new ClassUsuarios();
        String sql ="select * from usuario where Usuario = ? and Contraseña = ?";
        try {
            acceso = con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contra);
            rs=ps.executeQuery();
            while(rs.next()){
                clase.setID(rs.getInt(1));
                clase.setEstado(rs.getString(2));
                clase.setUser(rs.getString(3));
                clase.setPass(rs.getString(4));
                clase.setTipo(rs.getString(5));
                clase.setNombres(rs.getString(6));
                clase.setApellidos(rs.getString(7));
                clase.setDireccion(rs.getString(8));
                clase.setEdad(rs.getInt(9));
                clase.setCorreo(rs.getString(10));
                clase.setGenero(rs.getString(11));
                clase.setCelular(rs.getString(12));
                
            }
        } catch (Exception e) {
            
        }
        return clase;
    }
}
