package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RegistrosDAO implements CRUD{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ClassUsuarios> lista = new ArrayList<>();
        String sql = "select * from usuario";
        try{
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ClassUsuarios u = new ClassUsuarios();
                u.setID(rs.getInt(1));
                u.setEstado(rs.getString(2));
                u.setUser(rs.getString(3));
                u.setPass(rs.getString(4));
                u.setTipo(rs.getString(5));
                u.setNombres(rs.getString(6));
                u.setApellidos(rs.getString(7));
                u.setDireccion(rs.getString(8));
                u.setEdad(rs.getInt(9));
                u.setCorreo(rs.getString(10));
                u.setGenero(rs.getString(11));
                u.setCelular(rs.getString(12));
                lista.add(u);
            }
        }catch(Exception e){   
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into usuario(Usuario,Contraseña,Tipo,Nombres,Apellidos,Direccion,Edad,Correo,Genero,Celular) values(?,?,?,?,?,?,?,?,?,?)";
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
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
       int r = 0;
        String sql = "update usuario set Estado=?,Usuario=?,Contraseña=?,Tipo=?,Nombres=?,Apellidos=?,Direccion=?,Edad=?,Correo=?,Genero=?,Celular=? where ID=?";
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
            ps.setObject(11, o[10]);
            ps.setObject(12, o[11]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r; 
    }

    @Override
    public void eliminar(int ID) {
        String sql = "delete from usuario where ID=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    @Override
    public void eliminarR(String id) {
    }   
    public ClassUsuarios buscarUsuario(String ID) {
        String sql = "select * from usuario where id=?";
        ClassUsuarios u = new ClassUsuarios();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setID(rs.getInt(1));
                u.setEstado(rs.getString(2));
                u.setUser(rs.getString(3));
                u.setPass(rs.getString(4));
                u.setTipo(rs.getString(5));
                u.setNombres(rs.getString(6));
                u.setApellidos(rs.getString(7));
                u.setDireccion(rs.getString(8));
                u.setEdad(rs.getInt(9));
                u.setCorreo(rs.getString(10));
                u.setGenero(rs.getString(11));
                u.setCelular(rs.getString(12));
                JOptionPane.showMessageDialog(null, "USUARIO ENCONTRADO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HUBO UN FALLO, NO SE ENCUENTRA EL ID \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return u;
    }
}