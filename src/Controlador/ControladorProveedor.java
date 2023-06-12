/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClassMecanico;
import Modelo.ClassProveedor;
import Modelo.MecanicosDAO;
import Modelo.ProveedorDAO;
import Vista.MecanicosForm;
import Vista.ProveedoresForm;
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
public class ControladorProveedor implements ActionListener {

    String idProveedor;
    RegistroProveedor vitar = new RegistroProveedor();
    ProveedoresForm vista = new ProveedoresForm();
    ClassProveedor clase = new ClassProveedor();
    ProveedorDAO dao = new ProveedorDAO();
    ControladorRegistroProveedor vistap = new ControladorRegistroProveedor(vitar, clase, dao);
    DefaultTableModel modelo = new DefaultTableModel();
    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaProveedor.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                idProveedor = vista.tablaProveedor.getValueAt(fila, 0).toString();
                String sucursal = vista.tablaProveedor.getValueAt(fila, 1).toString();
                String nombre = vista.tablaProveedor.getValueAt(fila, 2).toString();
                String apellido = vista.tablaProveedor.getValueAt(fila, 3).toString();
                String empresa = vista.tablaProveedor.getValueAt(fila, 4).toString();
                String celular = vista.tablaProveedor.getValueAt(fila, 5).toString();
                String estado = vista.tablaProveedor.getValueAt(fila, 6).toString();

                vista.codeP.setText(idProveedor);
                vista.sucursalP.setText(sucursal);
                vista.nameP.setText(nombre);
                vista.lastNameP.setText(apellido);
                vista.cbE.setSelectedItem(empresa);
                vista.cellP.setText(celular);
                vista.cbES.setSelectedItem(estado);

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

    public ControladorProveedor(ProveedoresForm vista, ClassProveedor clase, ProveedorDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.btRegistrar.addActionListener(this);
        this.vista.bNuevo.addActionListener(this);
        this.vista.bModificar.addActionListener(this);
        this.vista.bEliminar.addActionListener(this);
        //this.vista.botonCerrar.addActionListener(this);
        this.vista.tablaProveedor.addMouseListener(oyenteRaton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btRegistrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas Seguro de agregar?", "Confirmar", dialogButton);
            if (dialogResult == 0) {
                agregar();
                limpiarTabla();
                listar();
                vistap.limpiarTabla();
                vistap.listar();
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
            vistap.limpiarTabla();
            vistap.listar();
            eliminar();
            limpiarTabla();
            listar();
            nuevo();
        }
       
        //if(e.getSource() == vista.botonCerrar){
        //   vista.dispose();
        // }
    }

    void listar() {
        List<ClassProveedor> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablaProveedor.getModel();
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
        vista.tablaProveedor.setModel(modelo);
    }

    void agregar() {
        if (vista.codeP.getText().equals("") || vista.cbE.getSelectedItem().toString().equals("...EMPRESA...") || vista.cbES.getSelectedItem().equals("...ESTADO...")
                || vista.nameP.getText().equals("") || vista.lastNameP.getText().equals("") || vista.sucursalP.getText().equals("")
                || vista.cellP.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
        } else {
            String idM = vista.codeP.getText();
            String sucursal = vista.sucursalP.getText();
            String nombres = vista.nameP.getText();
            String apellido = vista.lastNameP.getText();
            String empresa = vista.cbE.getSelectedItem().toString();
            String celular = vista.cellP.getText();
            String estado = vista.cbES.getSelectedItem().toString();
            Object[] o = new Object[7];
            o[0] = idM;
            o[1] = sucursal;
            o[2] = nombres;
            o[3] = apellido;
            o[4] = empresa;
            o[5] = celular;
            o[6] = estado;
            dao.add(o);
        }
    }

    void actualizar() {
        int fila = vista.tablaProveedor.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            if (vista.codeP.getText().equals("") || vista.cbE.getSelectedItem().toString().equals("...EMPRESA...") || vista.cbES.getSelectedItem().equals("...ESTADO...")
                    || vista.nameP.getText().equals("") || vista.lastNameP.getText().equals("") || vista.sucursalP.getText().equals("")
                    || vista.cellP.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
            } else {
                String sucursal = vista.sucursalP.getText();
                String nombres = vista.nameP.getText();
                String apellido = vista.lastNameP.getText();
                String empresa = vista.cbE.getSelectedItem().toString();
                String celular = vista.cellP.getText();
                String estado = vista.cbES.getSelectedItem().toString();
                Object[] o = new Object[7];
                o[0] = sucursal;
                o[1] = nombres;
                o[2] = apellido;
                o[3] = empresa;
                o[4] = celular;
                o[5] = estado;
                o[6] = idProveedor;
                dao.actualizar(o);
            }

        }

    }

    void eliminar() {
        int fila = vista.tablaProveedor.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminarR(idProveedor);
        }
    }

    void nuevo() {
        vista.codeP.setText("");
        vista.sucursalP.setText("");
        vista.nameP.setText("");
        vista.lastNameP.setText("");
        vista.cbE.setSelectedIndex(0);
        vista.cellP.setText("");
        vista.cbES.setSelectedIndex(0);
        vista.codeP.setText("");
        vista.codeP.requestFocus();
    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

   

}
