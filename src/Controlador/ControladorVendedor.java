/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassCompradores;
import Modelo.ClassVendedor;
import Modelo.CompradoresDAO;
import Modelo.VendedoresDAO;
import Vista.CompradoresForm;
import Vista.VendedoresForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEBAS
 */
public class ControladorVendedor implements ActionListener {

    String idVendedor;
    VendedoresForm vista = new VendedoresForm();
    ClassVendedor clase = new ClassVendedor();
    VendedoresDAO dao = new VendedoresDAO();
    DefaultTableModel modelo = new DefaultTableModel();

    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaVendedor.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                idVendedor = vista.tablaVendedor.getValueAt(fila, 0).toString();
                String estado = vista.tablaVendedor.getValueAt(fila, 1).toString();
                String nombres = vista.tablaVendedor.getValueAt(fila, 2).toString();
                String apellido = vista.tablaVendedor.getValueAt(fila, 3).toString();
                String direccion = vista.tablaVendedor.getValueAt(fila, 4).toString();
                String edad = vista.tablaVendedor.getValueAt(fila, 5).toString();
                String correo = vista.tablaVendedor.getValueAt(fila, 6).toString();
                String genero = vista.tablaVendedor.getValueAt(fila, 7).toString();
                String celular = vista.tablaVendedor.getValueAt(fila, 8).toString();

                vista.idVe.setText(idVendedor);
                vista.cbmE.setSelectedItem(estado);
                vista.nameV.setText(nombres);
                vista.lastNameV.setText(apellido);
                vista.direccionV.setText(direccion);
                vista.ageV.setText(edad);
                vista.correoV.setText(correo);
                vista.cbmG.setSelectedItem(genero);
                vista.cel1V.setText(celular);

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

    public ControladorVendedor(VendedoresForm vista, ClassVendedor clase, VendedoresDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.bRegistrar.addActionListener(this);
        this.vista.bNuevo.addActionListener(this);
        this.vista.bModificar.addActionListener(this);
        this.vista.bEliminar.addActionListener(this);
        this.vista.bBuscar.addActionListener(this);
        //this.vista.botonCerrar.addActionListener(this);
        this.vista.tablaVendedor.addMouseListener(oyenteRaton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.bRegistrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas Seguro de agregar?", "Confirmar", dialogButton);
            if (dialogResult == 0) {
                agregar();
                limpiarTabla();
                listar();
                nuevo();
            }

        }
        if (e.getSource() == vista.bNuevo) {

            nuevo();
            limpiarTabla();
            listar();
        }
        if (e.getSource() == vista.bModificar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas Seguro de modificar?", "Confirmar", dialogButton);
            actualizar();
            limpiarTabla();
            listar();
            nuevo();
        }
        if (e.getSource() == vista.bEliminar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas Seguro de eliminar?", "Confirmar", dialogButton);
            eliminar();
            limpiarTabla();
            listar();
            nuevo();
        }
        if (e.getSource() == vista.bBuscar) {
            buscar();
        }

    }

    void listar() {
        List<ClassVendedor> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablaVendedor.getModel();
        Object[] ob = new Object[9];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdvendedor();
            ob[1] = lista.get(i).getEstado();
            ob[2] = lista.get(i).getNombres();
            ob[3] = lista.get(i).getApellidos();
            ob[4] = lista.get(i).getDireccion();
            ob[5] = lista.get(i).getEdad();
            ob[6] = lista.get(i).getCorreo();
            ob[7] = lista.get(i).getGenero();
            ob[8] = lista.get(i).getCelular();
            modelo.addRow(ob);
        }
        vista.tablaVendedor.setModel(modelo);
    }

    void agregar() {

        if (vista.idVe.getText().equals("") || vista.cbmE.getSelectedItem().toString().equals("...ESTADO...") || vista.nameV.getText().equals("") || vista.lastNameV.getText().equals("") || vista.direccionV.getText().equals("") || vista.ageV.getText().equals("") || vista.correoV.getText().equals("") || vista.cbmG.getSelectedItem().toString().equals("...GENERO...") || vista.cel1V.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
        } else {
            String idVe = vista.idVe.getText();
            String estado = vista.cbmE.getSelectedItem().toString();
            String nombres = vista.nameV.getText();
            String apellido = vista.lastNameV.getText();
            String direccion = vista.direccionV.getText();
            int edad = Integer.parseInt(vista.ageV.getText());
            String correo = vista.correoV.getText();
            String genero = vista.cbmG.getSelectedItem().toString();
            String celular = vista.cel1V.getText();
            Object[] o = new Object[9];
            o[0] = idVe;
            o[1] = estado;
            o[2] = nombres;
            o[3] = apellido;
            o[4] = direccion;
            o[5] = edad;
            o[6] = correo;
            o[7] = genero;
            o[8] = celular;
            dao.add(o);
        }
    }

    void actualizar() {
        int fila = vista.tablaVendedor.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            if (vista.idVe.getText().equals("") || vista.cbmE.getSelectedItem().toString().equals("...ESTADO...") || vista.nameV.getText().equals("") || vista.lastNameV.getText().equals("") || vista.direccionV.getText().equals("") || vista.ageV.getText().equals("") || vista.correoV.getText().equals("") || vista.cbmG.getSelectedItem().toString().equals("...GENERO...") || vista.cel1V.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
            } else {
                String estado = vista.cbmE.getSelectedItem().toString();
                String nombres = vista.nameV.getText();
                String apellido = vista.lastNameV.getText();
                String direccion = vista.direccionV.getText();
                int edad = Integer.parseInt(vista.ageV.getText());
                String correo = vista.correoV.getText();
                String genero = vista.cbmG.getSelectedItem().toString();
                String celular = vista.cel1V.getText();
                Object[] o = new Object[9];
                o[0] = estado;
                o[1] = nombres;
                o[2] = apellido;
                o[3] = direccion;
                o[4] = edad;
                o[5] = correo;
                o[6] = genero;
                o[7] = celular;
                o[8] = idVendedor;
                dao.actualizar(o);
            }

        }

    }

    void eliminar() {
        int fila = vista.tablaVendedor.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminarR(idVendedor);
        }
    }

    void nuevo() {
        vista.idVe.setText("");
        vista.cbmE.setSelectedIndex(0);
        vista.nameV.setText("");
        vista.lastNameV.setText("");
        vista.direccionV.setText("");
        vista.ageV.setText("");
        vista.correoV.setText("");
        vista.cbmG.setSelectedIndex(0);
        vista.cel1V.setText("");
        vista.idVe.setText("");
        vista.idVe.requestFocus();
    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void buscar() {
        String idp = vista.idRV.getText();
        if (vista.idRV.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "DEBE PONER EL ID DEL VENDEDOR QUE BUSCA");
        } else {
            ClassVendedor cv = dao.buscarVendedor(idp);
            if (cv.getIdvendedor() != null) {
                limpiarTabla();
                modelo = (DefaultTableModel) vista.tablaVendedor.getModel();
                Object[] ob = new Object[9];
                ob[0] = cv.getIdvendedor();
                ob[1] = cv.getEstado();
                ob[2] = cv.getNombres();
                ob[3] = cv.getApellidos();
                ob[4] = cv.getDireccion();
                ob[5] = cv.getEdad();
                ob[6] = cv.getCorreo();
                ob[7] = cv.getGenero();
                ob[8] = cv.getCelular();
                modelo.addRow(ob);
                vista.tablaVendedor.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL VENDEDOR NO ESTA REGISTRADO");

            }

        }

    }
}
