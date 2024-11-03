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

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void actualizarPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("%-1s | %-25s | S/.%5.2f |  %-10s", id, nombre, precio, categoria);
    }
}
