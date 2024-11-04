
package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.MetodoPago;
import modelo.Orden;
import modelo.Pago;

import vista.GestionDePagos;

/**
 *
 * @author Davi
 */

public class CtrlGestionPagos {
    Orden modelo;
    GestionDePagos vista;

    private String fecha;
    
    public CtrlGestionPagos(Orden modelo, GestionDePagos vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.asignarEventos();
        this.mostrarDatosTitulos();
        this.vista.setVisible(true);
    }
    
    private void asignarEventos(){
        vista.getButtonProcesarPago().addActionListener( e -> this.eventoProcesarPago() );
        vista.getButtonCancelarPago().addActionListener( e -> vista.dispose() );
    }
    
    private void mostrarDatosTitulos(){
        // Mostrar la fecha actual
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        fecha = fechaActual.format(formatoFecha);
        
        vista.getLabelCliente().setText("Cliente: " + modelo.getCliente() );
        vista.getLabelFecha().setText("Fecha: " + fecha );
        vista.getLabelTotal().setText("Total: " + String.valueOf( modelo.calcularPrecioTotal() ) );
        vista.getLabeldOrden().setText("Id de órden: " + modelo.getId() );
    }
    
    private void eventoProcesarPago(){
        var monto = Float.parseFloat( vista.getFieldMonto().getText() );
        var metodoPago = new MetodoPago( (String) vista.getComboboxMetodos().getSelectedItem() );
        
        var pago = new Pago(monto, metodoPago);
        
        if( pago.procesarPago() ){
            JOptionPane.showMessageDialog(vista, "Procesando el pago de: " + pago.getMonto() + " mediante " + metodoPago.getMetodo() );
        }else{
            JOptionPane.showMessageDialog(vista, "El pago no se ha podido realizar...");
        }
        
        vista.dispose();
    }
}
