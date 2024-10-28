package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArregloProductos {
    private List<Producto> productos;

    public ArregloProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String id) {
        productos.removeIf(p -> p.getId().equals(id));
    }

    public Producto buscarProducto(String id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}