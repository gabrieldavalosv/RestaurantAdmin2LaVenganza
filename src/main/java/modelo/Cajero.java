package modelo;

public class Cajero extends Trabajador{
    String RUC;

    public Cajero(String id, String nombre, String contrasena, String RUC) {
        super(id, nombre, contrasena);
        this.RUC = RUC;
        OrdenArreglo ordenArreglo = new OrdenArreglo(20);
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public void crearOrden() {

    }

    public void cancelarOrden() {

    }

    public void modificarOrden() {

    }
}
