package controlador;

import java.time.LocalDate;

import modelo.personal.Administrador;
import modelo.personal.CajeroArreglo;
import vista.*;

public class CtrlPanelPrincipal {
    private Administrador modelo;
    private PanelPrincipal vista;

    public CtrlPanelPrincipal(Administrador modelo, PanelPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Inicialización de datos en la vista
        vista.labelRol.setText("Rol: " + modelo.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + modelo.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + modelo.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        // Asociar eventos a los botones
        vista.buttonGestionarOrdenes.addActionListener(e -> this.irGestionOrdenes());
        vista.buttonGestionarVentas.addActionListener(e -> this.irGestionVentas());
        vista.buttonGestionarCajeros.addActionListener(e -> this.irGestionDeCajeros());
        vista.buttonCerrarSesion.addActionListener(e -> this.irLogin());

        this.vista.setVisible(true);
    }

    // Métodos de navegación
    public void irLogin() {
        var vistaLogin = new PantallaLogin();
        new CtrlPantallaLogin(modelo, vistaLogin);

        vista.dispose();
    }

    public void irGestionOrdenes() {
        var vistaOrdenes = new GestionDeOrdenes();
        var ordenes = modelo.getOrdenes(); // Método para obtener las órdenes desde el modelo

        new CtrlGestionDeOrdenes(ordenes, vistaOrdenes, modelo);

        vista.dispose();
    }

    public void irGestionVentas() {
        var gestorVentas = new GestionDeRegistroVentas();
        var ventas = modelo.getVentas(); // Método para obtener las ventas desde el modelo

        new CtrlGestionRegistroVentas(ventas, gestorVentas, modelo);

        vista.dispose();
    }

    public void irGestionDeCajeros() {
        var gestorCajeros = new GestionDeCajeros();
        var cajeros = modelo.getCajeroArreglo(); // Obtener el arreglo de cajeros desde el modelo

        new CtrlGestionDeCajeros(gestorCajeros, modelo);

        vista.dispose();
    }
}

