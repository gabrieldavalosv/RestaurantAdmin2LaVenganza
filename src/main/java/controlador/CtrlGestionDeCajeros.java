package controlador;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.personal.Administrador;
import modelo.personal.Cajero;
import modelo.personal.CajeroArreglo;
import vista.GestionDeCajeros;
import vista.PanelPrincipal;

public class CtrlGestionDeCajeros {
    GestionDeCajeros vista;
    CajeroArreglo modelo;
    Administrador administrador;

    public CtrlGestionDeCajeros(CajeroArreglo modelo, GestionDeCajeros vista, Administrador administrador) {
        this.vista = vista;
        this.modelo = modelo;
        this.administrador = administrador;

        vista.labelRol.setText("Rol: " + administrador.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + administrador.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + administrador.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());


        vista.buttonVolverPanel.addActionListener(e -> this.irPanelPrincipal());

        this.vista.setVisible(true);
    }

    private void irPanelPrincipal() {
        var vistaPanel = new PanelPrincipal();
        var ctrlPanel = new CtrlPanelPrincipal(administrador, vistaPanel);

        vista.dispose();
    }
}





