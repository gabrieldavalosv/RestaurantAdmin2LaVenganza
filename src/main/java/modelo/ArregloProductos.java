package modelo;

import java.util.ArrayList;
import java.util.List;

// Clase que gestiona un arreglo (lista) de productos
public class ArregloProductos {
    // Lista que almacena los productos
    private List<Producto> productos;

    // Constructor que inicializa la lista de productos como una nueva instancia de ArrayList
    public ArregloProductos() {
        this.productos = new ArrayList<>();
    }

    // Método para agregar un nuevo producto a la lista
    public void agregarProducto(Producto producto) {
        // Añade el producto a la lista de productos
        productos.add(producto);
    }

    // Método para eliminar un producto de la lista usando su ID
    public void eliminarProducto(String id) {
        // Elimina todos los productos cuya ID coincide con la proporcionada
        productos.removeIf(p -> p.getId().equals(id));
    }

    // Método para buscar un producto por su ID
    public Producto buscarProducto(String id) {
        // Utiliza streams para filtrar y encontrar el primer producto que coincide con la ID
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null); // Retorna el producto encontrado o null si no existe
    }

    // Método para obtener una copia de la lista de productos
    public List<Producto> getProductos() {
        // Retorna una nueva lista con los mismos elementos, evitando exponer la lista original
        return new ArrayList<>(productos);
    }
}
