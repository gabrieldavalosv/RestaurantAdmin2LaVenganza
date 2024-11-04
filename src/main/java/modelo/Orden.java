package modelo;

import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class Orden {
    private String id;
    private ProductoArreglo productoArreglo;
    private String estado;
    private String cliente;
    
    public Orden(String id){
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

    public boolean agregarProductoALaOrden(String id, Menu menu) throws ArregloLLenoException, IdNoEncontradoException {
        Producto producto = menu.productoArreglo.buscarProducto(id);
        if (producto != null) {
            productoArreglo.agregarProducto(producto);
            return true;
        }
        return false;
    }

    public boolean eliminarProductoALaOrden(String id) throws IdNoEncontradoException {
        Producto producto = productoArreglo.buscarProducto(id);
        if (producto != null) {
            productoArreglo.eliminarProducto(id);
            return true;
        }
        return false;
    }
    
    public float calcularPrecioTotal(){
        float total = 0.0f;
        
        if( productoArreglo.getIndex() == 0 ){
            return total;
        }
        
        for( Producto producto: productoArreglo.getProductos() ){
            if( producto != null ){
                total += producto.getPrecio();
            }
        }
        
        return total;
    }

    @Override
    public String toString() {
        String resultado = "ID de Orden: " + getId() + "Cliente: " + getCliente();
        resultado +=" ID |          NOMBRE           |  PRECIO  |  CATEGORIA";
        resultado += productoArreglo;
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
