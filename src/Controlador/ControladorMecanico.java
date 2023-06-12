/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassMecanico;
import Modelo.ClassVendedor;
import Modelo.MecanicosDAO;
import Modelo.VendedoresDAO;
import Vista.MecanicosForm;
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
public class ControladorMecanico implements ActionListener {

    String idMecanico;

    MecanicosForm vista = new MecanicosForm();
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
                idMecanico = vista.tablaMC.getValueAt(fila, 0).toString();
                String estado = vista.tablaMC.getValueAt(fila, 1).toString();
                String turno = vista.tablaMC.getValueAt(fila, 2).toString();
                String nombres = vista.tablaMC.getValueAt(fila, 3).toString();
                String apellido = vista.tablaMC.getValueAt(fila, 4).toString();
                String direccion = vista.tablaMC.getValueAt(fila, 5).toString();
                String edad = vista.tablaMC.getValueAt(fila, 6).toString();
                String correo = vista.tablaMC.getValueAt(fila, 7).toString();
                String genero = vista.tablaMC.getValueAt(fila, 8).toString();
                String celular = vista.tablaMC.getValueAt(fila, 9).toString();

                vista.idM.setText(idMecanico);
                vista.cbME.setSelectedItem(estado);
                vista.cbMT.setSelectedItem(turno);
                vista.nameM.setText(nombres);
                vista.lastNameM.setText(apellido);
                vista.direccionM.setText(direccion);
                vista.ageM.setText(edad);
                vista.correoM.setText(correo);
                vista.cbMG.setSelectedItem(genero);
                vista.cellPM.setText(celular);
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

    public ControladorMecanico(MecanicosForm vista, ClassMecanico clase, MecanicosDAO dao) {
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
        this.vista.tablaMC.addMouseListener(oyenteRaton);
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
        //if(e.getSource() == vista.botonCerrar){
        //   vista.dispose();
        // }
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

    void agregar() {

        if (vista.idM.getText().equals("") || vista.cbME.getSelectedItem().toString().equals("...ESTADO...") || vista.cbMT.getSelectedItem().equals("...TURNO...")
                || vista.nameM.getText().equals("") || vista.lastNameM.getText().equals("") || vista.direccionM.getText().equals("")
                || vista.ageM.getText().equals("") || vista.correoM.getText().equals("")
                || vista.cbMG.getSelectedItem().toString().equals("...GENERO...") || vista.cellPM.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
        } else {
            String idM = vista.idM.getText();
            String estado = vista.cbME.getSelectedItem().toString();
            String turno = vista.cbMT.getSelectedItem().toString();
            String nombres = vista.nameM.getText();
            String apellido = vista.lastNameM.getText();
            String direccion = vista.direccionM.getText();
            int edad = Integer.parseInt(vista.ageM.getText());
            String correo = vista.correoM.getText();
            String genero = vista.cbMG.getSelectedItem().toString();
            String celular = vista.cellPM.getText();
            Object[] o = new Object[10];
            o[0] = idM;
            o[1] = estado;
            o[2] = turno;
            o[3] = nombres;
            o[4] = apellido;
            o[5] = direccion;
            o[6] = edad;
            o[7] = correo;
            o[8] = genero;
            o[9] = celular;
            dao.add(o);
        }
    }

    void actualizar() {
        int fila = vista.tablaMC.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            if (vista.idM.getText().equals("") || vista.cbME.getSelectedItem().toString().equals("...ESTADO...") || vista.cbMT.getSelectedItem().equals("...TURNO...")
                    || vista.nameM.getText().equals("") || vista.lastNameM.getText().equals("") || vista.direccionM.getText().equals("")
                    || vista.ageM.getText().equals("") || vista.correoM.getText().equals("")
                    || vista.cbMG.getSelectedItem().toString().equals("...GENERO...") || vista.cellPM.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
            } else {
                String estado = vista.cbME.getSelectedItem().toString();
                String turno = vista.cbMT.getSelectedItem().toString();
                String nombres = vista.nameM.getText();
                String apellido = vista.lastNameM.getText();
                String direccion = vista.direccionM.getText();
                int edad = Integer.parseInt(vista.ageM.getText());
                String correo = vista.correoM.getText();
                String genero = vista.cbMG.getSelectedItem().toString();
                String celular = vista.cellPM.getText();
                Object[] o = new Object[10];
                o[0] = estado;
                o[1] = turno;
                o[2] = nombres;
                o[3] = apellido;
                o[4] = direccion;
                o[5] = edad;
                o[6] = correo;
                o[7] = genero;
                o[8] = celular;
                o[9] = idMecanico;
                dao.actualizar(o);
            }

        }

    }

    void eliminar() {
        int fila = vista.tablaMC.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminarR(idMecanico);
        }
    }

    void nuevo() {
        vista.idM.setText("");
        vista.cbME.setSelectedIndex(0);
        vista.cbMT.setSelectedIndex(0);
        vista.nameM.setText("");
        vista.lastNameM.setText("");
        vista.direccionM.setText("");
        vista.ageM.setText("");
        vista.correoM.setText("");
        vista.cbMG.setSelectedIndex(0);
        vista.cellPM.setText("");
        vista.idM.setText("");
        vista.idM.requestFocus();
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
