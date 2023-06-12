/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassCompradores;
import Modelo.ClassProveedor;
import Modelo.CompradoresDAO;
import Vista.CompradoresForm;
import Vista.RegistroComprador;
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
public class ControladorRegistroComprador implements ActionListener {

    RegistroComprador vista = new RegistroComprador();
    ClassCompradores clase = new ClassCompradores();
    CompradoresDAO dao = new CompradoresDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    int id;

    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaRcompra.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                id = Integer.parseInt(vista.tablaRcompra.getValueAt(fila, 0).toString());
                String dni = vista.tablaRcompra.getValueAt(fila, 1).toString();
                String estado = vista.tablaRcompra.getValueAt(fila, 2).toString();
                String nombres = vista.tablaRcompra.getValueAt(fila, 3).toString();
                String apellido = vista.tablaRcompra.getValueAt(fila, 4).toString();
                String direccion = vista.tablaRcompra.getValueAt(fila, 5).toString();
                String edad = vista.tablaRcompra.getValueAt(fila, 6).toString();
                String correo = vista.tablaRcompra.getValueAt(fila, 7).toString();
                String genero = vista.tablaRcompra.getValueAt(fila, 8).toString();
                String celular = vista.tablaRcompra.getValueAt(fila, 9).toString();

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

    public ControladorRegistroComprador(RegistroComprador vista, ClassCompradores clase, CompradoresDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.bNuevo.addActionListener(this);
        this.vista.bBuscar.addActionListener(this);
        this.vista.tablaRcompra.addMouseListener(oyenteRaton);
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
        List<ClassCompradores> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablaRcompra.getModel();
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
        vista.tablaRcompra.setModel(modelo);
    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void buscar() {
        String idp = vista.idCM.getText();
        if (vista.idCM.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "DEBE PONER EL ID DEL VENDEDOR QUE BUSCA");
        } else {
            ClassCompradores cv = dao.buscarComprador(idp);
            if (cv.getDni() != null) {
                limpiarTabla();
                modelo = (DefaultTableModel) vista.tablaRcompra.getModel();
                Object[] ob = new Object[8];
                ob[0] = cv.getDni();
                ob[1] = cv.getNombres();
                ob[2] = cv.getApellidos();
                ob[3] = cv.getDireccion();
                ob[4] = cv.getEdad();
                ob[5] = cv.getCorreo();
                ob[6] = cv.getGenero();
                ob[7] = cv.getCelular();
                modelo.addRow(ob);
                vista.tablaRcompra.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL VENDEDOR NO ESTA REGISTRADO");

            }

        }

    }

    void nuevo() {
        vista.idCM.setText("");
        vista.idCM.requestFocus();
    }

}
