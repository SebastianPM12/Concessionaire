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
public class MecanicosDAO implements CRUD{

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ClassMecanico> lista = new ArrayList<>();
        String sql = "select * from mecanico";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassMecanico cv = new ClassMecanico();
                cv.setIdmecanico(rs.getString(1));
                cv.setEstado(rs.getString(2));
                cv.setTurno(rs.getString(3));
                cv.setNombres(rs.getString(4));
                cv.setApellidos(rs.getString(5));
                cv.setDireccion(rs.getString(6));
                cv.setEdad(rs.getInt(7));
                cv.setCorreo(rs.getString(8));
                cv.setGenero(rs.getString(9));
                cv.setCelular(rs.getString(10));
                lista.add(cv);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into mecanico(IDMECANICO,ESTADO,TURNO,NOMBRES,APELLIDOS,DIRECCION,EDAD,CORREO,GENERO,CELULAR) values(?,?,?,?,?,?,?,?,?,?)";
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
            ps.setObject(10, o[9]);
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
        String sql = "update mecanico set ESTADO=?,TURNO=?,NOMBRES=?,APELLIDOS=?,DIRECCION=?,EDAD=?,CORREO=?,GENERO=?,CELULAR=? where IDMECANICO=?";
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
            ps.setObject(10, o[9]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "MECANICO ACTUALIZADO");

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
        String sql = "delete from mecanico where IDMECANICO=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "MECANICO ELIMINADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO EN LA ELIMINACION \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ClassMecanico buscarMecanico(String idmecanico) {
        String sql = "select * from mecanico where IDMECANICO=?";
        ClassMecanico cs = new ClassMecanico();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, idmecanico);
            rs = ps.executeQuery();
            while (rs.next()) {
                cs.setIdmecanico(rs.getString(1));
                cs.setEstado(rs.getString(2));
                cs.setTurno(rs.getString(3));
                cs.setNombres(rs.getString(4));
                cs.setApellidos(rs.getString(5));
                cs.setDireccion(rs.getString(6));
                cs.setEdad(rs.getInt(7));
                cs.setCorreo(rs.getString(8));
                cs.setGenero(rs.getString(9));
                cs.setCelular(rs.getString(10));
                JOptionPane.showMessageDialog(null, "MECANICO ENCONTRADO");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA EL ID \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return cs;
    }

    
}
