package controlador;

import java.time.LocalDate;

import modelo.Menu;
import modelo.personal.Administrador;

import modelo.personal.Trabajador;
import vista.*;

public class CtrlPanelPrincipal {
    private Trabajador modelo;
    private PanelPrincipal vista;

    public CtrlPanelPrincipal(Trabajador modelo, PanelPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Inicialización de datos en la vista
        vista.labelRol.setText("Rol: " + modelo.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + modelo.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + modelo.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        // Asociar eventos a los botones
        vista.buttonGestionarOrdenes.addActionListener(e -> this.irGestionOrdenes());
        vista.buttonGestionarMenu.addActionListener(e -> this.irGestionDeMenu());
        vista.buttonGestionarCajeros.addActionListener(e -> this.irGestionDeCajeros());
        vista.buttonGestionarVentas.addActionListener(e -> this.irGestionVentas());
        vista.buttonCerrarSesion.addActionListener(e -> this.irLogin());
        
        // Gestionar permisos
        if ( modelo.getRol().equals("Cajero") ){
            vista.buttonGestionarCajeros.setEnabled(false);
            vista.buttonGestionarMenu.setEnabled(false);
        }

        this.vista.setVisible(true);
    }
    
    // Métodos de navegación
    public void irLogin() {
        var vistaLogin = new PantallaLogin();
        
        var ctrlPantallaLogin = new CtrlPantallaLogin(vistaLogin);

        vista.dispose();
    }

    public void irGestionOrdenes() {
        var vistaOrdenes = new GestionDeOrdenes();
        var ordenes = modelo.getOrdenes(); // Metodo para obtener las órdenes desde el modelo
        
        var ctrlGestionDeOrdenes = new CtrlGestionDeOrdenes(ordenes, vistaOrdenes, modelo);

        vista.dispose();
    }

    public void irGestionDeCajeros() {
        var gestorCajeros = new GestionDeCajeros();
        var admin = new Administrador(modelo);
        
        var ctrlGestionDeCajeros = new CtrlGestionDeCajeros(gestorCajeros, admin);

        vista.dispose();
    }

    public void irGestionDeMenu() {
        var gestorMenu = new GestionDelMenu();
        var menu = new Menu();
        var admin = new Administrador(modelo);

        var ctrlGestionDeMenu = new CtrlGestionDeMenu(admin, menu, gestorMenu);

        vista.dispose();
    }

    public void irGestionVentas() {
        var gestorVentas = new GestionDeRegistroVentas();
        var ventas = modelo.getVentas(); // Metodo para obtener las ventas desde el modelo

        var ctrlGestionRegistroVentas = new CtrlGestionRegistroVentas(ventas, gestorVentas, modelo);

        vista.dispose();
    }
}

