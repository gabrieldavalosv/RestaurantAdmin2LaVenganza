package modelo;

public class Orden {
    private String id;
    private ProductoArreglo productoArreglo;
    private String estado;
    private String cliente;

    public Orden(String id, String cliente) {
        this.id = id;
        this.productoArreglo = new ProductoArreglo(20);
        this.estado = "Cocinando";
        this.cliente = cliente;
    }

    public boolean agregarProducto(String id, Menu menu) {
        Producto producto = menu.productoArreglo.buscarProducto(id);
        if (producto != null) {
            return productoArreglo.agregarProducto(producto);
        } else {
            return false;
        }
    }

    public void mostrarOrden() {
        System.out.println("Orden de " + cliente + " con id " + id);
        System.out.println(" ID |          NOMBRE           |  PRECIO  |  CATEGORIA");
        System.out.println(productoArreglo);
    }
}
