package controlador;

import controlador.CtrlPanelPrincipal;
import vista.PanelPrincipal;
import vista.PantallaLogin;

import javax.swing.JOptionPane;
import modelo.personal.Administrador;
import modelo.personal.CajeroArreglo;
import modelo.personal.Trabajador;

/**
 * @author Davi
 */

public class CtrlPantallaLogin {
    private Trabajador modelo;
    private final PantallaLogin vista;

    public CtrlPantallaLogin(Trabajador modelo, PantallaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.asignarEventos();
        
        vista.setVisible(true);
    }


    private void asignarEventos() {
        vista.getButtonIniciarSesion().addActionListener(e -> this.iniciarSesion());
        vista.getjCheckBox1().addActionListener(e -> mostrarcontrasena());
    }

    public void iniciarSesion() {
        var usuario = vista.getFieldUsuario().getText();
        var contrasenia = vista.getFieldContrasenia().getText();
        
        // Loguear como administrador
        if ( Administrador.buscarAdmin(usuario, contrasenia) ) {
            var vistaPanel = new PanelPrincipal();
            var ctrlPanel = new CtrlPanelPrincipal( modelo, vistaPanel);

            vista.dispose();
        
        // Loguear como cajero
        }else{
            // Para comprueba si es un cajero
            var cajero = CajeroArreglo.buscarCajerosTxt(usuario, contrasenia);
            
            if( cajero != null ){
                var vistaPanel = new PanelPrincipal();
                var ctrlPanel = new CtrlPanelPrincipal( cajero, vistaPanel);
            
                vista.dispose();
                
            }else{
                JOptionPane.showMessageDialog(vista, "Usuario o contrasenia incorrectos.\nIntentar de nuevo");
            }
        }
        
    }

    public void mostrarcontrasena() {
        if (!vista.getjCheckBox1().isSelected()) {
            vista.getFieldContrasenia().setEchoChar((char) 0);
        } else {
            vista.getFieldContrasenia().setEchoChar('*');
        }
    }

    public void limpiarInputs() {
        vista.getFieldUsuario().setText("");
        vista.getFieldContrasenia().setText("");
    }
}
