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
public class RevisionDAO implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ClassRevision> lista = new ArrayList<>();
        String sql = "select * from revision";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassRevision c = new ClassRevision();
                c.setIdrevision(rs.getInt(1));
                c.setPlaca(rs.getString(2));
                c.setDeescripcion(rs.getString(3));
                c.setFecha(rs.getString(4));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into revision(PLACA,DESCRIPCION,FECHADECREACION) values(?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);

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
        String sql = "update revision set PLACA=?,DESCRIPCION=? where IDREVISION=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "HUBO UN PROBLEMA EN LA ACTUALIZACION \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from revision where IDREVISION=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "HUBO UN PROBLEMA EN LA ELIMINACION \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void eliminarR(String id) {

    }

    public ClassRevision buscarRevision(String id) {
        String sql = "select * from revision where PLACA=?";
        ClassRevision c = new ClassRevision();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdrevision(rs.getInt(1));
                c.setPlaca(rs.getString(2));
                c.setDeescripcion(rs.getString(3));
                c.setFecha(rs.getString(4));
                JOptionPane.showMessageDialog(null, "REVISION ENCONTRADa");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA LA REVISION \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
}
