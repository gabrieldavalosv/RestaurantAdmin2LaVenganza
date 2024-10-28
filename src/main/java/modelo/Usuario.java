package modelo;

public class Usuario {
    // Identificador único del usuario
    private String id;

    // Nombre completo del usuario
    private String nombre;

    // Nombre de usuario para el login
    private String usuario;

    // Contraseña del usuario
    private String contrasenia;

    public Usuario(String id, String nombre, String usuario, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        // Validación: El ID no puede ser null ni estar vacío
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getUsuario() {
        return usuario;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getContrasenia() {
        return contrasenia;
    }


    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
