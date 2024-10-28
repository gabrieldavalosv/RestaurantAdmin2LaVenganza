package modelo;

import java.util.ArrayList;
import java.util.List;

// Clase que representa un Combo compuesto por múltiples productos
public class Combo {
    // Identificador único del combo
    private String id;

    // Nombre del combo
    private String nombre;

    // Lista de productos que forman parte del combo
    private List<Producto> productos;

    // Precio base del combo
    private Float precio;


    public Combo(String id, String nombre, Float precio) {
        // Validación: Ningún parámetro puede ser null
        if (id == null || nombre == null || precio == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser null");
        }
        // Validación: El precio no puede ser negativo
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
        // Validación: El nombre no puede ser null ni estar vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }


    public List<Producto> getProductos() {
        // Retorna una copia de la lista de productos para proteger la integridad de los datos
        return new ArrayList<>(productos);
    }


    public Float getPrecio() {
        return precio;
    }


    public void setPrecio(Float precio) {
        // Validación: El precio no puede ser negativo
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }


    public void agregarProducto(Producto producto) {
        // Validación: El producto no puede ser null
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null");
        }
        productos.add(producto);
    }


    public void eliminarProducto(String id) {
        // Validación: El ID no puede ser null ni estar vacío
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        // Elimina los productos cuya ID coincide con la proporcionada
        productos.removeIf(p -> p.getId().equals(id));
    }


    public Float calcularPrecioTotal() {
        float total = precio;
        float sumaPreciosIndividuales = 0;

        // Suma los precios de todos los productos en el combo
        for (Producto producto : productos) {
            sumaPreciosIndividuales += producto.getPrecio();
        }

        // Calcula un descuento del 20% sobre la suma de los precios individuales
        float descuento = sumaPreciosIndividuales * 0.20f;
        total = sumaPreciosIndividuales - descuento;

        return total;
    }
}
