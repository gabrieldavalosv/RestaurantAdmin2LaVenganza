
package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.MetodoPago;
import modelo.Orden;
import modelo.Pago;
import modelo.personal.Administrador;
import modelo.personal.Cajero;
import vista.GestionDeOrdenes;
import vista.GestionDePagos;

/**
 *
 * @author Davi
 */

public class CtrlGestionDePagos {
    Orden modelo;
    Administrador administrador;
    GestionDePagos vista;

    private String fecha;
    
    public CtrlGestionDePagos(Orden modelo, GestionDePagos vista, Administrador administrador) {
        this.modelo = modelo;
        this.vista = vista;
        this.administrador = administrador;
        
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
        
        if(monto >= modelo.calcularPrecioTotal() && pago.procesarPago(modelo.calcularPrecioTotal()) ){
            JOptionPane.showMessageDialog(vista, "Procesando el pago de: " + pago.getMonto() + " mediante " + metodoPago.getMetodo() );
            
            modelo.setEstado("Pagada");
            irGestionOrdenes();
            
        }else{
            JOptionPane.showMessageDialog(vista, "El pago no se ha podido realizar...");
        }
    }

    public void irGestionOrdenes() {
        var vistaOrdenes = new GestionDeOrdenes();
        var ordenes = Cajero.getOrdenArreglo();

        var ctrlOrdenes = new CtrlGestionDeOrdenes(ordenes, vistaOrdenes, administrador);

        vista.dispose();
    }
}
