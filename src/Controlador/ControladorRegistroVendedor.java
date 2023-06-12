/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassProveedor;
import Modelo.ClassVendedor;
import Modelo.ProveedorDAO;
import Modelo.VendedoresDAO;
import Vista.RegistroProveedor;
import Vista.RegistroVendedor;
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
public class ControladorRegistroVendedor implements ActionListener {

    RegistroVendedor vista = new RegistroVendedor();
    ClassVendedor clase = new ClassVendedor();
    VendedoresDAO dao = new VendedoresDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    int id;

    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaVendedor.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                id = Integer.parseInt(vista.tablaVendedor.getValueAt(fila, 0).toString());
                String dni = vista.tablaVendedor.getValueAt(fila, 1).toString();
                String estado = vista.tablaVendedor.getValueAt(fila, 2).toString();
                String nombres = vista.tablaVendedor.getValueAt(fila, 3).toString();
                String apellido = vista.tablaVendedor.getValueAt(fila, 4).toString();
                String direccion = vista.tablaVendedor.getValueAt(fila, 5).toString();
                String edad = vista.tablaVendedor.getValueAt(fila, 6).toString();
                String correo = vista.tablaVendedor.getValueAt(fila, 7).toString();
                String genero = vista.tablaVendedor.getValueAt(fila, 8).toString();
                String celular = vista.tablaVendedor.getValueAt(fila, 9).toString();

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

    public ControladorRegistroVendedor(RegistroVendedor vista, ClassVendedor clase, VendedoresDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.bNuevo.addActionListener(this);
        this.vista.bBuscar.addActionListener(this);
        //this.vista.botonCerrar.addActionListener(this);
        this.vista.tablaVendedor.addMouseListener(oyenteRaton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.bBuscar) {
            buscar();
        }
        if (e.getSource() == vista.bNuevo) {
            nuevo();
            limpiarTabla();
            listar();
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

    void nuevo() {
        vista.idRV.setText("");
        vista.idRV.requestFocus();
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
