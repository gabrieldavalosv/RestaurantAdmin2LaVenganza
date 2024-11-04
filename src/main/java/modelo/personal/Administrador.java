package modelo.personal;

public class Administrador extends Trabajador {
    private CajeroArreglo cajeroArreglo;
    
    public Administrador(){
        
    }
    
    public Administrador(String id, String nombre, String contrasena) {
        super(id, nombre, contrasena);
        cajeroArreglo = new CajeroArreglo(20);
    }

    public boolean agregarCajero(Cajero cajero) {
        return cajeroArreglo.agregarCajero(cajero);
    }

    public boolean eliminarCajero(String id) {
        return cajeroArreglo.eliminarCajero(id);
    }

    public Cajero buscarCajero(String id) {
        return cajeroArreglo.buscarCajero(id);
    }
}
