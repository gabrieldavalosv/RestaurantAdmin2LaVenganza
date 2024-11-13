package controlador;

import modelo.OrdenArreglo;
import modelo.Orden;
import modelo.Menu;
import vista.GestionDeOrdenes;
import vista.PanelPrincipal;


import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.personal.Administrador;
import vista.GestionDeOrden;

/**
 *
 * @author Davi
 */

public class CtrlGestionDeOrdenes {
    GestionDeOrdenes vista;
    OrdenArreglo modelo;
    Administrador administrador;
    
    private Menu menu;
    
    public CtrlGestionDeOrdenes(OrdenArreglo modelo, GestionDeOrdenes vista,Administrador administrador){
        this.vista = vista;
        this.modelo = modelo;
        this.administrador = administrador;
        
        // Poniendo los titulos
        vista.labelFecha.setText( "Fecha: " + LocalDate.now().toString() );
        
        // Desplegando la tabla
        this.actualizarTablaOrdenes();
        
        // Asignando los eventos a los botones
        vista.buttonVolverPanel.addActionListener( e -> this.irPanelPrincipal() );
        vista.buttonAgregarOrden.addActionListener( e -> this.eventoAgregarOrden() );
        
        this.vista.setVisible(true);
    }
    
    private void irPanelPrincipal(){
        var vistaPanel = new PanelPrincipal();
        var ctrlPanel = new CtrlPanelPrincipal( administrador, vistaPanel );
        
        vista.dispose();
    }
    
    private void irGestionOrden(Orden orden){
        var vistaOrden = new GestionDeOrden();
        var ctrlOrden = new CtrlGestionDeOrden( orden, vistaOrden );
        
        vista.dispose();
    }
    
    private void actualizarTablaOrdenes() {
        var tablaOrdenes = (DefaultTableModel) vista.tablaOrdenes.getModel();
        tablaOrdenes.setRowCount(0);
        
        for(Orden o: modelo.getOrdenes() ){
            if( o != null ){
                tablaOrdenes.addRow(new Object[]{o.getId(), o.getCliente(), o.getEstado(), o.calcularPrecioTotal()});
            }
        }
        
        vista.tablaOrdenes.revalidate();
        vista.tablaOrdenes.repaint();
    }
    
    private void eventoAgregarOrden() {
        var ultimoId = String.valueOf( modelo.getIndex() );
        var cliente = vista.fieldCliente.getText();
        
        if( cliente.isEmpty() ){
            JOptionPane.showMessageDialog(vista, "Primero ingrese un nombre antes de registrar una nueva órden.");
            return;
        }
        
        // Instanciar la nueva orden
        Orden orden = new Orden( ultimoId, cliente);

        // Agregar orden al arreglo de ordenes (modelo)
        modelo.agregarOrden(orden);
        
        // Actualizar la tabla de ordenes
        var tablaOrdenes = (DefaultTableModel) vista.tablaOrdenes.getModel();
        
        if ( orden != null ) {
            tablaOrdenes.addRow(new Object[]{orden.getId(), orden.getCliente(), orden.getEstado(), orden.calcularPrecioTotal()});
            
            this.irGestionOrden(orden);
        }
        
        vista.fieldCliente.setText("");
    }
    
}
