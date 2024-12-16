package modelo;

public class Venta {
    private String id;
    private String fecha;
    private Pago pago;
    private Orden orden;

    public Venta(Orden orden, String fecha, Pago pago) {
        this.id = orden.getId();
        this.fecha = fecha;
        this.pago = pago;
        this.orden = orden;
    }

    public String generarComprobante() {
        String comprobante = "";
        comprobante += "=== Comprobante de Venta ===\n";
        comprobante += "ID: " + id + "\n";
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

    public String getFecha() {
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

    @Override
    public String toString() {
        return String.format("%-1s : %-25s : %5.2f : %-10s", id, fecha, pago.getMonto(), pago.getMetodo());
    }
    
}
