package modelo;

// Clase que representa a un Cliente con sus atributos básicos
public class Cliente {
    // Identificador único del cliente
    private String id;

    // Nombre del cliente
    private String nombre;

    // Número de teléfono del cliente
    private String telefono;

    // Correo electrónico del cliente
    private String email;

    // Constructor que inicializa todos los atributos del cliente
    public Cliente(String id, String nombre, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Método getter para obtener el ID del cliente
    public String getId() {
        return id;
    }

    // Método setter para establecer el ID del cliente
    public void setId(String id) {
        this.id = id;
    }

    // Método getter para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Método setter para establecer el nombre del cliente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener el teléfono del cliente
    public String getTelefono() {
        return telefono;
    }

    // Método setter para establecer el teléfono del cliente
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método getter para obtener el correo electrónico del cliente
    public String getEmail() {
        return email;
    }

    // Método setter para establecer el correo electrónico del cliente
    public void setEmail(String email) {
        this.email = email;
    }
}
