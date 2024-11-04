package modelo;

public class Orden {
    private String id;
    private ProductoArreglo productoArreglo;
    private String estado;
    private String cliente;

    public Orden(String id, String cliente) {
        this.id = id;
        this.productoArreglo = new ProductoArreglo(20);
        this.estado = "En espera";
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public boolean agregarProductoALaOrden(String id, Menu menu) {
        Producto producto = menu.productoArreglo.buscarProducto(id);
        if (producto != null) {
            return productoArreglo.agregarProducto(producto);
        } else {
            return false;
        }
    }

    public boolean eliminarProductoALaOrden(String id) {
        Producto producto = productoArreglo.buscarProducto(id);
        if (producto != null) {
            productoArreglo.eliminarProducto(id);
            return true;
        }
        return false;
    }

    public String mostrarOrden() {
        System.out.println("ID de Orden: " + id + "Cliente: " + cliente);
        System.out.println(" ID |          NOMBRE           |  PRECIO  |  CATEGORIA");
        System.out.println(productoArreglo);
        return null;
    }
}
