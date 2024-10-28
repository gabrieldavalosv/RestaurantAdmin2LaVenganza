package modelo;

import java.util.ArrayList;
import java.util.List;

// Clase que representa la cocina encargada de preparar las órdenes
public class Cocina {
    // Lista que almacena las órdenes pendientes de preparación
    private List<Orden> ordenesPendiente;

    // Tiempo base de preparación en minutos
    private static final int TIEMPO_PREPARACION_BASE = 10;

    // Constructor que inicializa la lista de órdenes pendientes
    public Cocina() {
        this.ordenesPendiente = new ArrayList<>();
    }


    public void prepararOrden(Orden orden) {
        // Validación: La orden no puede ser null
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser null");
        }

        // Validación: Verifica si la orden ya está en la lista de pendientes
        if (ordenesPendiente.contains(orden)) {
            throw new IllegalStateException("La orden ya está en preparación");
        }

        // Calcula el tiempo estimado de preparación de la orden
        int tiempoEstimado = calcularTiempoPreparacion(orden);

        // Añade la orden a la lista de órdenes pendientes
        ordenesPendiente.add(orden);

        // Actualiza el estado de la orden a "En Preparación"
        orden.actualizarEstado("En Preparación");

        // Imprime mensajes indicando el inicio de la preparación y el tiempo estimado
        System.out.println("Preparando orden " + orden.getId());
        System.out.println("Tiempo estimado: " + tiempoEstimado + " minutos");
    }


    private int calcularTiempoPreparacion(Orden orden) {
        // Inicializa el tiempo con el tiempo base de preparación
        int tiempo = TIEMPO_PREPARACION_BASE;

        // Añade tiempo adicional por cada producto en la orden
        tiempo += orden.getProductos().size() * 2;

        // Añade tiempo adicional por cada combo en la orden
        tiempo += orden.getCombos().size() * 5;

        return tiempo;
    }
}
