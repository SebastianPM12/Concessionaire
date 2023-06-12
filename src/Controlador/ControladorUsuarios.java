
package Controlador;

import Modelo.ClassUsuarios;
import Modelo.RegistrosDAO;
import Modelo.UsuariosDAO;
import Vista.LoginForm;
import Vista.Menu;
import Vista.UsuariosForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pitt
 */
public class ControladorUsuarios implements ActionListener{
    LoginForm vista = new LoginForm();
    UsuariosForm vistaU = new UsuariosForm();
    ClassUsuarios clase = new ClassUsuarios();
    UsuariosDAO dao = new UsuariosDAO();
    RegistrosDAO daoU = new RegistrosDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    Menu m = new Menu();
    int ID;
    String estado;
    
    public ControladorUsuarios(LoginForm vista,UsuariosDAO dao,ClassUsuarios clase) {
        this.vista=vista;
        this.clase=clase;
        this.dao=dao;
        this.vista.btnIngresar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnSalir){
            System.exit(0);
        }
        if(e.getSource()==vista.btnIngresar){
            validar();
        }
        if (e.getSource() == vistaU.btnAgregar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas Seguro de agregar?", "Confirmar", dialogButton);
            if (dialogResult == 0) {
                agregar();
                limpiarTabla();
                listar();
                nuevo();
            }
        }
        if (e.getSource() == vistaU.btnNuevo) {
            nuevo();
        }
        if (e.getSource() == vistaU.btnActualizar) {
            actualizar();
            limpiarTabla();
            listar();
            nuevo();
        }
        if (e.getSource() == vistaU.btnEliminar) {
            eliminar();
            limpiarTabla();
            listar();
            nuevo();
        }
    }
    void listar() {
        List<ClassUsuarios> lista = daoU.listar();
        modelo = (DefaultTableModel) vistaU.tablaUsuario.getModel();
        Object[] ob = new Object[12];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getID();
            ob[1] = lista.get(i).getEstado();
            ob[2] = lista.get(i).getUser();
            ob[3] = lista.get(i).getPass();
            ob[4] = lista.get(i).getTipo();
            ob[5] = lista.get(i).getNombres();
            ob[6] = lista.get(i).getApellidos();
            ob[7] = lista.get(i).getDireccion();
            ob[8] = lista.get(i).getEdad();
            ob[9] = lista.get(i).getCorreo();
            ob[10] = lista.get(i).getGenero();
            ob[11] = lista.get(i).getCelular();
            modelo.addRow(ob);
        }
        vistaU.tablaUsuario.setModel(modelo);
    }
    void agregar() {
        if(vistaU.txtUsuario.getText().equals("") || vistaU.txtPass.getText().equals("") ||
           vistaU.cbTipo.getSelectedItem().toString().equals("...TIPO...") || vistaU.txtnombre.getText().equals("") ||
           vistaU.txtApellido.getText().equals("") || vistaU.txtDireccion.getText().equals("") ||
           vistaU.txtEdad.getText().equals("") || vistaU.txtCorreo.getText().equals("") ||
           vistaU.cbGenero.getSelectedItem().toString().equals("...SELECCIONAR...") || vistaU.txtCelular.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
        } else {
            String usuario = vistaU.txtUsuario.getText();
            String contraseña =  vistaU.txtPass.getText();
            String tipo = vistaU.cbTipo.getSelectedItem().toString();
            String nombres = vistaU.txtnombre.getText();
            String apellido = vistaU.txtApellido.getText();
            String direccion = vistaU.txtDireccion.getText();
            int edad = Integer.parseInt(vistaU.txtEdad.getText());
            String correo = vistaU.txtCorreo.getText();
            String genero = vistaU.cbGenero.getSelectedItem().toString();
            String celular = vistaU.txtCelular.getText();
            Object[] o = new Object[10];
            o[0] = usuario;
            o[1] = contraseña;
            o[2] = tipo;
            o[3] = nombres;
            o[4] = apellido;
            o[5] = direccion;
            o[6] = edad;
            o[7] = correo;
            o[8] = genero;
            o[9] = celular;
            daoU.add(o);
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
        }
    }
    void actualizar() {
        int fila = vistaU.tablaUsuario.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            if(vistaU.txtUsuario.getText().equals("") || vistaU.txtPass.getText().equals("") ||
           vistaU.cbTipo.getSelectedItem().toString().equals("...TIPO...") || vistaU.txtnombre.getText().equals("") ||
           vistaU.txtApellido.getText().equals("") || vistaU.txtDireccion.getText().equals("") ||
           vistaU.txtEdad.getText().equals("") || vistaU.txtCorreo.getText().equals("") ||
           vistaU.cbGenero.getSelectedItem().toString().equals("...SELECCIONAR...") || vistaU.txtCelular.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
            } else {
                String usuario = vistaU.txtUsuario.getText();
                String contraseña =  vistaU.txtPass.getText();
                String tipo = vistaU.cbTipo.getSelectedItem().toString();
                String nombres = vistaU.txtnombre.getText();
                String apellido = vistaU.txtApellido.getText();
                String direccion = vistaU.txtDireccion.getText();
                int edad = Integer.parseInt(vistaU.txtEdad.getText());
                String correo = vistaU.txtCorreo.getText();
                String genero = vistaU.cbGenero.getSelectedItem().toString();
                String celular = vistaU.txtCelular.getText();
                Object[] o = new Object[12];
                o[0] = usuario;
                o[1] = contraseña;
                o[2] = tipo;
                o[3] = nombres;
                o[4] = apellido;
                o[5] = direccion;
                o[6] = edad;
                o[7] = correo;
                o[8] = genero;
                o[9] = celular;
                o[10] = estado;
                o[11] = ID;
                daoU.actualizar(o);
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO EXITOSO");
            }
        }
    }
    void eliminar() {
        int fila = vistaU.tablaUsuario.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            daoU.eliminar(ID);
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO EXITOSAMENTE");
        }
    }
    void nuevo() {
        vistaU.txtUsuario.setText("");
        vistaU.txtPass.setText("");
        vistaU.cbTipo.setSelectedIndex(0);
        vistaU.txtnombre.setText("");
        vistaU.txtApellido.setText("");
        vistaU.txtDireccion.setText("");
        vistaU.txtEdad.setText("");
        vistaU.txtCorreo.setText("");
        vistaU.cbGenero.setSelectedIndex(0);
        vistaU.txtCelular.setText("");
    }
    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    } 
    public void validar(){
        String usuario = vista.txtUsuario.getText();
        String contraseña=vista.txtContraseña.getText();
        String tipo = vista.cbmT.getSelectedItem().toString();
        if(vista.txtUsuario.getText().equals("") || vista.txtContraseña.getText().equals("")|| vista.cbmT.getSelectedItem().toString().equals("...TIPO...")){
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
            vista.txtUsuario.requestFocus();
        }else{
            clase = dao.validarUsuario(usuario, contraseña);
            if(clase.getUser() != null && clase.getPass() != null ){
                JOptionPane.showMessageDialog(null, "BIENVENIDO");
                Menu m = new Menu();
                vista.dispose();
                m.setVisible(true);
                m.setLocationRelativeTo(null);
                if(clase.getTipo().equals("USUARIO")){
                    m.userv.setVisible(false);
                }else{
                    m.userv.setVisible(true);
                }       
         
            }else{
                JOptionPane.showMessageDialog(null, "Deben ingresar datos validos");
                limpiarCasillas();
                vista.txtUsuario.requestFocus();
            }
        }
    }
    public void limpiarCasillas(){
        vista.txtUsuario.setText("");
        vista.txtContraseña.setText("");
    }
    
    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vistaU.tablaUsuario.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                ID = Integer.parseInt(vistaU.tablaUsuario.getValueAt(fila, 0).toString());
                estado = vistaU.tablaUsuario.getValueAt(fila, 1).toString();
                String usuario = vistaU.tablaUsuario.getValueAt(fila, 2).toString();
                String contraseña = vistaU.tablaUsuario.getValueAt(fila, 3).toString();
                String tipo = vistaU.tablaUsuario.getValueAt(fila, 4).toString();
                String nombres = vistaU.tablaUsuario.getValueAt(fila, 5).toString();
                String apellidos = vistaU.tablaUsuario.getValueAt(fila, 6).toString();
                String direccion = vistaU.tablaUsuario.getValueAt(fila, 7).toString();
                String edad = vistaU.tablaUsuario.getValueAt(fila, 8).toString();
                String correo = vistaU.tablaUsuario.getValueAt(fila, 9).toString();
                String genero = vistaU.tablaUsuario.getValueAt(fila, 10).toString();
                String celular = vistaU.tablaUsuario.getValueAt(fila, 11).toString();

                vistaU.txtUsuario.setText(usuario);
                vistaU.txtPass.setText(contraseña);
                vistaU.cbTipo.setSelectedItem(tipo);
                vistaU.txtnombre.setText(nombres);
                vistaU.txtApellido.setText(apellidos);
                vistaU.txtDireccion.setText(direccion);
                vistaU.txtEdad.setText(edad);
                vistaU.txtCorreo.setText(correo);
                vistaU.cbGenero.setSelectedItem(genero);
                vistaU.txtCelular.setText(celular);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
    public ControladorUsuarios(UsuariosForm vista, ClassUsuarios clase, RegistrosDAO dao) {
        this.vistaU = vista;
        this.clase = clase;
        this.daoU = dao;
        listar();
        this.vistaU.btnAgregar.addActionListener(this);
        this.vistaU.btnNuevo.addActionListener(this);
        this.vistaU.btnActualizar.addActionListener(this);
        this.vistaU.btnEliminar.addActionListener(this);
        this.vistaU.tablaUsuario.addMouseListener(oyenteRaton);
    }
    
    
}
