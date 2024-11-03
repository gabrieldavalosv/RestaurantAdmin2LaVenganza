package controlador;

import modelo.Administrador;
import vista.PanelPrincipal;
import vista.GestionDeOrdenes;
import vista.GestionDeVentas;
import vista.GestionDeClientes;
import vista.GestionDeProductos;
import vista.GestionDeCajeros;

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
    }
    
    private void asignarEventos(){
        vista.getButtonGestionOrdenes().addActionListener( e -> this.irGestionOrdenes() );
        vista.getButtonGestionVentas().addActionListener( e -> this.irGestionVentas() );
        vista.getButtonGestionClientes().addActionListener( e -> this.irGestionClientes() );
        vista.getButtonGestionProductos().addActionListener( e-> this.irGestionProductos() );
        vista.getButtonGestionCajeros().addActionListener( e -> this.irGestionDeCajeros() );
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
