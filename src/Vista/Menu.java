/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorCarro;
import Controlador.ControladorCompradores;
import Controlador.ControladorContrato;
import Controlador.ControladorMecanico;
import Controlador.ControladorProveedor;
import Controlador.ControladorRegistroComprador;
import Controlador.ControladorRegistroContrato;
import Controlador.ControladorRegistroMecanico;
import Controlador.ControladorRegistroProveedor;
import Controlador.ControladorRegistroRevision;
import Controlador.ControladorRegistroVendedor;
import Controlador.ControladorRevision;
import Controlador.ControladorUsuarios;
import Controlador.ControladorVendedor;
import Modelo.Carro;
import Modelo.CarrosDAO;
import Modelo.ClassCompradores;
import Modelo.ClassContrato;
import Modelo.ClassMecanico;
import Modelo.ClassProveedor;
import Modelo.ClassRevision;
import Modelo.ClassUsuarios;
import Modelo.ClassVendedor;
import Modelo.CompradoresDAO;
import Modelo.ContratoDAO;
import Modelo.MecanicosDAO;
import Modelo.ProveedorDAO;
import Modelo.RegistrosDAO;
import Modelo.RevisionDAO;
import Modelo.UsuariosDAO;
import Modelo.VendedoresDAO;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author Pitt
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanePrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        userv = new javax.swing.JMenuItem();
        menuItemCompradores = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuItemVenta = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanePrincipalLayout = new javax.swing.GroupLayout(PanePrincipal);
        PanePrincipal.setLayout(PanePrincipalLayout);
        PanePrincipalLayout.setHorizontalGroup(
            PanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        PanePrincipalLayout.setVerticalGroup(
            PanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/iniciar-sesion (3).png"))); // NOI18N
        jMenu1.setText("LOGIN");
        jMenu1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/cerrar-sesion.png"))); // NOI18N
        jMenuItem8.setText("Salir");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/administracion.png"))); // NOI18N
        jMenu2.setText("ADMINISTRACION");
        jMenu2.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N

        userv.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        userv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/perfil.png"))); // NOI18N
        userv.setText("Usuarios");
        userv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uservActionPerformed(evt);
            }
        });
        jMenu2.add(userv);

        menuItemCompradores.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        menuItemCompradores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/comprador.png"))); // NOI18N
        menuItemCompradores.setText("Compradores");
        menuItemCompradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCompradoresActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemCompradores);

        jMenuItem5.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/proveedor.png"))); // NOI18N
        jMenuItem5.setText("Proveedores");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/mecanico.png"))); // NOI18N
        jMenuItem6.setText("Mecanicos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/agente.png"))); // NOI18N
        jMenuItem1.setText("Veendedores");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/punto-de-venta.png"))); // NOI18N
        jMenu3.setText("VENTAS");
        jMenu3.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N

        menuItemVenta.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        menuItemVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/contrato.png"))); // NOI18N
        menuItemVenta.setText("Contrato");
        menuItemVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVentaActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemVenta);

        jMenuItem2.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/coche.png"))); // NOI18N
        jMenuItem2.setText("Carros");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/mantenimiento.png"))); // NOI18N
        jMenu4.setText("MANTENIMIENTO");
        jMenu4.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/lista-de-verificacion.png"))); // NOI18N
        jMenuItem7.setText("Revision");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/reporte-de-negocios.png"))); // NOI18N
        jMenu5.setText("REPORTES");
        jMenu5.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/comprador.png"))); // NOI18N
        jMenuItem4.setText("Registro de los compradores");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem9.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/proveedor.png"))); // NOI18N
        jMenuItem9.setText("Registro de los proveedores");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/mecanico.png"))); // NOI18N
        jMenuItem10.setText("Registro de los mecanicos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/agente.png"))); // NOI18N
        jMenuItem11.setText("Registro de los veendedores");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/contrato.png"))); // NOI18N
        jMenuItem12.setText("Registro de los contratos");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem13.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/coche.png"))); // NOI18N
        jMenuItem13.setText("Registro de los carros");
        jMenu5.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos/lista-de-verificacion.png"))); // NOI18N
        jMenuItem14.setText("Registro de las revisiones");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanePrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        ClassUsuarios clase = new ClassUsuarios();
        UsuariosDAO dao = new UsuariosDAO();
        LoginForm vista = new LoginForm();
        ControladorUsuarios cu = new ControladorUsuarios(vista, dao, clase);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        CarrosForm vista = new CarrosForm();
        Carro clase = new Carro();
        CarrosDAO dao = new CarrosDAO();
        ControladorCarro control = new ControladorCarro(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuItemVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVentaActionPerformed
        ContratoForm vista = new ContratoForm();
        ClassContrato clase = new ClassContrato();
        ContratoDAO dao = new ContratoDAO();
        ControladorContrato control = new ControladorContrato(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();

    }//GEN-LAST:event_menuItemVentaActionPerformed

    private void menuItemCompradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCompradoresActionPerformed

        try {
            CompradoresForm vista = new CompradoresForm();
            ClassCompradores clase = new ClassCompradores();
            CompradoresDAO dao = new CompradoresDAO();
            ControladorCompradores control = new ControladorCompradores(vista, clase, dao);
            PanePrincipal.add(vista);
            vista.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_menuItemCompradoresActionPerformed

    private void uservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uservActionPerformed
        // TODO add your handling code here:
        UsuariosForm vista = new UsuariosForm();
        ClassUsuarios clase = new ClassUsuarios();
        RegistrosDAO dao = new RegistrosDAO();
        ControladorUsuarios control = new ControladorUsuarios(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_uservActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        VendedoresForm vista = new VendedoresForm();
        ClassVendedor clase = new ClassVendedor();
        VendedoresDAO dao = new VendedoresDAO();
        ControladorVendedor control = new ControladorVendedor(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        MecanicosForm vista = new MecanicosForm();
        ClassMecanico clase = new ClassMecanico();
        MecanicosDAO dao = new MecanicosDAO();
        ControladorMecanico control = new ControladorMecanico(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        ProveedoresForm vista = new ProveedoresForm();
        ClassProveedor clase = new ClassProveedor();
        ProveedorDAO dao = new ProveedorDAO();
        ControladorProveedor control = new ControladorProveedor(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        RevisionesForm vista = new RevisionesForm();
        ClassRevision clase = new ClassRevision();
        RevisionDAO dao = new RevisionDAO();
        ControladorRevision control = new ControladorRevision(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        RegistroProveedor vista = new RegistroProveedor();
        ClassProveedor clase = new ClassProveedor();
        ProveedorDAO dao = new ProveedorDAO();
        ControladorRegistroProveedor control = new ControladorRegistroProveedor(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        RegistroComprador vista = new RegistroComprador();
        ClassCompradores clase = new ClassCompradores();
        CompradoresDAO dao = new CompradoresDAO();
        ControladorRegistroComprador control = new ControladorRegistroComprador(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        RegistroMecanico vista = new RegistroMecanico();
        ClassMecanico clase = new ClassMecanico();
        MecanicosDAO dao = new MecanicosDAO();
        ControladorRegistroMecanico control = new ControladorRegistroMecanico(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        RegistroVendedor vista = new RegistroVendedor();
        ClassVendedor clase = new ClassVendedor();
        VendedoresDAO dao = new VendedoresDAO();
        ControladorRegistroVendedor control = new ControladorRegistroVendedor(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        RegistroRevision vista = new RegistroRevision();
        ClassRevision clase = new ClassRevision();
        RevisionDAO dao = new RevisionDAO();
        ControladorRegistroRevision control = new ControladorRegistroRevision(vista, clase, dao);
        PanePrincipal.add(vista);
        vista.show();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        RegistroContrato rv = new RegistroContrato();
        ContratoDAO ctdao = new ContratoDAO();
        ClassContrato ct = new ClassContrato();
        ControladorRegistroContrato control = new ControladorRegistroContrato(rv, ct, ctdao);
        PanePrincipal.add(rv);
        rv.show();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    void centrarVentana(JInternalFrame frame) {
        PanePrincipal.add(frame);
        Dimension dimension = PanePrincipal.getSize();
        Dimension Dframe = frame.getSize();
        frame.setLocation((dimension.width - Dframe.height) / 2, (dimension.height - Dframe.width) / 2);
        frame.show();
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane PanePrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem menuItemCompradores;
    private javax.swing.JMenuItem menuItemVenta;
    public javax.swing.JMenuItem userv;
    // End of variables declaration//GEN-END:variables
}
