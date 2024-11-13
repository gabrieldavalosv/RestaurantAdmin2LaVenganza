package controlador;

import java.time.LocalDate;
import modelo.personal.Administrador;
import modelo.personal.Cajero;

import vista.PanelPrincipal;
import vista.GestionDeOrdenes;
import vista.GestionDeVentas;
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
        
        // Poniendo los titulos
        vista.labelRol.setText( "Rol: Administrador");
        vista.labelNombreUsuario.setText( modelo.getNombre() );
        vista.labelIdUsuario.setText( modelo.getId() );
        vista.labelFecha.setText( LocalDate.now().toString() );
        
        // Asignando los eventos a los botones
        vista.buttonGestionarOrdenes.addActionListener( e -> this.irGestionOrdenes() );
        vista.buttonGestionarVentas.addActionListener( e -> this.irGestionVentas() );
        vista.buttonGestionarCajeros.addActionListener( e -> this.irGestionDeCajeros() );
        vista.buttonCerrarSesion.addActionListener( e -> this.irLogin() );
        
        this.vista.setVisible(true);
    }
    
    public void irLogin(){
        var vistaLogin = new PantallaLogin();
        var ctrlLogin = new CtrlPantallaLogin( modelo, vistaLogin);
        
        vista.dispose();
    }
    
    public void irGestionOrdenes(){
        var vistaOrdenes = new GestionDeOrdenes();
        var ordenes = Cajero.getOrdenArreglo();
        
        var ctrlOrdenes = new CtrlGestionDeOrdenes( ordenes, vistaOrdenes, modelo);
        
        vista.dispose();
    }
    
    public void irGestionVentas(){
        var gestorVentas = new GestionDeVentas();
        gestorVentas.setVisible(true);
        
        vista.dispose();
    }
    
    public void irGestionDeCajeros(){
        var gestorCajeros = new GestionDeCajeros();
        gestorCajeros.setVisible(true);
        
        vista.dispose();
    }
}
