package controlador;

import modelo.personal.Administrador;
import modelo.personal.Cajero;

import vista.PanelPrincipal;
import vista.GestionDeOrdenes;
import vista.GestionDeVentas;
import vista.GestionDeClientes;
import vista.GestionDeProductos;
import vista.GestionDeCajeros;
import vista.PantallaLogin;

/**
 *
 * @author Davi
 */

public class CtrlPanelPrincipal {
    private Administrador modelo;
    private PanelPrincipal vista;

    public CtrlPanelPrincipal(Administrador modelo, PanelPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.asignarEventos();
        this.vista.setVisible(true);
    }
    
    private void asignarEventos(){
        vista.getButtonCerrarSesion().addActionListener( e -> this.irLogin() );
        
        vista.getButtonGestionarOrdenes().addActionListener( e -> this.irGestionOrdenes() );
        vista.getButtonGestionarVentas().addActionListener( e -> this.irGestionVentas() );
        vista.getButtonGestionarClientes().addActionListener( e -> this.irGestionClientes() );
        vista.getButtonGestionarProductos().addActionListener( e-> this.irGestionProductos() );
        vista.getButtonGestionarCajeros().addActionListener( e -> this.irGestionDeCajeros() );
    }
    
    public void irLogin(){
        var vistaLogin = new PantallaLogin();
        var ctrlLogin = new CtrlPantallaLogin( modelo, vistaLogin);
        
        vista.dispose();
    }
    
    public void irGestionOrdenes(){
        var vistaOrdenes = new GestionDeOrdenes();
        var ordenes = Cajero.getOrdenArreglo();
        
        var ctrlOrdenes = new CtrlGestionOrdenes( ordenes, vistaOrdenes, modelo);
        
        vista.dispose();
    }
    
    public void irGestionVentas(){
        var gestorVentas = new GestionDeVentas();
        gestorVentas.setVisible(true);
        
        vista.dispose();
    }
    
    public void irGestionClientes(){
        var gestorClientes = new GestionDeClientes();
        gestorClientes.setVisible(true);
        
        vista.dispose();
    }
    
    public void irGestionProductos(){
        var gestorProductos = new GestionDeProductos();
        
        gestorProductos.setVisible(true);
        
        vista.dispose();
    }
    
    public void irGestionDeCajeros(){
        var gestorCajeros = new GestionDeCajeros();
        gestorCajeros.setVisible(true);
        
        vista.dispose();
    }
}
