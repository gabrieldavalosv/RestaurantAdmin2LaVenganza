package controlador;

import modelo.personal.Administrador;
import vista.PantallaLogin;
import vista.PanelPrincipal;

import javax.swing.JOptionPane;

/**
 * 
 * @author Davi
*/

public class CtrlPantallaLogin {
    private Administrador modelo;
    private PantallaLogin vista;

    public CtrlPantallaLogin(Administrador modelo, PantallaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.asignarEventos();
        vista.setVisible(true);
    }
    
    private void asignarEventos(){
        vista.getButtonIniciarSesion().addActionListener( e -> this.iniciarSesion() );
    }
    
    public void iniciarSesion(){
        var usuario = vista.getFieldUsuario().getText();
        var contrasenia = vista.getFieldContrasenia().getText();
        
        if ( usuario.equals( modelo.getNombre() ) && contrasenia.equals( modelo.getContrasena() ) ){
            var vistaPanel = new PanelPrincipal();
            var ctrlPanel = new CtrlPanelPrincipal( modelo, vistaPanel);
            
            vista.dispose();
        }else{
            limpiarInputs();
            JOptionPane.showMessageDialog(vista, "Usuario o contrasenia incorrectos.\nIntentar de nuevo");
        }
    }
    
    public void limpiarInputs(){
        vista.getFieldUsuario().setText("");
        vista.getFieldContrasenia().setText("");
    }
}
