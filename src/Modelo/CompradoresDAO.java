package Modelo;

/**
 *
 * @author
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CompradoresDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ClassCompradores> lista = new ArrayList<>();
        String sql = "select * from comprador";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassCompradores c = new ClassCompradores();
                c.setDni(rs.getString(1));
                c.setNombres(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEdad(rs.getInt(5));
                c.setCorreo(rs.getString(6));
                c.setGenero(rs.getString(7));
                c.setCelular(rs.getString(8));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into comprador(dni,Nombres,Apellidos,Direccion,Edad,Correo,Genero,Celular) values(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "COMPRADOR REGISTRADO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO EN REGISTRAR \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update comprador set Nombres=?,Apellidos=?,Direccion=?,Edad=?,Correo=?,Genero=?,Celular=? where dni=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "COMPRADOR ACTUALIZADOO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA EL ID \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from comprador where dni=?";
        try {
            String dni = String.valueOf(id);
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni );
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "COMPRADOR ELIMINADO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO EN LA ELIMINACION \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void eliminarR(String id) {

    }

    public ClassCompradores buscarComprador(String dni) {
        String sql = "select * from comprador where dni=?";
        ClassCompradores c = new ClassCompradores();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setDni(rs.getString(1));
                c.setNombres(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEdad(rs.getInt(5));
                c.setCorreo(rs.getString(6));
                c.setGenero(rs.getString(7));
                c.setCelular(rs.getString(8));
                JOptionPane.showMessageDialog(null, "PROVEEDOR ENCONTRADO");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA EL ID \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return c;
    }

}
