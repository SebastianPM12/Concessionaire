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
public class ProveedorDAO implements CRUD{

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ClassProveedor> lista = new ArrayList<>();
        String sql = "select * from proveedor";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClassProveedor cv = new ClassProveedor();
                cv.setIdproveedor(rs.getString(1));
                cv.setSucursal(rs.getString(2));
                cv.setNombre(rs.getString(3));
                cv.setApellido(rs.getString(4));
                cv.setEmpresa(rs.getString(5));
                cv.setCelular(rs.getString(6));
                cv.setEstado(rs.getString(7));
                lista.add(cv);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into proveedor(IDPROVEEDOR,SUCURSAL,NOMBRE,APELLIDO,EMPRESA,CELULAR,ESTADO) values(?,?,?,?,?,?,?)";
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
        String sql = "update proveedor set SUCURSAL=?,NOMBRE=?,APELLIDO=?,EMPRESA=?,CELULAR=?,ESTADO=? where IDPROVEEDOR=?";
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
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "PROVEEDOR ACTUALIZADO");

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
        String sql = "delete from proveedor where IDPROVEEDOR=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "PROVEEDOR ELIMINADO");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO EN LA ELIMINACION \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ClassProveedor buscarProveedor(String idproveedor) {
        String sql = "select * from comprador where dni=?";
        ClassProveedor cs = new ClassProveedor();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, idproveedor);
            rs = ps.executeQuery();
            while (rs.next()) {
                cs.setIdproveedor(rs.getString(1));
                cs.setSucursal(rs.getString(2));
                cs.setNombre(rs.getString(3));
                cs.setApellido(rs.getString(4));
                cs.setEmpresa(rs.getString(5));
                cs.setCelular(rs.getString(6));
                cs.setEstado(rs.getString(7));
                JOptionPane.showMessageDialog(null, "PROVEEDOR ENCONTRADO");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA EL ID \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return cs;
    }
    
}
