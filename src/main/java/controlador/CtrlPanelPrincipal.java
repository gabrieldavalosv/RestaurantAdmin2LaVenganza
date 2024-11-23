package controlador;

import java.time.LocalDate;

import modelo.VentaArreglo;
import modelo.personal.Administrador;
import modelo.personal.Cajero;

import vista.*;

/**
 * @author Davi
 */

public class CtrlPanelPrincipal {
    private Administrador modelo;
    private PanelPrincipal vista;

    public CtrlPanelPrincipal(Administrador modelo, PanelPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.labelRol.setText("Rol: " + modelo.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + modelo.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + modelo.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        vista.buttonGestionarOrdenes.addActionListener(e -> this.irGestionOrdenes());
        vista.buttonGestionarVentas.addActionListener(e -> this.irGestionVentas());
        vista.buttonGestionarCajeros.addActionListener(e -> this.irGestionDeCajeros());
        vista.buttonCerrarSesion.addActionListener(e -> this.irLogin());

        this.vista.setVisible(true);
    }

    public void irLogin() {
        var vistaLogin = new PantallaLogin();
        var ctrlLogin = new CtrlPantallaLogin(modelo, vistaLogin);

        vista.dispose();
    }

    public void irGestionOrdenes() {
        var vistaOrdenes = new GestionDeOrdenes();
        var ordenes = Cajero.getOrdenArreglo();

        var ctrlOrdenes = new CtrlGestionDeOrdenes(ordenes, vistaOrdenes, modelo);

        vista.dispose();
    }

    public void irGestionVentas() {
        var gestorVentas = new GestionDeRegistroVentas();

        //Esto es para qe puedan ver la vista, no esta bien y debe ser cambiado
        var ventas = new VentaArreglo(20);

        var ctrlVentas = new CtrlGestionRegistroVentas(ventas, gestorVentas, modelo);
        vista.dispose();
    }

    public void irGestionDeCajeros() {
        var gestorCajeros = new GestionDeCajeros();
        var cajeros = modelo.getCajeroArreglo();

        var ctrlCajero = new CtrlGestionDeCajeros(cajeros, gestorCajeros, modelo);

        vista.dispose();
    }
}
