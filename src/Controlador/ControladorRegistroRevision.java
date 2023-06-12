/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassRevision;
import Modelo.ClassVendedor;
import Modelo.RevisionDAO;
import Vista.RegistroRevision;
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
public class ControladorRegistroRevision implements ActionListener{
    int id;
    RegistroRevision vista = new RegistroRevision();
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

    public ControladorRegistroRevision(RegistroRevision vista, ClassRevision clase, RevisionDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.bNuevo.addActionListener(this);
        this.vista.bBuscar.addActionListener(this);
        this.vista.tablaRVE.addMouseListener(oyenteRaton);
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

   

    void nuevo() {
        LocalDate fecha = LocalDate.now();
        vista.placaRV.setText("");
        vista.placaRV.requestFocus();
    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
     void buscar() {
        String idp = vista.placaRV.getText();
        if (vista.placaRV.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "DEBE PONER EL ID DEL VENDEDOR QUE BUSCA");
        } else {
            ClassRevision cv = dao.buscarRevision(idp);
            if (cv.getPlaca()!= null) {
                limpiarTabla();
                modelo = (DefaultTableModel) vista.tablaRVE.getModel();
                Object[] ob = new Object[4];
                ob[0] = cv.getIdrevision();
                ob[1] = cv.getPlaca();
                ob[2] = cv.getDeescripcion();
                ob[3] = cv.getFecha();
                modelo.addRow(ob);
                vista.tablaRVE.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL VENDEDOR NO ESTA REGISTRADO");

            }

        }

    }
    
}
