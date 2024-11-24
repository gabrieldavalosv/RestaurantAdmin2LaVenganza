package modelo.personal;

import modelo.OrdenArreglo;
import modelo.VentaArreglo;

public class Administrador extends Trabajador {
    private static CajeroArreglo cajeroArreglo;

    public Administrador(String id, String nombre, String contrasena) {
        super(id, nombre, contrasena);
        cajeroArreglo = new CajeroArreglo(20);
        setRol("Administrador");
    }

    public CajeroArreglo getCajeroArreglo() {
        return cajeroArreglo;
    }

    public void agregarCajero(Cajero cajero) {
        cajeroArreglo.agregarCajero(cajero);
    }

    public void eliminarCajero(String id) {
        cajeroArreglo.eliminarCajero(id);
    }

    public Cajero buscarCajero(String id) {
        return cajeroArreglo.buscarCajero(id);
    }

    public static VentaArreglo getVentas() {
        return Trabajador.getVentaArreglo();
    }

    public static OrdenArreglo getOrdenes() {
        return Trabajador.getOrdenArreglo();
    }


}
