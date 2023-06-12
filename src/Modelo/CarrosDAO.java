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
public class CarrosDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<Carro> lista = new ArrayList<>();
        String sql = "select * from auto";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Carro cr = new Carro();
                cr.setTipo(rs.getString(1));
                cr.setPlaca(rs.getString(2));
                cr.setMarca(rs.getString(3));
                cr.setPrecio(rs.getDouble(4));
                cr.setColor(rs.getString(5));
                cr.setAño(rs.getInt(6));
                lista.add(cr);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into auto(TIPO,PLACA,MARCA,PRECIO,COLOR,AÑO) values(?,?,?,?,?,?)";
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
            JOptionPane.showMessageDialog(null, "CARRO REGISTRADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ID YA REGISTRADO NO SE PUEDE DUPLICAR O HUBO UN FALLO \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;

        String sql = "update auto set TIPO=?,MARCA=?,PRECIO=?,COLOR=?,AÑO=? where PLACA=?";

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
            JOptionPane.showMessageDialog(null, "CARRO ACTUALIZADO");

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
        String sql = "delete from auto where PLACA=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "CARRO ELIMINADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO EN LA ELIMINACION \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }
    
     public Carro buscarCarro(String placa) {
        String sql = "select * from auto where PLACA=?";
        Carro cs = new Carro();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            while (rs.next()) {
                cs.setTipo(rs.getString(1));
                cs.setPlaca(rs.getString(2));
                cs.setMarca(rs.getString(3));
                cs.setPrecio(rs.getDouble(4));
                cs.setColor(rs.getString(5));
                cs.setAño(rs.getInt(6));
                JOptionPane.showMessageDialog(null, "CARRO ENCONTRADO");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA EL ID \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return cs;
    }

}
