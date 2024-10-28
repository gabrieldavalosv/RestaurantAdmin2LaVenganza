package modelo;

public class Venta {
    // Identificador único de la venta
    private String id;

    // Orden asociada a la venta
    private Orden orden;

    // Cliente que realiza la venta
    private Cliente cliente;

    // Pago asociado a la venta
    private Pago pago;

    // Estado actual de la venta (por ejemplo, "Pendiente", "Completada", "Fallida", "Error")
    private String estado;


    public Venta(String id, Orden orden, Cliente cliente, Pago pago) {
        // Validación: Ningún parámetro puede ser null
        if (id == null || orden == null || cliente == null || pago == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        this.id = id;
        this.orden = orden;
        this.cliente = cliente;
        this.pago = pago;
        this.estado = "Pendiente"; // Estado inicial de la venta
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
            // Intenta procesar el pago asociado a la venta
            if (pago.procesarPago()) {
                // Si el pago se procesa correctamente, actualiza el estado de la orden y de la venta
                orden.actualizarEstado("Pagada");
                this.estado = "Completada";
            } else {
                // Si el pago falla, actualiza el estado de la venta y lanza una excepción
                this.estado = "Fallida";
                throw new VentaException("El pago no pudo ser procesado");
            }
        } catch (Exception e) {
            // En caso de cualquier excepción, actualiza el estado de la venta y lanza una excepción personalizada
            this.estado = "Error";
            throw new VentaException("Error al procesar la venta: " + e.getMessage());
        }
    }
}
