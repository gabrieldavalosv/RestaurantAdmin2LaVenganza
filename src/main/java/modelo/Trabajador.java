package modelo;

public class Trabajador {
    private String id;
    private String nombre;
    private String contrasena;

    public Trabajador(){
        
    }
    
    public Trabajador(String id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Metodos
    public boolean login(String nombre, String contrasena) {
        return nombre.equals("admin") && contrasena.equals("admin");
    }

    public boolean logout() {
        return true;
    }
}
