package modelo.personal;

import modelo.Menu;
import modelo.OrdenArreglo;
import modelo.VentaArreglo;

public class Trabajador {
    private String id;
    private String nombre;

    private String contrasena;
    private String rol;
    public static VentaArreglo ventaArreglo = new VentaArreglo(20);
    public static OrdenArreglo ordenArreglo = new OrdenArreglo(20);
    public static Menu menu = new Menu();

    public Trabajador(String id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = "";
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public static VentaArreglo getVentaArreglo() {
        return ventaArreglo;
    }

    public static OrdenArreglo getOrdenArreglo() {
        return ordenArreglo;
    }

    public boolean logout() {
        return true;
    }

    public static Menu getMenu() {return menu;}
    
    public static VentaArreglo getVentas() {
        return ventaArreglo;
    }
    
    public static OrdenArreglo getOrdenes() {
        return ordenArreglo;
    }
}
