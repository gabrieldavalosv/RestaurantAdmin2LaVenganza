package modelo;

public class Empleado extends Usuario {

    public Empleado() {}

    public Empleado(int id, String nombre, String usuario, String password) {
        super(id, nombre, usuario, password);
    }

    public void gestionarOrden(Orden orden) {
        
    }
}
