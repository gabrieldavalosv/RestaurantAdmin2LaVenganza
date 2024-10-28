package modelo;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    // Atributo que representa al usuario administrador
    private Usuario usuario;

    // Lista que almacena los empleados gestionados por el administrador
    private List<Empleado> empleados;

    public Administrador(Usuario usuario) {
        this.usuario = usuario;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        // Validación: El empleado no puede ser null
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser null");
        }
        // Agregar el empleado a la lista
        empleados.add(empleado);
    }

    public void eliminarEmpleado(String id) {
        // Validación: El ID no puede ser null o estar vacío
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        // Eliminar el empleado cuya ID coincide con el proporcionado
        empleados.removeIf(emp -> emp.getUsuario().getId().equals(id));
    }

    // pendiente de implementación
    public String generarReporteVentas() {
        StringBuilder reporte = new StringBuilder();
        return reporte.toString();
    }

    // pendiente de implementación
    public void administrarEmpleados() {
    }
}