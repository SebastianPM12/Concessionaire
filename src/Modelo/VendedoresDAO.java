/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author SEBAS
 */
public class VendedoresDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ClassVendedor> lista = new ArrayList<>();
        String sql = "select * from vendedor";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassVendedor cv = new ClassVendedor();
                cv.setIdvendedor(rs.getString(1));
                cv.setEstado(rs.getString(2));
                cv.setNombres(rs.getString(3));
                cv.setApellidos(rs.getString(4));
                cv.setDireccion(rs.getString(5));
                cv.setEdad(rs.getInt(6));
                cv.setCorreo(rs.getString(7));
                cv.setGenero(rs.getString(8));
                cv.setCelular(rs.getString(9));
                lista.add(cv);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into vendedor(IDVENDEDOR,ESTADO,NOMBRES,APELLIDOS,DIRECCION,EDAD,CORREO,GENERO,CELULAR) values(?,?,?,?,?,?,?,?,?)";
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
            ps.setObject(9, o[8]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ID YA REGISTRADO NO SE PUEDE DUPLICAR \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return r;

    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update vendedor set ESTADO=?,NOMBRES=?,APELLIDOS=?,DIRECCION=?,EDAD=?,CORREO=?,GENERO=?,CELULAR=? where IDVENDEDOR=?";
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
            ps.setObject(9, o[8]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "VENDEDOR ACTUALIZADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ID YA REGISTRADO NO SE PUEDE DUPLICAR O HUBO UN FALLO \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarR(String id) {
        String sql = "delete from vendedor where IDVENDEDOR=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "VENDEDOR ELIMINADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO EN LA ELIMINACION \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ClassVendedor buscarVendedor(String idvendedor) {
        String sql = "select * from vendedor where IDVENDEDOR=?";
        ClassVendedor cs = new ClassVendedor();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, idvendedor);
            rs = ps.executeQuery();
            while (rs.next()) {
                cs.setIdvendedor(rs.getString(1));
                cs.setEstado(rs.getString(2));
                cs.setNombres(rs.getString(3));
                cs.setApellidos(rs.getString(4));
                cs.setDireccion(rs.getString(5));
                cs.setEdad(rs.getInt(6));
                cs.setCorreo(rs.getString(7));
                cs.setGenero(rs.getString(8));
                cs.setCelular(rs.getString(9));
                JOptionPane.showMessageDialog(null, "VENDEDOR ENCONTRADO");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA EL ID \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return cs;
    }

}
