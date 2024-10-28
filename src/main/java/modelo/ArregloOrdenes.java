package modelo;

import java.util.ArrayList;
import java.util.List;

// Clase que gestiona un arreglo (lista) de órdenes
public class ArregloOrdenes {
    // Lista que almacena las órdenes
    private List<Orden> ordenes;

    // Constructor que inicializa la lista de órdenes como una nueva instancia de ArrayList
    public ArregloOrdenes() {
        this.ordenes = new ArrayList<>();
    }

    // Método para agregar una nueva orden a la lista
    public void agregarOrden(Orden orden) {
        ordenes.add(orden); // Añade la orden a la lista de órdenes
    }

    // Método para eliminar una orden de la lista usando su ID
    public void eliminarOrden(String id) {
        // Elimina todas las órdenes cuya ID coincide con la proporcionada
        ordenes.removeIf(o -> o.getId().equals(id));
    }

    // Método para buscar una orden por su ID
    public Orden buscarOrden(String id) {
        // Utiliza streams para filtrar y encontrar la primera orden que coincide con la ID
        return ordenes.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null); // Retorna la orden encontrada o null si no existe
    }

    // Método para obtener una copia de la lista de órdenes
    public List<Orden> getOrdenes() {
        return new ArrayList<>(ordenes); // Retorna una nueva lista con los mismos elementos
    }
}
