package modelo;

import modelo.personal.Cajero;

import java.util.Date;

public class Venta {
    private String id;
    private Date fecha;
    private String estado;
    private Pago pago;
    private Orden orden;

    public Venta(Pago pago, Orden orden, Cajero cajero) {
        this.fecha = new Date();
        this.pago = pago;
        this.orden = orden;
        this.id = orden.getId();
    }

    public boolean procesarVenta(float totalPago) {
        if (pago.procesarPago(totalPago)) {
            this.estado = "Realizada";
            this.fecha = new Date();
            generarComprobante();
            return true;
        } else {
            this.estado = "Fallida";
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
        comprobante += "\n=== Detalles de la Orden ===\n";
        comprobante += orden + "\n";
        comprobante += "\n=== Detalles del Pago ===\n";
        comprobante += "ID Pago: " + pago.getId() + "\n";
        comprobante += "Monto: S/." + pago.getMonto() + "\n";
        comprobante += "Método: " + pago.getMetodo() + "\n";
        comprobante += "===========================\n";

        return comprobante;
    }

    public String getId() {
        return id;
    }
}
