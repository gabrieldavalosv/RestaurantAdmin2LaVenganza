package modelo.personal;

public class Administrador extends Trabajador {
    private CajeroArreglo cajeroArreglo;

    
    public Administrador(String id, String nombre, String contrasena) {
        super(id, nombre, contrasena);
        cajeroArreglo = new CajeroArreglo(20);
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
}
