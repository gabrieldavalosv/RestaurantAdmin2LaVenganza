package modelo;

public class Combo {
    private int id;
    private String nombre;
    private ArregloProductos productos;
    private float precio;

    public Combo() {}

    public Combo(int id, String nombre, ArregloProductos productos, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
        this.precio = precio;
    }

    public void agregarProducto(Producto producto) {
        
    }

    public void eliminarProducto(int id) {

    }

    public float calcularPrecioTotal() {
        return 0.0f;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArregloProductos getProductos() {
        return productos;
    }

    public void setProductos(ArregloProductos productos) {
        this.productos = productos;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}

