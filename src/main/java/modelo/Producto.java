package modelo;

public class Producto {
    private String id;
    private String nombre;
    private Float precio;
    private String descripcion;

    public Producto(String id, String nombre, Float precio, String descripcion) {
        if (id == null || nombre == null || precio == null || descripcion == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void actualizarPrecio(Float nuevoPrecio) {
        if (nuevoPrecio == null) {
            throw new IllegalArgumentException("El nuevo precio no puede ser null");
        }
        if (nuevoPrecio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = nuevoPrecio;
    }
}