package modelo.personal;

public class Trabajador {
    private String id;
    private String nombre;
    private String contrasena;
    private String rol;

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

    public boolean login(String nombre, String contrasena) {
        if (this.nombre.equals(nombre) && this.contrasena.equals(contrasena)) {
            return true;
        }
        return false;
    }

    public boolean logout() {
        return true;
    }
}
