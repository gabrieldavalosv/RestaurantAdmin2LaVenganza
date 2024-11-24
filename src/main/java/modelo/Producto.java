package modelo;

public class Producto {
    private String id;
    private String nombre;
    private float precio;
    private String categoria;

    public Producto(String id, String nombre, float precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void actualizarPrecio(float precio) {
        this.precio = precio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("%-1s : %-25s : %5.2f : %-10s", id, nombre, precio, categoria);
    }
}
