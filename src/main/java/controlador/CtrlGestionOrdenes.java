package controlador;

import modelo.OrdenArreglo;
import modelo.Orden;
import modelo.Menu;
import modelo.Producto;

import vista.GestionDeOrdenes;

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
    private Producto producto;
    private String fecha;
    private Menu menu;
    
    public CtrlGestionOrdenes(GestionDeOrdenes vista){
        this.vista = vista;
        this.modelo = new OrdenArreglo(10);
        
        this.asignarEventos();
        this.mostrarDatosTitulos();
    }
    
    private void asignarEventos(){
        vista.getButtonNuevaOrden().addActionListener( e -> this.empezarNuevaOrden() );
        vista.getButtonMenu().addActionListener( e -> this.mostrarMenu() );
        //vista.getButtonAceptar().addActionListener( e -> this.seleccionarProducto() );
    }
    
    private void mostrarDatosTitulos(){
        // Mostrar la fecha actual
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        fecha = fechaActual.format(formatoFecha);
        vista.getLabelFechaHora().setText( "Fecha: " + fecha );
    }
    
    private void mostrarMenu(){
        // Desplegar el frame
        menu = new Menu();
        
        var listaProductos = menu.getProductoArreglo().getProductos();
        var tabla = (DefaultTableModel) vista.getTablaMenu().getModel();
        
        vista.getFrameProductos().setVisible(true);
        
        for(int i=0; i < menu.getProductoArreglo().getIndex(); i++ ){
            Producto p = listaProductos[i];
            
            tabla.addRow( new Object[]{ p.getId(), p.getNombre(), p.getPrecio(), p.getCategoria() });
        }
    }
    
    /*private void seleccionarProducto(){
        String idIngresado = vista.
        producto = orden.agregarProductoALaOrden(producto)
        
        if( orden.agregarProductoALaOrden(producto) ){
            JOptionPane.showMessageDialog(vista.getFrameProductos(), "Se ha agregado el producto:\n" + producto.toString(), "Producto agregado correctamente", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(vista.getFrameProductos(), "Ningun producto fue seleccionado para agregar", "Error al agregar su producto", JOptionPane.WARNING_MESSAGE);
        }
    }*/
    
    private void empezarNuevaOrden(){
        // Asignar id de la nueva orden apartir del array
        var ultimoId = String.valueOf( modelo.getIndex() );
        
        // Actualizar titulos sobre la orden
        orden = new Orden( ultimoId );
        
        vista.getLabeldOrden().setText( orden.getId() );
        vista.getLabelEstado().setText( orden.getEstado() );
        vista.getLabelTotal().setText( String.valueOf( orden.calcularPrecioTotal() ) );
        vista.getLabelFecha().setText( fecha );
        
        // Habilitar botones para gestionar la nueva orden
        vista.getButtonMenu().setEnabled(true);
        vista.getButtonAgregarProducto().setEnabled(true);
        vista.getButtonAgregarCombo().setEnabled(true);
        vista.getButtonFinalizarOrden().setEnabled(true);
        vista.getButtonCancelarOrden().setEnabled(true);
    }
}
