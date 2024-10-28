package modelo;

public class Venta {
    private String id;
    private Orden orden;
    private Cliente cliente;
    private Pago pago;
    private String estado;

    public Venta(String id, Orden orden, Cliente cliente, Pago pago) {
        if (id == null || orden == null || cliente == null || pago == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        this.id = id;
        this.orden = orden;
        this.cliente = cliente;
        this.pago = pago;
        this.estado = "Pendiente";
    }

    public String getId() {
        return id;
    }

    public Orden getOrden() {
        return orden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pago getPago() {
        return pago;
    }

    public String getEstado() {
        return estado;
    }

    public void procesarVenta() throws VentaException {
        try {
            if (pago.procesarPago()) {
                orden.actualizarEstado("Pagada");
                this.estado = "Completada";
            } else {
                this.estado = "Fallida";
                throw new VentaException("El pago no pudo ser procesado");
            }
        } catch (Exception e) {
            this.estado = "Error";
            throw new VentaException("Error al procesar la venta: " + e.getMessage());
        }
    }
}