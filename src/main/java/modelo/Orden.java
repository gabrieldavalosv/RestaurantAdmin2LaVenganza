package modelo;

public class Orden {
    private String id;
    private ProductoArreglo productoArreglo;
    private String estado;
    private String cliente;

    public Orden(String id) {
        this.id = id;
        this.estado = "En espera";
        this.productoArreglo = new ProductoArreglo(20);
    }

    public Orden(String id, String cliente) {
        this.id = id;
        this.productoArreglo = new ProductoArreglo(20);
        this.estado = "En espera";
        this.cliente = cliente;
    }
    
    public Orden(String id, String cliente, String estado) {
        this.id = id;
        this.productoArreglo = new ProductoArreglo(20);
        this.estado = estado;
        this.cliente = cliente;
    }

    public boolean agregarProductoALaOrden(String id, Menu menu) {
        Producto producto = menu.getProductoArreglo().buscarProducto(id);
        if (producto != null) {
            productoArreglo.agregarProducto(producto);
            return true;
        }
        return false;
    }

    public boolean eliminarProductoALaOrden(String id) {
        Producto producto = productoArreglo.buscarProducto(id);
        if (producto != null) {
            productoArreglo.eliminarProducto(id);
            return true;
        }
        return false;
    }

    public float calcularPrecioTotal() {
        float total = 0.0f;
        for (Producto producto : productoArreglo.getProductos()) {
            if (producto != null) {
                total += producto.getPrecio();
            }
        }
        return total;
    }


    @Override
    public String toString() {
        var productos = this.getProductoArreglo().getProductos();
        String resultado = String.format("%-1s : %-25s : %-10s", 
                                         getId(), getCliente(), getEstado() );

        // Añadir los productos en la misma línea, separados por comas
        resultado += " : [";
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) { // Verifica que no sea null
                if (i > 0) {
                    resultado += ", ";
                }
                resultado += productos[i].toString();
            }
        }
        resultado += "]";

        return resultado;
    }

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductoArreglo getProductoArreglo() {
        return productoArreglo;
    }

    public void setProductoArreglo(ProductoArreglo productoArreglo) {
        this.productoArreglo = productoArreglo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
