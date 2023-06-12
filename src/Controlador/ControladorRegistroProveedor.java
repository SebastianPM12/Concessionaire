/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassCompradores;
import Modelo.ClassProveedor;
import Modelo.CompradoresDAO;
import Modelo.ProveedorDAO;
import Vista.ProveedoresForm;
import Vista.RegistroComprador;
import Vista.RegistroProveedor;
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
public class ControladorRegistroProveedor implements ActionListener{
    RegistroProveedor vista = new RegistroProveedor();
    ClassProveedor clase = new ClassProveedor();
    ProveedorDAO dao = new ProveedorDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    int id;

    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaProveedoR.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                id = Integer.parseInt(vista.tablaProveedoR.getValueAt(fila, 0).toString());
                String dni = vista.tablaProveedoR.getValueAt(fila, 1).toString();
                String estado = vista.tablaProveedoR.getValueAt(fila, 2).toString();
                String nombres = vista.tablaProveedoR.getValueAt(fila, 3).toString();
                String apellido = vista.tablaProveedoR.getValueAt(fila, 4).toString();
                String direccion = vista.tablaProveedoR.getValueAt(fila, 5).toString();
                String edad = vista.tablaProveedoR.getValueAt(fila, 6).toString();
                String correo = vista.tablaProveedoR.getValueAt(fila, 7).toString();
                String genero = vista.tablaProveedoR.getValueAt(fila, 8).toString();
                String celular = vista.tablaProveedoR.getValueAt(fila, 9).toString();

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

     public ControladorRegistroProveedor(RegistroProveedor vista, ClassProveedor clase, ProveedorDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.bNuevo.addActionListener(this);
        this.vista.bBuscar.addActionListener(this);
        //this.vista.botonCerrar.addActionListener(this);
        this.vista.tablaProveedoR.addMouseListener(oyenteRaton);
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
        List<ClassProveedor> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablaProveedoR.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdproveedor();
            ob[1] = lista.get(i).getSucursal();
            ob[2] = lista.get(i).getNombre();
            ob[3] = lista.get(i).getApellido();
            ob[4] = lista.get(i).getEmpresa();
            ob[5] = lista.get(i).getCelular();
            ob[6] = lista.get(i).getEstado();
            modelo.addRow(ob);
        }
        vista.tablaProveedoR.setModel(modelo);
    }

   void nuevo() {
       vista.codRP.setText("");
       vista.codRP.requestFocus();
    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void buscar() {
        String idp = vista.codRP.getText();
        if (vista.codRP.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "DEBE PONER EL ID DEL VENDEDOR QUE BUSCA");
        } else {
            ClassProveedor cv = dao.buscarProveedor(idp);
            if (cv.getIdproveedor() != null) {
                limpiarTabla();
                modelo = (DefaultTableModel) vista.tablaProveedoR.getModel();
                Object[] ob = new Object[7];
                ob[0] = cv.getIdproveedor();
                ob[1] = cv.getSucursal();
                ob[2] = cv.getNombre();
                ob[3] = cv.getApellido();
                ob[4] = cv.getEmpresa();
                ob[5] = cv.getCelular();
                ob[6] = cv.getEstado();
                modelo.addRow(ob);
                vista.tablaProveedoR.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL VENDEDOR NO ESTA REGISTRADO");

            }

        }

    }

}
