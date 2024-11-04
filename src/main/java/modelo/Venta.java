package modelo;

import modelo.personal.Cajero;

import java.util.Date;

public class Venta {
    private String id;
    private Date fecha;
    private String estado;
    private Pago pago;
    private Orden orden;
    private Cajero cajero;

    public Venta(String id, Pago pago, Orden orden, Cajero cajero) {
        this.id = id;
        this.fecha = new Date();
        this.estado = "Pendiente";
        this.pago = pago;
        this.orden = orden;
        this.cajero = cajero;
    }

    public boolean procesarVenta() {
        if (pago.procesarPago()) {
            this.estado = "Realizada";
            this.fecha = new Date();
            System.out.println("La venta se ha realizado con exito");
            generarComprobante();
            return true;
        } else {
            this.estado = "Fallida";
            System.out.println("La venta no se ha realizado");
            return false;
        }

    }

    public String generarComprobante() {
        String comprobante = "";
        comprobante += "=== Comprobante de Venta ===\n";
        comprobante += "ID Venta: " + id + "\n";
        comprobante += "Fecha: " + fecha + "\n";
        comprobante += "Estado: " + estado + "\n";
        comprobante += "Cliente: " + orden.getCliente() + "\n";
        comprobante += "Cajero: " + cajero.getNombre() + "\n";
        comprobante += "\n=== Detalles de la Orden ===\n";
        comprobante += orden + "\n";
        comprobante += "\n=== Detalles del Pago ===\n";
        comprobante += "ID Pago: " + pago.getId() + "\n";
        comprobante += "Monto: S/." + pago.getMonto() + "\n";
        comprobante += "Método: " + pago.getMetodo() + "\n";
        comprobante += "===========================\n";

        return comprobante;
    }
}
