package modelo.personal;

import modelo.Orden;

public class Cajero extends Trabajador {
    private String RUC;

    public Cajero(String id, String nombre, String contrasena, String RUC) {
        super(id, nombre, contrasena);
        this.RUC = RUC;
        setRol("Cajero");
    }
    
    public Cajero(Trabajador t){
        super( t.getId(), t.getNombre(), t.getContrasena() );
        setRol("Cajero");
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }
    
    public void crearOrden(String id, String cliente) {
        ordenArreglo.agregarOrden(new Orden(id, cliente));
    }

    public void cancelarOrden(String id) {
        ordenArreglo.eliminarOrden(id);
    }

    @Override
    public String toString() {
        return String.format("%-1s : %-25s : %-15s : %-10s", this.getId(), this.getNombre(), this.getContrasena(), this.getRUC());
    }
}
