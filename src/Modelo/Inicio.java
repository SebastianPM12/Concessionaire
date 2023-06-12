
package Modelo;

import Controlador.ControladorUsuarios;
import Vista.LoginForm;

/**
 *
 * @author 
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassUsuarios clase=new ClassUsuarios();
        UsuariosDAO dao=new UsuariosDAO();
        LoginForm vista = new LoginForm();
        ControladorUsuarios cu = new ControladorUsuarios(vista, dao, clase);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
}
