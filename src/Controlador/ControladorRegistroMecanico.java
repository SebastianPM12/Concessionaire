/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassMecanico;
import Modelo.ClassProveedor;
import Modelo.MecanicosDAO;
import Modelo.ProveedorDAO;
import Vista.RegistroMecanico;
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
public class ControladorRegistroMecanico implements ActionListener {

    RegistroMecanico vista = new RegistroMecanico();
    ClassMecanico clase = new ClassMecanico();
    MecanicosDAO dao = new MecanicosDAO();
    DefaultTableModel modelo = new DefaultTableModel();

    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaMC.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                String dni = vista.tablaMC.getValueAt(fila, 1).toString();
                String estado = vista.tablaMC.getValueAt(fila, 2).toString();
                String nombres = vista.tablaMC.getValueAt(fila, 3).toString();
                String apellido = vista.tablaMC.getValueAt(fila, 4).toString();
                String direccion = vista.tablaMC.getValueAt(fila, 5).toString();
                String edad = vista.tablaMC.getValueAt(fila, 6).toString();
                String correo = vista.tablaMC.getValueAt(fila, 7).toString();
                String genero = vista.tablaMC.getValueAt(fila, 8).toString();
                String celular = vista.tablaMC.getValueAt(fila, 9).toString();

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

    public ControladorRegistroMecanico(RegistroMecanico vista, ClassMecanico clase, MecanicosDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.bNuevo.addActionListener(this);
        this.vista.bBuscar.addActionListener(this);
        //this.vista.botonCerrar.addActionListener(this);
        this.vista.tablaMC.addMouseListener(oyenteRaton);
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
        List<ClassMecanico> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablaMC.getModel();
        Object[] ob = new Object[10];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdmecanico();
            ob[1] = lista.get(i).getEstado();
            ob[2] = lista.get(i).getTurno();
            ob[3] = lista.get(i).getNombres();
            ob[4] = lista.get(i).getApellidos();
            ob[5] = lista.get(i).getDireccion();
            ob[6] = lista.get(i).getEdad();
            ob[7] = lista.get(i).getCorreo();
            ob[8] = lista.get(i).getGenero();
            ob[9] = lista.get(i).getCelular();
            modelo.addRow(ob);
        }
        vista.tablaMC.setModel(modelo);
    }

    void nuevo() {
        vista.idRM .setText("");
        vista.idRM.requestFocus();
    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void buscar() {
        String idp = vista.idRM.getText();
        if (vista.idRM.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "DEBE PONER EL ID DEL VENDEDOR QUE BUSCA");
        } else {
            ClassMecanico cv = dao.buscarMecanico(idp);
            if (cv.getIdmecanico() != null) {
                limpiarTabla();
                modelo = (DefaultTableModel) vista.tablaMC.getModel();
                Object[] ob = new Object[10];
                ob[0] = cv.getIdmecanico();
                ob[1] = cv.getEstado();
                ob[2] = cv.getTurno();
                ob[3] = cv.getNombres();
                ob[4] = cv.getApellidos();
                ob[5] = cv.getDireccion();
                ob[6] = cv.getEdad();
                ob[7] = cv.getCorreo();
                ob[8] = cv.getGenero();
                ob[9] = cv.getCelular();
                modelo.addRow(ob);
                vista.tablaMC.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL VENDEDOR NO ESTA REGISTRADO");

            }

        }

    }
}
