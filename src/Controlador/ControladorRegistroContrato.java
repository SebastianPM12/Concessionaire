/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassCompradores;
import Modelo.ClassContrato;
import Modelo.ContratoDAO;
import Vista.RegistroContrato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SEBAS
 */
public class ControladorRegistroContrato implements ActionListener {

    RegistroContrato vista = new RegistroContrato();
    ClassContrato cst = new ClassContrato()  ;
    ContratoDAO cdao = new ContratoDAO() ; 
    DefaultTableModel modelo = new DefaultTableModel();
    String key;

    public ControladorRegistroContrato(RegistroContrato vista, ClassContrato cst, ContratoDAO cdao) {
        this.vista = vista;
        this.cst = cst;
        this.cdao = cdao;
        listar();
        this.vista.bNuevo.addActionListener(this);
        this.vista.bBuscar.addActionListener(this);
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
        List<ClassContrato> lista = cdao.listar();
        modelo = (DefaultTableModel) vista.tablaRcompra.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getContrato();
            ob[1] = lista.get(i).getIDVendedor();
            ob[2] = lista.get(i).getDni();
            ob[3] = lista.get(i).getPlaca();
            ob[4] = lista.get(i).getDescripcion();
            ob[5] = lista.get(i).getFecha();
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
        String idp = vista.nmKEY.getText();
        if (vista.nmKEY.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "DEBE PONER EL DOCUMENTO QUE BUSCA");
        } else {
            ClassContrato cv = cdao.buscarContrato(idp);
            if (cv.getDni() != null) {
                limpiarTabla();
                modelo = (DefaultTableModel) vista.tablaRcompra.getModel();
                Object[] ob = new Object[6];
                ob[0] = cv.getContrato();
                ob[1] = cv.getIDVendedor();
                ob[2] = cv.getDni();
                ob[3] = cv.getPlaca();
                ob[4] = cv.getDescripcion();
                ob[5] = cv.getFecha();
                modelo.addRow(ob);
                vista.tablaRcompra.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL VENDEDOR NO ESTA REGISTRADO");

            }

        }

    }

    void nuevo() {
        vista.nmKEY.setText("");
        vista.nmKEY.requestFocus();
    }

}
