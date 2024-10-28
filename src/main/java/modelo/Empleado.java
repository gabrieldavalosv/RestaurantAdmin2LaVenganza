package modelo;

import java.util.ArrayList;
import java.util.List;

// Clase que representa a un Empleado que gestiona órdenes
public class Empleado {
    // Objeto Usuario que contiene la información del empleado
    private Usuario usuario;

    // Lista que almacena las órdenes gestionadas por el empleado
    private List<Orden> ordenes;



    public Empleado(Usuario usuario) {
        // Validación: Usuario y administrador no pueden ser null
        if (usuario == null ) {
            throw new IllegalArgumentException("Usuario y administrador no pueden ser null");
        }
        this.usuario = usuario;
        this.ordenes = new ArrayList<>();
    }


    public void gestionarOrden(Orden orden) {
        // Validación: La orden no puede ser null
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser null");
        }

        // Cambio de estado de la orden según su estado actual
        switch (orden.getEstado()) {
            case "Nueva":
                orden.actualizarEstado("En Preparación");
                break;
            case "En Preparación":
                orden.actualizarEstado("Lista");
                break;
            case "Lista":
                orden.actualizarEstado("Entregada");
                break;
            default:
                // Lanzar excepción si el estado de la orden no es reconocido
                throw new IllegalStateException("Estado de orden no válido");
        }

        // Añade la orden gestionada a la lista de órdenes del empleado
        ordenes.add(orden);
    }


     // Método para obtener el objeto Usuario del empleado.

    public Usuario getUsuario() {
        return usuario;
    }
}
