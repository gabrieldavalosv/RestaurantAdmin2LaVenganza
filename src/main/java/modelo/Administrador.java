package modelo;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    // Atributo que representa al usuario administrador
    private Usuario usuario;

    // Lista que almacena los empleados gestionados por el administrador
    private List<Empleado> empleados;

    // Constructor que inicializa el administrador con un usuario y una lista vacía de empleados
    public Administrador(Usuario usuario) {
        this.usuario = usuario;
        this.empleados = new ArrayList<>();
    }

    // Método para agregar un nuevo empleado
    public void agregarEmpleado(Empleado empleado) {
        // Validación: El empleado no puede ser null
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser null");
        }
        // Agregar el empleado a la lista
        empleados.add(empleado);
    }

    // Método para eliminar un empleado por su ID
    public void eliminarEmpleado(String id) {
        // Validación: El ID no puede ser null o estar vacío
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        // Eliminar el empleado cuya ID coincide con el proporcionado
        empleados.removeIf(emp -> emp.getUsuario().getId().equals(id));
    }

    // Método para generar un reporte de ventas (pendiente de implementación)
    public String generarReporteVentas() {
        StringBuilder reporte = new StringBuilder();
        // Lógica para generar el reporte
        return reporte.toString();
    }

    // Método para administrar empleados (pendiente de implementación)
    public void administrarEmpleados() {
        // Implementación futura
    }
}