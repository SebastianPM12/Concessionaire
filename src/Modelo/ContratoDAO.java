package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContratoDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ClassContrato> lista = new ArrayList<>();
        String sql = "select * from contrato";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassContrato c = new ClassContrato();
                c.setContrato(rs.getString(1));
                c.setIDVendedor(rs.getString(2));
                c.setDni(rs.getString(3));
                c.setPlaca(rs.getString(4));
                c.setDescripcion(rs.getString(5));
                c.setFecha(rs.getString(6));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into contrato(NUMERODECONTRATO,IDVENDEDOR,dni,PLACA,DEESCRIPCION,FECHADECREACION) values(?,?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "update contrato set IDVENDEDOR=?,dni=?,PLACA=?,DEESCRIPCION=?,FECHADECREACION=? where NUMERODECONTRATO=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void eliminarR(String id) {
        String sql = "delete from contrato where NUMERODECONTRATO=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ClassContrato buscarContrato(String ID) {
        String sql = "select * from contrato where NUMERODECONTRATO=?";
        ClassContrato c = new ClassContrato();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setContrato(rs.getString(1));
                c.setIDVendedor(rs.getString(2));
                c.setDni(rs.getString(3));
                c.setPlaca(rs.getString(4));
                c.setDescripcion(rs.getString(5));
                c.setFecha(rs.getString(6));
                JOptionPane.showMessageDialog(null, "CONTRATO ENCONTRADO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA LA FECHA \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
