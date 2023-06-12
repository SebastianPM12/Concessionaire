/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassCompradores;
import Modelo.ClassRevision;
import Modelo.CompradoresDAO;
import Modelo.RevisionDAO;
import Vista.CompradoresForm;
import Vista.RevisionesForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEBAS
 */
public class ControladorRevision implements ActionListener {

    int id;
    RevisionesForm vista = new RevisionesForm();
    ClassRevision clase = new ClassRevision();
    RevisionDAO dao = new RevisionDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaRVE.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                id = Integer.parseInt(vista.tablaRVE.getValueAt(fila, 0).toString());
                String placa = vista.tablaRVE.getValueAt(fila, 1).toString();
                String descripcion = vista.tablaRVE.getValueAt(fila, 2).toString();
                String fecha = vista.tablaRVE.getValueAt(fila, 3).toString();

                vista.placaRC.setText(placa);
                vista.jTextArea1.setText(descripcion);
                vista.fecha.setText(fecha);

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

    public ControladorRevision(RevisionesForm vista, ClassRevision clase, RevisionDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.tablaRVE.addMouseListener(oyenteRaton);
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
        List<ClassRevision> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablaRVE.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdrevision();
            ob[1] = lista.get(i).getPlaca();
            ob[2] = lista.get(i).getDeescripcion();
            ob[3] = lista.get(i).getFecha();
            modelo.addRow(ob);
        }
        vista.tablaRVE.setModel(modelo);
    }

    void agregar() {

        if (vista.placaRC.getText().equals("") || vista.jTextArea1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
        } else {
            String placa = vista.placaRC.getText();
            String descripcion = vista.jTextArea1.getText();
            String fecha = vista.fecha.getText();
            Object[] o = new Object[3];
            o[0] = placa;
            o[1] = descripcion;
            o[2] = fecha;
            dao.add(o);
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
        }

    }

    void actualizar() {
        int fila = vista.tablaRVE.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            if (vista.placaRC.getText().equals("") || vista.jTextArea1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
            } else {
                String placa = vista.placaRC.getText();
                String descripcion = vista.jTextArea1.getText();
                Object[] o = new Object[3];
                o[0] = placa;
                o[1] = descripcion;
                o[2] = id;
                dao.actualizar(o);
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO EXITOSO");
            }

        }

    }

    void eliminar() {
        int fila = vista.tablaRVE.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminar(id);
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO EXITOSAMENTE");
        }
    }

    void nuevo() {
        LocalDate fecha = LocalDate.now();

        vista.placaRC.setText("");
        vista.jTextArea1.setText("");
        vista.fecha.setText(String.valueOf(fecha));
        vista.placaRC.requestFocus();
    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
