package controlador;

import modelo.Administrador;
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
    }
    
    private void asignarEventos(){
        vista.getButtonIniciarSesion().addActionListener( e -> this.iniciarSesion() );
    }
    
    public void iniciarSesion(){
        var usuario = vista.getFieldUsuario().getText();
        var contrasenia = vista.getFieldContrasenia().getText();
        
        if ( usuario.equals("admin") && contrasenia.equals("123") ){
            JOptionPane.showMessageDialog(vista, "Credenciales correctas.\nProcediendo a iniciar sesion...");
            
            var panelPrincipal = new PanelPrincipal();
            
            panelPrincipal.setVisible(true);
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
