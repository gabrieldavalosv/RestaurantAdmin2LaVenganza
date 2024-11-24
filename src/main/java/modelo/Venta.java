package modelo;

import modelo.personal.Cajero;

import java.util.Date;

public class Venta {
    private String id;
    private Date fecha;
    private Pago pago;
    private Orden orden;

    public Venta(Pago pago, Orden orden) {
        this.fecha = new Date();
        this.pago = pago;
        this.orden = orden;
        this.id = orden.getId();
    }


    public String generarComprobante() {
        String comprobante = "";
        comprobante += "=== Comprobante de Venta ===\n";
        comprobante += "Fecha: " + fecha + "\n";
        comprobante += "\n=== Detalles de la Orden ===\n";
        comprobante += orden + "\n";
        comprobante += "\n=== Detalles del Pago ===\n";
        comprobante += "Monto: S/." + pago.getMonto() + "\n";
        comprobante += "Método: " + pago.getMetodo() + "\n";
        comprobante += "===========================\n";

        return comprobante;
    }

    public String getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return orden.getEstado();
    }

    public Pago getPago() {
        return pago;
    }

    public Orden getOrden() {
        return orden;
    }
}
