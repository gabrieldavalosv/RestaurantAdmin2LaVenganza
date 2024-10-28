package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cocina {
    private List<Orden> ordenesPendiente;
    private static final int TIEMPO_PREPARACION_BASE = 10;

    public Cocina() {
        this.ordenesPendiente = new ArrayList<>();
    }

    public void prepararOrden(Orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser null");
        }

        if (ordenesPendiente.contains(orden)) {
            throw new IllegalStateException("La orden ya está en preparación");
        }

        int tiempoEstimado = calcularTiempoPreparacion(orden);

        ordenesPendiente.add(orden);
        orden.actualizarEstado("En Preparación");

        System.out.println("Preparando orden " + orden.getId());
        System.out.println("Tiempo estimado: " + tiempoEstimado + " minutos");
    }

    private int calcularTiempoPreparacion(Orden orden) {
        int tiempo = TIEMPO_PREPARACION_BASE;
        tiempo += orden.getProductos().size() * 2;
        tiempo += orden.getCombos().size() * 5;
        return tiempo;
    }

}
