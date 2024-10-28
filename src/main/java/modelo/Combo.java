package modelo;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    private String id;
    private String nombre;
    private List<Producto> productos;
    private Float precio;

    public Combo(String id, String nombre, Float precio) {
        if (id == null || nombre == null || precio == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.productos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null");
        }
        productos.add(producto);
    }

    public void eliminarProducto(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        productos.removeIf(p -> p.getId().equals(id));
    }

    public Float calcularPrecioTotal() {
        float total = precio;
        float sumaPreciosIndividuales = 0;

        for (Producto producto : productos) {
            sumaPreciosIndividuales += producto.getPrecio();
        }

        float descuento = sumaPreciosIndividuales * 0.20f;
        total = sumaPreciosIndividuales - descuento;

        return total;
    }
}


