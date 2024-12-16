package modelo;

public class Menu {
    private ProductoArreglo productoArreglo;
    private int tamano = 70;

    public Menu() {
        productoArreglo = new ProductoArreglo(tamano);
        productoArreglo.cargarProductosTxt();
    }

    public ProductoArreglo getProductoArreglo() {
        return productoArreglo;
    }

    public boolean agregarProducto(Producto p){
        if( p != null ){
            
            productoArreglo.agregarProducto(p);
            productoArreglo.actualizarProductosTxt();
            
            return true;
        }

        return false;
    }
    
    public boolean eliminarProducto(String id){
        
        if ( !id.isEmpty() ){
               
            productoArreglo.eliminarProducto(id);
            productoArreglo.actualizarProductosTxt();
            
            return true;   
        }
        
        return true;
    }

    public boolean modificarProducto(String id, String nuevoNombre, String nuevoCategoria, float nuevoPrecio){
        if (id != null ){
            productoArreglo.buscarProducto(id).setNombre(nuevoNombre);
            productoArreglo.buscarProducto(id).setCategoria(nuevoCategoria);
            productoArreglo.buscarProducto(id).setPrecio(nuevoPrecio);

            productoArreglo.actualizarProductosTxt();

            return true;
        }

        return false;
    }
    
    @Override
    public String toString() {
        String resultado = " ID |          NOMBRE           |  PRECIO  |  CATEGORIA\n";
        resultado += productoArreglo;
        return resultado;
    }
}
