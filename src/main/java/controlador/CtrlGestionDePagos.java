
package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

import modelo.MetodoPago;
import modelo.Orden;
import modelo.Pago;
import modelo.personal.Trabajador;
import vista.GestionDeOrdenes;
import vista.GestionDePagos;

/**
 * @author Davi
 */

public class CtrlGestionDePagos {
    private Orden modelo;
    private Trabajador trabajador;
    private GestionDePagos vista;

    private String fecha;

    //Constructor
    public CtrlGestionDePagos(Orden modelo, GestionDePagos vista, Trabajador trabajador) {
        this.modelo = modelo; //se inicializan variables
        this.vista = vista;
        this.trabajador = trabajador;

        this.asignarEventos();  //hacen que los botones de la vista hagan algo
        this.mostrarDatosTitulos();  //muestra info orden
        this.vista.setVisible(true);
    }

    private void asignarEventos() {
        vista.getButtonProcesarPago().addActionListener(e -> this.eventoProcesarPago());
        vista.getButtonCancelarPago().addActionListener(e -> vista.dispose());
    }

    private void mostrarDatosTitulos() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        fecha = fechaActual.format(formatoFecha);

        vista.getLabelCliente().setText("Cliente: " + modelo.getCliente());
        vista.getLabelFecha().setText("Fecha: " + fecha);
        vista.getLabelTotal().setText("Total: " + String.valueOf(modelo.calcularPrecioTotal()));
        vista.getLabeldOrden().setText("Id de órden: " + modelo.getId());
    }

    private void eventoProcesarPago() { //ocurre al presionar procesar pago
        var monto = Float.parseFloat(vista.getFieldMonto().getText());
        var metodoPago = new MetodoPago((String) vista.getComboboxMetodos().getSelectedItem());

        var pago = new Pago(monto, metodoPago);

        if (pago.procesarPago(modelo.calcularPrecioTotal(), modelo, trabajador.getVentas())) {
            float vuelto = pago.getMonto() - modelo.calcularPrecioTotal();
            JOptionPane.showMessageDialog(vista, "Vuelto: " + vuelto + " Metodo: " + metodoPago.getMetodo());

            modelo.setEstado("Pagada");

            irGestionOrdenes();

        } else {
            JOptionPane.showMessageDialog(vista, "El pago no se ha podido realizar...");
        }
    }

    public void irGestionOrdenes() {  //se encarga de cambiar a la vista donde se gestionan las órdenes.
        var vistaOrdenes = new GestionDeOrdenes();
        var ordenes = trabajador.getOrdenes(); // Método para obtener las órdenes desde el modelo

        ordenes.actualizarOrdenesTxt();
        new CtrlGestionDeOrdenes(ordenes, vistaOrdenes, trabajador);

        vista.dispose();
    }
}
