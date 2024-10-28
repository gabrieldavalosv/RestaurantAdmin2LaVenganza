package modelo;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private Usuario usuario;
    private List<Orden> ordenes;
    private Administrador administrador;

    public Empleado(Usuario usuario, Administrador administrador) {
        if (usuario == null || administrador == null) {
            throw new IllegalArgumentException("Usuario y administrador no pueden ser null");
        }
        this.usuario = usuario;
        this.administrador = administrador;
        this.ordenes = new ArrayList<>();
    }

    public void gestionarOrden(Orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser null");
        }
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
                throw new IllegalStateException("Estado de orden no válido");
        }

        ordenes.add(orden);
    }

    public Usuario getUsuario() {
        return usuario;
    }
}