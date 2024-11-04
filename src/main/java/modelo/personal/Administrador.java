package modelo.personal;

import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class Administrador extends Trabajador {
    private CajeroArreglo cajeroArreglo;

    
    public Administrador(String id, String nombre, String contrasena) {
        super(id, nombre, contrasena);
        cajeroArreglo = new CajeroArreglo(20);
    }

    public CajeroArreglo getCajeroArreglo() {
        return cajeroArreglo;
    }

    public void agregarCajero(Cajero cajero) throws ArregloLLenoException {
        cajeroArreglo.agregarCajero(cajero);
    }

    public void eliminarCajero(String id) throws IdNoEncontradoException {
        cajeroArreglo.eliminarCajero(id);
    }

    public Cajero buscarCajero(String id) throws IdNoEncontradoException {
        return cajeroArreglo.buscarCajero(id);
    }
}
