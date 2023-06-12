/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Carro;
import Modelo.CarrosDAO;
import Modelo.ClassMecanico;
import Modelo.MecanicosDAO;
import Vista.CarrosForm;
import Vista.MecanicosForm;
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
public class ControladorCarro implements ActionListener {

    String placa;

    CarrosForm vista = new CarrosForm();
    Carro clase = new Carro();
    CarrosDAO dao = new CarrosDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaCarro.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                String tipo = vista.tablaCarro.getValueAt(fila, 0).toString();
                placa = vista.tablaCarro.getValueAt(fila, 1).toString();
                String marca = vista.tablaCarro.getValueAt(fila, 2).toString();
                String precio =vista.tablaCarro.getValueAt(fila, 3).toString();
                String color = vista.tablaCarro.getValueAt(fila, 4).toString();
                String año = vista.tablaCarro.getValueAt(fila, 5).toString();
                vista.cbT.setSelectedItem(tipo);
                vista.placaC.setText(placa);
                vista.cbMA.setSelectedItem(marca);
                vista.priceC.setText(String.valueOf(precio));
                vista.cbC.setSelectedItem(color);
                vista.cbA.setSelectedItem(String.valueOf(año));
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

    public ControladorCarro(CarrosForm vista, Carro clase, CarrosDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.bBuscar.addActionListener(this);
        //this.vista.botonCerrar.addActionListener(this);
        this.vista.tablaCarro.addMouseListener(oyenteRaton);
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
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas Seguro de modificar?", "Confirmar", dialogButton);
            actualizar();
            limpiarTabla();
            listar();
            nuevo();
        }
        if (e.getSource() == vista.btnEliminar) {
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
        List<Carro> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablaCarro.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getTipo();
            ob[1] = lista.get(i).getPlaca();
            ob[2] = lista.get(i).getMarca();
            ob[3] = lista.get(i).getPrecio();
            ob[4] = lista.get(i).getColor();
            ob[5] = lista.get(i).getAño();
            modelo.addRow(ob);
        }
        vista.tablaCarro.setModel(modelo);
    }

    void agregar() {

        if (vista.placaC.getText().equals("") || vista.cbA.getSelectedItem().toString().equals("...AÑO...")
                || vista.cbC.getSelectedItem().toString().equals("...COLOR...")
                || vista.cbMA.getSelectedItem().toString().equals("...MARCA...")
                || vista.cbT.getSelectedItem().toString().equals("...TIPO...")
                || vista.priceC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
        } else {
            String tipo = vista.cbT.getSelectedItem().toString();
            String placa = vista.placaC.getText();
            String marca = vista.cbMA.getSelectedItem().toString();
            double precio = Double.parseDouble(vista.priceC.getText());
            String color = vista.cbC.getSelectedItem().toString();
            int año = Integer.parseInt(vista.cbA.getSelectedItem().toString());
            Object[] o = new Object[6];
            o[0] = tipo;
            o[1] = placa;
            o[2] = marca;
            o[3] = precio;
            o[4] = color;
            o[5] = año;
            dao.add(o);
        }
    }

    void actualizar() {
        int fila = vista.tablaCarro.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            if (vista.placaC.getText().equals("") || vista.cbA.getSelectedItem().toString().equals("...AÑO...")
                    || vista.cbC.getSelectedItem().toString().equals("...COLOR...")
                    || vista.cbMA.getSelectedItem().toString().equals("...MARCA...")
                    || vista.cbT.getSelectedItem().toString().equals("...TIPO...")
                    || vista.priceC.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
            } else {
                String tipo = vista.cbT.getSelectedItem().toString();
                String marca = vista.cbMA.getSelectedItem().toString();
                double precio = Double.parseDouble(vista.priceC.getText());
                String color = vista.cbC.getSelectedItem().toString();
                int año = Integer.parseInt(vista.cbA.getSelectedItem().toString());

                Object[] o = new Object[6];
                o[0] = tipo;
                o[1] = marca;
                o[2] = precio;
                o[3] = color;
                o[4] = año;
                o[5] = placa;
                dao.actualizar(o);
            }

        }

    }

    void eliminar() {
        int fila = vista.tablaCarro.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminarR(placa);
        }
    }

    void nuevo() {
        vista.placaC.setText("");
        vista.cbA.setSelectedIndex(0);
        vista.cbC.setSelectedIndex(0);
        vista.cbMA.setSelectedIndex(0);
        vista.cbT.setSelectedIndex(0);
        vista.priceC.setText("");
        vista.placaC.requestFocus();
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
            JOptionPane.showMessageDialog(null, "DEBE PONER LA PALCA DEL CARRO QUE BUSCA");
        } else {
            Carro cv = dao.buscarCarro(idp);
            if (cv.getPlaca() != null) {
                limpiarTabla();
                modelo = (DefaultTableModel) vista.tablaCarro.getModel();
                Object[] ob = new Object[6];
                ob[0] = cv.getTipo();
                ob[1] = cv.getPlaca();
                ob[2] = cv.getMarca();
                ob[3] = cv.getPrecio();
                ob[4] = cv.getColor();
                ob[5] = cv.getAño();
                modelo.addRow(ob);
                vista.tablaCarro.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL CARRO NO ESTA REGISTRADO");

            }

        }
    }
}
