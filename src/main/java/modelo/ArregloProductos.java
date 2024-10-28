package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArregloProductos {
    // Lista que almacena los productos
    private List<Producto> productos;

    public ArregloProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        // Añade el producto a la lista de productos
        productos.add(producto);
    }

    public void eliminarProducto(String id) {
        // Elimina todos los productos cuya ID coincide con la proporcionada
        productos.removeIf(p -> p.getId().equals(id));
    }


    public Producto buscarProducto(String id) {
        // Utiliza streams para filtrar y encontrar el primer producto que coincide con la ID
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null); // Retorna el producto encontrado o null si no existe
    }

    // Método para obtener una copia de la lista de productos
    public List<Producto> getProductos() {
        // Retorna una nueva lista con los mismos elementos evitando exponer la lista original
        return new ArrayList<>(productos);
    }
}
