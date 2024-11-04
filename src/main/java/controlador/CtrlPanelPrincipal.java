package controlador;

import modelo.personal.Administrador;
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

    public CtrlPanelPrincipal(PanelPrincipal vista) {
        this.vista = vista;
        
        this.asignarEventos();
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
        var login = new PantallaLogin();
        login.setVisible(true);
        
        vista.dispose();
    }
    
    public void irGestionOrdenes(){
        var gestorOrdenes = new GestionDeOrdenes();
        gestorOrdenes.setVisible(true);
        
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
