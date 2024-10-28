package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArregloOrdenes {
    private List<Orden> ordenes;

    public ArregloOrdenes() {
        this.ordenes = new ArrayList<>();
    }

    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public void eliminarOrden(String id) {
        ordenes.removeIf(o -> o.getId().equals(id));
    }

    public Orden buscarOrden(String id) {
        return ordenes.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Orden> getOrdenes() {
        return new ArrayList<>(ordenes);
    }
}