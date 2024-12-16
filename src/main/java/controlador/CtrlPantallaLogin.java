package controlador;

import vista.PanelPrincipal;

import javax.swing.JOptionPane;
import modelo.personal.Administrador;
import modelo.personal.CajeroArreglo;
import modelo.personal.Trabajador;
import vista.PantallaLogin;

/**
 * @author Davi
 */

public class CtrlPantallaLogin {
    private final PantallaLogin vista;

    public CtrlPantallaLogin(PantallaLogin vista) {
        this.vista = vista;

        this.asignarEventos();

        vista.setVisible(true);
    }

    private void asignarEventos() {
        vista.getButtonIniciarSesion().addActionListener(e -> this.iniciarSesion());
        vista.getjCheckBox1().addActionListener(e -> mostrarcontrasena());
    }

    public void iniciarSesion() {
        String usuario = vista.getFieldUsuario().getText();
        String contrasenia = vista.getFieldContrasenia().getText();

        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese un usuario y una contraseña.");
            return;
        }

        try {
            Trabajador modelo = null;

            if (Administrador.buscarAdmin(usuario, contrasenia)) {
                modelo = new Administrador(usuario, contrasenia);
            } else {
                var cajero = CajeroArreglo.buscarCajerosTxt(usuario, contrasenia);
                if (cajero != null) {
                    modelo = cajero;
                } else {
                    JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos.");
                    return;
                }
            }

            var vistaPanel = new PanelPrincipal();
            var ctrlPanel = new CtrlPanelPrincipal(modelo, vistaPanel);

            vista.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al iniciar sesión: " + e.getMessage());
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