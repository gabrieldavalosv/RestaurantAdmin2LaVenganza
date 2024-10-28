package modelo;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private Usuario usuario;
    private List<Empleado> empleados;

    public Administrador(Usuario usuario) {
        this.usuario = usuario;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser null");
        }
        empleados.add(empleado);
    }

    public void eliminarEmpleado(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        empleados.removeIf(emp -> emp.getUsuario().getId().equals(id));
    }

    public String generarReporteVentas() {
        StringBuilder reporte = new StringBuilder();
        return reporte.toString();
    }

    public void administrarEmpleados() {
    }
}
