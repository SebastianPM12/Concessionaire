package Controlador;

import Modelo.ClassCompradores;
import Modelo.CompradoresDAO;
import Vista.CompradoresForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class ControladorCompradores implements ActionListener {

    String dni;

    CompradoresForm vista = new CompradoresForm();
    ClassCompradores clase = new ClassCompradores();
    CompradoresDAO dao = new CompradoresDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    MouseListener oyenteRaton = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablePres.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                String dni = vista.tablePres.getValueAt(fila, 0).toString();
                String nombres = vista.tablePres.getValueAt(fila, 1).toString();
                String apellido = vista.tablePres.getValueAt(fila, 2).toString();
                String direccion = vista.tablePres.getValueAt(fila, 3).toString();
                String edad = vista.tablePres.getValueAt(fila, 4).toString();
                String correo = vista.tablePres.getValueAt(fila, 5).toString();
                String genero = vista.tablePres.getValueAt(fila, 6).toString();
                String celular = vista.tablePres.getValueAt(fila, 7).toString();

                vista.txtDni.setText(dni);
                vista.txtnombre.setText(nombres);
                vista.txtApellido.setText(apellido);
                vista.txtDireccion.setText(direccion);
                vista.txtEdad.setText(edad);
                vista.txtCorreo.setText(correo);
                vista.cbGenero.setSelectedItem(genero);
                vista.txtCelular.setText(celular);

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

    public ControladorCompradores(CompradoresForm vista, ClassCompradores clase, CompradoresDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.tablePres.addMouseListener(oyenteRaton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas Seguro de agregar?", "Confirmar", dialogButton);
            if (dialogResult == 0) {
                agregar();
                limpiarTabla();
                listar();
                nuevo();
            }

        }
        if (e.getSource() == vista.btnNuevo) {
            nuevo();
        }
        if (e.getSource() == vista.btnActualizar) {

            actualizar();
            limpiarTabla();
            listar();
            nuevo();
        }
        if (e.getSource() == vista.btnEliminar) {

            eliminar();
            limpiarTabla();
            listar();
            nuevo();
        }

    }

    void listar() {
        List<ClassCompradores> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablePres.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getDni();
            ob[1] = lista.get(i).getNombres();
            ob[2] = lista.get(i).getApellidos();
            ob[3] = lista.get(i).getDireccion();
            ob[4] = lista.get(i).getEdad();
            ob[5] = lista.get(i).getCorreo();
            ob[6] = lista.get(i).getGenero();
            ob[7] = lista.get(i).getCelular();
            modelo.addRow(ob);
        }
        vista.tablePres.setModel(modelo);
    }

    void agregar() {

        if (vista.txtDni.getText().equals("") || vista.txtnombre.getText().equals("") || vista.txtApellido.getText().equals("") || vista.txtDireccion.getText().equals("") || vista.txtEdad.getText().equals("") || vista.txtCorreo.getText().equals("") || vista.cbGenero.getSelectedItem().toString().equals("SELECIONAR") || vista.txtCelular.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
        } else {
            String dni = vista.txtDni.getText();
            String nombres = vista.txtnombre.getText();
            String apellido = vista.txtApellido.getText();
            String direccion = vista.txtDireccion.getText();
            int edad = Integer.parseInt(vista.txtEdad.getText());
            String correo = vista.txtCorreo.getText();
            String genero = vista.cbGenero.getSelectedItem().toString();
            String celular = vista.txtCelular.getText();
            Object[] o = new Object[8];
            o[0] = dni;
            o[1] = nombres;
            o[2] = apellido;
            o[3] = direccion;
            o[4] = edad;
            o[5] = correo;
            o[6] = genero;
            o[7] = celular;
            dao.add(o);
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
        }

    }

    void actualizar() {
        int fila = vista.tablePres.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            if (vista.txtDni.getText().equals("") || vista.txtnombre.getText().equals("") || vista.txtApellido.getText().equals("") || vista.txtDireccion.getText().equals("") || vista.txtEdad.getText().equals("") || vista.txtCorreo.getText().equals("") || vista.cbGenero.getSelectedItem().toString().equals("SELECIONAR") || vista.txtCelular.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
            } else {
                String dni = vista.txtDni.getText();
                String nombres = vista.txtnombre.getText();
                String apellido = vista.txtApellido.getText();
                String direccion = vista.txtDireccion.getText();
                int edad = Integer.parseInt(vista.txtEdad.getText());
                String correo = vista.txtCorreo.getText();
                String genero = vista.cbGenero.getSelectedItem().toString();
                String celular = vista.txtCelular.getText();
                Object[] o = new Object[8];
                o[0] = nombres;
                o[1] = apellido;
                o[2] = direccion;
                o[3] = edad;
                o[4] = correo;
                o[5] = genero;
                o[6] = celular;
                o[7] = dni;
                dao.actualizar(o);
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO EXITOSO");
            }

        }

    }

    void eliminar() {
        int fila = vista.tablePres.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminar(Integer.parseInt(dni));
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO EXITOSAMENTE");
        }
    }

    void nuevo() {
        vista.txtDni.setText("");
        vista.txtnombre.setText("");
        vista.txtApellido.setText("");
        vista.txtDireccion.setText("");
        vista.txtEdad.setText("");
        vista.txtCorreo.setText("");
        vista.cbGenero.setSelectedIndex(0);
        vista.txtCelular.setText("");

    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

}
