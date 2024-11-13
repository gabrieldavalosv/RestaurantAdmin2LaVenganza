package controlador;

import modelo.Orden;
import modelo.Menu;
import modelo.Producto;
import vista.GestionDeOrden;
import vista.GestionDeOrdenes;


import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.GestionDePagos;

/**
 *
 * @author Davi
 */

public class CtrlGestionDeOrden {
    private Orden modelo;
    private GestionDeOrden vista;
    
    private Menu menu;
    
    public CtrlGestionDeOrden(Orden modelo, GestionDeOrden vista){
        this.vista = vista;
        this.modelo = modelo;
        
        // Poniendo los titulos
        vista.labelCliente.setText( "Cliente: " + modelo.getCliente() );
        vista.labelPrecioTotal.setText( "Precio total : " + modelo.calcularPrecioTotal() );
        
        // Desplegando las tablas
        this.actualizarTablaProductos();
        this.mostrarMenu();
        
        // Asignando los eventos a los botones
        vista.buttonAgregarProducto.addActionListener( e -> this.eventoAgregarProducto() );
        vista.buttonEliminarProducto.addActionListener( e -> this.eventoEliminarProducto() );
        vista.buttonTerminarOrden.addActionListener( e -> this.eventoTerminarOrden() );
        
        this.vista.setVisible(true);
    }
    
    private void irGestionarPago(){
        var vistaPago = new GestionDePagos();
        var ctrlPago = new CtrlGestionDePagos( modelo, vistaPago );
    }
    
    private void actualizarTablaProductos() {
        var tablaProductos = (DefaultTableModel) vista.tablaOrdenProductos.getModel();
        
        tablaProductos.setRowCount(0);
        
        for(Producto p: modelo.getProductoArreglo().getProductos() ){
            if( p != null){
                tablaProductos.addRow( new Object[]{ p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio() });
            }
        }
        
        // Desactivar botones en caso la orden este terminada
        boolean isTerminada = modelo.getEstado().equals("Terminada");
        
        vista.buttonAgregarProducto.setEnabled(!isTerminada);
        vista.buttonEliminarProducto.setEnabled(!isTerminada);
        vista.buttonTerminarOrden.setEnabled(!isTerminada);
        
    }
    
    private void mostrarMenu(){
        menu = new Menu();
        
        var tablaMenu = (DefaultTableModel) vista.tablaMenu.getModel();
        
        for(Producto p: menu.getProductoArreglo().getProductos() ){
            if( p != null){
                tablaMenu.addRow( new Object[]{ p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio() });
            }
        }
        
    }
    
    private void eventoAgregarProducto() {
        var idProducto = vista.fieldIdProducto.getText();
        
        if( idProducto.isEmpty() ){
            JOptionPane.showMessageDialog(vista, "Por favor, primero ingrese un id de un producto.");
            return;
        }
        
        // Actualizar la tabla de productos ordenes
        if( modelo.agregarProductoALaOrden(idProducto, menu) ){
            var producto = modelo.getProductoArreglo().buscarProducto(idProducto);
            var tablaProductos = (DefaultTableModel) vista.tablaOrdenProductos.getModel();
            
            tablaProductos.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCategoria(), producto.getPrecio() });
        }else{
            JOptionPane.showMessageDialog(vista, "El producto con id " + idProducto + " no fue encontrado...");
        }
        
        vista.fieldIdProducto.setText("");
    }
    
    private void eventoEliminarProducto() {
        var idProducto = vista.fieldIdProducto.getText();
        
        if( idProducto.isEmpty() ){
            JOptionPane.showMessageDialog(vista, "Por favor, primero ingrese un id de un producto.");
            return;
        }
        
        if( modelo.eliminarProductoALaOrden(idProducto) ){
            var tablaProductos = (DefaultTableModel) vista.tablaOrdenProductos.getModel();
            
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
            for( Producto p: modelo.getProductoArreglo().getProductos() ) {
                if( p != null ){
                    tablaProductos.addRow(new Object[]{ p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio() });
                }
            }
        
        }else{
            JOptionPane.showMessageDialog(vista, "El prodcuto con id " + idProducto + " no fue encontrado...");
        }
        
        vista.fieldIdProducto.setText("");
    }
    
    private void eventoTerminarOrden(){
        this.vista.dispose();
        
        irGestionarPago();
    }
    
}