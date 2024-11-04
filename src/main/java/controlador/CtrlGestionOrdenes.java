package controlador;

import modelo.OrdenArreglo;
import modelo.Orden;
import modelo.Menu;
import modelo.Producto;

import vista.GestionDeOrdenes;
import vista.PanelPrincipal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Davi
 */

public class CtrlGestionOrdenes {
    GestionDeOrdenes vista;
    OrdenArreglo modelo;
    
    private Orden orden;
    private String fecha;
    private Menu menu;
    
    public CtrlGestionOrdenes(GestionDeOrdenes vista){
        this.vista = vista;
        this.modelo = new OrdenArreglo(10);
        
        this.asignarEventos();
        this.mostrarTitulos();
    }
    
    private void asignarEventos(){
        vista.getButtonAgregarOrden().addActionListener( e -> this.eventoAgregarOrden() );
        vista.getButtonVolverPanel().addActionListener( e -> this.irPanelPrincipal() );
        vista.getButtonBuscarOrden().addActionListener( e -> this.eventoBuscarOrden() );
        vista.getButtonCancelarOrden().addActionListener( e -> this.eventoCancelarOrden() );
        
        // Frame de órden
        vista.getButtonAgregarProducto().addActionListener( e -> this.eventoAgregarProducto() );
    }
    
    private void mostrarTitulos(){
        // Mostrar la fecha actual
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        fecha = fechaActual.format(formatoFecha);
        vista.getLabelTituloFecha().setText( "Fecha: " + fecha );
    }
    
    private void irPanelPrincipal(){
        var panelPrincipal = new PanelPrincipal();
        
        panelPrincipal.setVisible(true);
        vista.dispose();
    }
    
    private void eventoAgregarOrden(){
        var ultimoId = String.valueOf( modelo.getIndex() );
        var cliente = vista.getFieldCliente().getText();
        
        if( cliente.isEmpty() ){
            JOptionPane.showMessageDialog(vista, "Primero ingrese un nombre antes de registrar una nueva órden.");
            return;
        }
        
        // Instanciar la nueva orden
        orden = new Orden( ultimoId, cliente);

        // Agregar orden al arreglo de ordenes (modelo)
        modelo.agregarOrden(orden);
        
        // Actualizar la tabla de ordenes
        var tablaOrdenes = (DefaultTableModel) vista.getTablaOrdenes().getModel();
        
        if (orden != null) {
            tablaOrdenes.addRow(new Object[]{orden.getId(), orden.getCliente(), orden.getEstado(), orden.calcularPrecioTotal()});
        }
        
        vista.getFieldCliente().setText("");
    }
    
    private void eventoBuscarOrden(){
        var idOrden = vista.getFieldIdOrden().getText();
        
        if( idOrden.isEmpty() ){
            JOptionPane.showMessageDialog(vista, "Por favor, primero ingrese un id de una órden.");
            return;
        }
        
        orden = modelo.buscarOrden(idOrden);
        
        if( orden != null ){
            mostrarDatosOrden();
            
            vista.getFrameOrden().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(vista, "La órden con id " + idOrden + " no fue encontrada...");
        }
        
        vista.getFieldIdOrden().setText("");
    }
    
    private void eventoCancelarOrden(){
        var idOrden = vista.getFieldIdOrden().getText();
        
        if( idOrden.isEmpty() ){
            JOptionPane.showMessageDialog(vista, "Por favor, primero ingrese un id de una órden.");
            return;
        }
        
        orden = modelo.buscarOrden(idOrden);
        
        if( orden != null ){
            var tablaOrdenes = (DefaultTableModel) vista.getTablaOrdenes().getModel();
            tablaOrdenes.removeRow( Integer.parseInt( idOrden ) );
            
            modelo.eliminarOrden(idOrden);
            
            // Limpiar todas las filas de la tabla
            tablaOrdenes.setRowCount(0);
        
            // Volver a agregar todas las órdenes desde el arreglo al JTable
            for (int i = 0; i < modelo.getIndex(); i++) {
                Orden o = modelo.getOrdenes()[i];
                
                tablaOrdenes.addRow(new Object[]{ o.getId(), o.getCliente(), o.getEstado(), o.calcularPrecioTotal() });
            }
            
        }else{
            JOptionPane.showMessageDialog(vista, "La órden con id " + idOrden + " no fue encontrada...");
        }
        
        vista.getFieldIdOrden().setText("");
    }
    
    // Eventos frame de orden
    private void mostrarDatosOrden(){
        // Orden, Cliente, total y fecha
        vista.getLabelTituloOrden().setText("Gestión de Órden ID(" + orden.getId() + ")" );
        vista.getLabelOrdenCliente().setText("Cliente: " + orden.getCliente() );
        vista.getLabelOrdenTotal().setText("Total: " + orden.calcularPrecioTotal() );
        vista.getLabelTituloMenu().setText("Menú " + fecha );
        
        // Mostrar el menu
        menu = new Menu();
        
        var listaProductos = menu.getProductoArreglo().getProductos();
        var tablaMenu = (DefaultTableModel) vista.getTablaMenu().getModel();
        
        for(int i=0; i < menu.getProductoArreglo().getIndex(); i++ ){
            Producto p = listaProductos[i];
            
            tablaMenu.addRow( new Object[]{ p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio() });
        }
    }
    
    private void eventoAgregarProducto(){
        var idProducto = vista.getFieldIdProducto().getText();
        
        if( idProducto.isEmpty() ){
            JOptionPane.showMessageDialog(vista.getFrameOrden(), "Por favor, primero ingrese un id de un producto.");
            return;
        }
        
        // Agregar orden al arreglo de ordenes (modelo)
        Producto producto = menu.getProductoArreglo().buscarProducto(idProducto);
        
        // Actualizar la tabla de ordenes
        if (producto != null) {
            orden.agregarProductoALaOrden(idProducto);
            
            var tablaProductos = (DefaultTableModel) vista.getTablaOrdenProductos().getModel();
            tablaProductos.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCategoria(), producto.getPrecio() });
        }else{
            JOptionPane.showMessageDialog(vista.getFrameOrden(), "El producto con id " + idProducto + " no fue encontrado...");
        }
        
        vista.getFieldIdProducto().setText("");
    }
}
