package modelo.personal;

import modelo.Orden;
import modelo.OrdenArreglo;

public class Cajero extends Trabajador{
    private String RUC;
    private static OrdenArreglo ordenArreglo;


    public Cajero(String id, String nombre, String contrasena, String RUC) {
        super(id, nombre, contrasena);
        this.RUC = RUC;
        ordenArreglo = new OrdenArreglo(20);
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public static OrdenArreglo getOrdenArreglo() {
        return ordenArreglo;
    }

    public static void setOrdenArreglo(OrdenArreglo ordenArreglo) {
        Cajero.ordenArreglo = ordenArreglo;
    }

    public void crearOrden(String id, String cliente) {
        ordenArreglo.agregarOrden(new Orden(id, cliente));
    }

    public void cancelarOrden(String id) {
        ordenArreglo.eliminarOrden(id);
    }
}
