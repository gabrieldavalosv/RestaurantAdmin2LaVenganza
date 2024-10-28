package modelo;

public class Orden {
    private int idOrden;
    private Producto[] producto;
    private String estado;

    public Orden(int idOrden, Producto[] producto, String estado) {
        this.idOrden = idOrden;
        this.producto = producto;
        this.estado = estado;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
