package Controlador;

import Modelo.ClassContrato;
import Modelo.ContratoDAO;
import Vista.ContratoForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorContrato implements ActionListener {

    
    String numcontrato;
    ContratoForm vista = new ContratoForm();
    ClassContrato clase = new ClassContrato();
    ContratoDAO dao = new ContratoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    MouseListener oyenteRaton = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = vista.tablaContrato.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
            } else {
                 numcontrato = vista.tablaContrato.getValueAt(fila, 0).toString();
                String IDVendedor = vista.tablaContrato.getValueAt(fila, 1).toString();
                int id = Integer.parseInt(vista.tablaContrato.getValueAt(fila, 2).toString());
                String Placa = vista.tablaContrato.getValueAt(fila, 3).toString();
                String Descripcion = vista.tablaContrato.getValueAt(fila, 4).toString();
                String Fecha = vista.tablaContrato.getValueAt(fila, 5).toString();

                vista.txtContrato.setText(numcontrato);
                vista.txtIDVendedor.setText(IDVendedor);
                vista.txtPlaca.setText(Placa);
                vista.txtID.setText(String.valueOf(id));
                vista.textAreaDescripcion.setText(Descripcion);
                vista.fecha.setText(Fecha);
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

    public ControladorContrato(ContratoForm vista, ClassContrato clase, ContratoDAO dao) {
        this.vista = vista;
        this.clase = clase;
        this.dao = dao;
        listar();
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.tablaContrato.addMouseListener(oyenteRaton);
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
        List<ClassContrato> lista = dao.listar();
        modelo = (DefaultTableModel) vista.tablaContrato.getModel();
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
        vista.tablaContrato.setModel(modelo);
    }

    void agregar() {
        if (vista.txtContrato.getText().equals("") || vista.txtIDVendedor.getText().equals("")
                || vista.txtID.getText().equals("") || vista.txtPlaca.getText().equals("")
                || vista.textAreaDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
        } else {
            String numcontrato = vista.txtContrato.getText();
            String IDVendedor = vista.txtIDVendedor.getText();
            int ID = Integer.parseInt(vista.txtID.getText());
            String Placa = vista.txtPlaca.getText();
            String Descripcion = vista.textAreaDescripcion.getText();
            String fecha = vista.fecha.getText();
            Object[] o = new Object[6];
            o[0] = numcontrato;
            o[1] = IDVendedor;
            o[2] = ID;
            o[3] = Placa;
            o[4] = Descripcion;
            o[5] = fecha;
            dao.add(o);
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
        }
    }

    void actualizar() {
        int fila = vista.tablaContrato.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            if (vista.txtContrato.getText().equals("") || vista.txtIDVendedor.getText().equals("")
                    || vista.txtID.getText().equals("") || vista.txtPlaca.getText().equals("")
                    || vista.textAreaDescripcion.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "LLENAR TODOS LOS CAMPOS");
            } else {
                String IDVendedor = vista.txtIDVendedor.getText();
                String Placa = vista.txtPlaca.getText();
                String Descripcion = vista.textAreaDescripcion.getText();
                int ID= Integer.parseInt( vista.txtID.getText());
                String Fecha = vista.fecha.getText();
                Object[] o = new Object[6];
                o[0] = IDVendedor;
                o[1] = ID;
                o[2] = Placa;
                o[3] = Descripcion;
                o[4] = Fecha;
                o[5] = numcontrato;
                dao.actualizar(o);
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO EXITOSO");
            }
        }
    }

    void eliminar() {
        int fila = vista.tablaContrato.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA FILA");
        } else {
            dao.eliminarR(numcontrato);
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO EXITOSAMENTE");
        }
    }

    void nuevo() {
        vista.txtContrato.setText("");
        vista.txtIDVendedor.setText("");
        vista.txtID.setText("");
        vista.txtPlaca.setText("");
        vista.textAreaDescripcion.setText("");
    }

    void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
