package modelo;

public class Orden {
    private int idOrden;
    private ArregloProductos producto;
    private String estado;

    public Orden(int idOrden, ArregloProductos producto, String estado) {
        this.idOrden = idOrden;
        this.producto = producto;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public ArregloProductos getProducto() {
        return producto;
    }

    public void setProducto(ArregloProductos producto) {
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
