package modelo;

public class Venta {
    private int id;
    private Orden orden;
    private Cliente cliente;
    private Pago pago;

    public Venta() {}

    public Venta(int id, Orden orden, Cliente cliente, Pago pago) {
        this.id = id;
        this.orden = orden;
        this.cliente = cliente;
        this.pago = pago;
    }

    public void procesarVenta() {
        
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
