package modelo.personal;

public class Administrador extends Trabajador {
    private static CajeroArreglo cajeroArreglo = new CajeroArreglo(20);
    
    public Administrador(String id, String nombre, String contrasena) {
        super(id, nombre, contrasena);
        setRol("Administrador");
    }
    
    public Administrador(Trabajador t){
        super( t.getId(), t.getNombre(), t.getContrasena() );
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

    public static boolean buscarAdmin(String nombreIngresado, String contraseniaIngresada){
        String id = "101";
        String nombre = "Mathias";
        String contrasenia = "2301";
        
        return nombre.equals( nombreIngresado ) && contrasenia.equals( contraseniaIngresada );
    }
}
