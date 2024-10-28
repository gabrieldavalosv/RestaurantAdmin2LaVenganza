package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArregloOrdenes {
    // Lista que almacena las órdenes
    private List<Orden> ordenes;

    public ArregloOrdenes() {
        this.ordenes = new ArrayList<>();
    }

    public void agregarOrden(Orden orden) {
        ordenes.add(orden); // Añade la orden a la lista de órdenes
    }

    public void eliminarOrden(String id) {
        // Elimina todas las órdenes cuya ID coincide con la proporcionada
        ordenes.removeIf(o -> o.getId().equals(id));
    }

    public Orden buscarOrden(String id) {
        // Utiliza streams para filtrar y encontrar la primera orden que coincide con la ID
        return ordenes.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null); // Retorna la orden encontrada o null si no existe
    }

    public List<Orden> getOrdenes() {
        return new ArrayList<>(ordenes); // Retorna una nueva lista con los mismos elementos
    }
}
