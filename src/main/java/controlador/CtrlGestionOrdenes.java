package controlador;

import modelo.OrdenArreglo;
import modelo.Orden;
import modelo.Menu;
import modelo.Producto;

import vista.GestionDeOrdenes;
import vista.GestionDePagos;
import vista.PanelPrincipal;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.personal.Administrador;
import vista.GestionDePagos;

/**
 *
 * @author Davi
 */

public class CtrlGestionOrdenes {
    GestionDeOrdenes vista;
    OrdenArreglo modelo;
    Administrador administrador;
    
    private Orden orden;
    private String fecha;
    private Menu menu;
    
    public CtrlGestionOrdenes(OrdenArreglo modelo, GestionDeOrdenes vista,Administrador administrador){
        this.vista = vista;
        this.modelo = modelo;
        this.administrador = administrador;
        
        this.asignarEventos();
        this.mostrarTitulos();
        
        this.vista.setVisible(true);
    }
    
    private void asignarEventos(){
        vista.getButtonAgregarOrden().addActionListener( e -> this.eventoAgregarOrden() );
        vista.getButtonVolverPanel().addActionListener( e -> this.irPanelPrincipal() );
        vista.getButtonBuscarOrden().addActionListener( e -> this.eventoBuscarOrden() );
        vista.getButtonCancelarOrden().addActionListener( e -> this.eventoCancelarOrden() );
        
        // Frame de órden
        vista.getButtonAgregarProducto().addActionListener( e -> this.eventoAgregarProducto() );
        vista.getButtonEliminarProducto().addActionListener( e -> this.eventoEliminarProducto() );
        vista.getButtonTerminarOrden().addActionListener( e -> this.eventoTerminarOrden() );
    }
    
    private void irPanelPrincipal(){
        var vistaPanel = new PanelPrincipal();
        var ctrlPanel = new CtrlPanelPrincipal( administrador, vistaPanel );
        
        vista.dispose();
    }
    
    private void irGestionarPago(){
        var vistaPago = new GestionDePagos();
        var ctrlPago = new CtrlGestionPagos( orden, vistaPago );
        
        //vista.dispose();
    }
    
    private void mostrarTitulos(){
        // Mostrar la fecha actual
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        fecha = fechaActual.format(formatoFecha);
        vista.getLabelTituloFecha().setText( "Fecha: " + fecha );
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
            
            mostrarDatosOrden();
            vista.getFrameOrden().setVisible(true);
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
        
        // Renovar tabla para la nueva orden
        var productosOrden = orden.getProductoArreglo().getProductos();
        var tablaProductos = (DefaultTableModel) vista.getTablaOrdenProductos().getModel();
        
        tablaProductos.setRowCount(0);
        
        for(int i=0; i < orden.getProductoArreglo().getIndex(); i++){
            Producto p = productosOrden[i];
            
            tablaProductos.addRow( new Object[]{ p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio() });
        }
        
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
        
        // Actualizar la tabla de productos ordenes
        if( orden.agregarProductoALaOrden(idProducto, menu) ){
            var producto = orden.getProductoArreglo().buscarProducto(idProducto);
            var tablaProductos = (DefaultTableModel) vista.getTablaOrdenProductos().getModel();
            
            tablaProductos.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCategoria(), producto.getPrecio() });
        }else{
            JOptionPane.showMessageDialog(vista.getFrameOrden(), "El producto con id " + idProducto + " no fue encontrado...");
        }
        
        vista.getFieldIdProducto().setText("");
    }
    
    private void eventoEliminarProducto(){
        var idProducto = vista.getFieldIdProducto().getText();
        
        if( idProducto.isEmpty() ){
            JOptionPane.showMessageDialog(vista.getFrameOrden(), "Por favor, primero ingrese un id de un producto.");
            return;
        }
        
        if( orden.eliminarProductoALaOrden(idProducto) ){
            var tablaProductos = (DefaultTableModel) vista.getTablaOrdenProductos().getModel();
            
            //Obtener posicion donde se encuentra el producto con ese id
            int posicion = -1;
            
            for(int i=0; i < tablaProductos.getRowCount(); i++){
                if (tablaProductos.getValueAt(i, 0).toString().equals(idProducto)) {
                    posicion = i;
                    break;
                }
            }
            
            tablaProductos.removeRow( posicion );
            
            // Limpiar todas las filas de la tabla
            tablaProductos.setRowCount(0);
        
            // Volver a agregar todas las órdenes desde el arreglo al JTable
            for (int i = 0; i < orden.getProductoArreglo().getIndex(); i++) {
                Producto p = orden.getProductoArreglo().getProductos()[i];
                
                tablaProductos.addRow(new Object[]{ p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio() });
            }
            
        }else{
            JOptionPane.showMessageDialog(vista.getFrameOrden(), "El prodcuto con id " + idProducto + " no fue encontrado...");
        }
        
        vista.getFieldIdProducto().setText("");
    }
    
    private void eventoTerminarOrden(){
        orden.setEstado("Terminado");
        
        // Redirigue a la vista de ordenes
        vista.getFrameOrden().dispose();
        
        this.irGestionarPago();
        
        // Actualizar la tabla de ordenes
        var tablaOrdenes = (DefaultTableModel) vista.getTablaOrdenes().getModel();
        var filaOrden = Integer.parseInt( orden.getId() );
        
        tablaOrdenes.setValueAt(orden.getEstado(), filaOrden, 2);
        tablaOrdenes.setValueAt(orden.calcularPrecioTotal(), filaOrden, 3);
    }
}
