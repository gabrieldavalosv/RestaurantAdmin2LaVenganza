package modelo;

public class ProductoArreglo {
    private Producto[] productos;
    private int index;

    public ProductoArreglo(int tamano) {
        productos = new Producto[tamano];
        this.index = 0;
    }

    public boolean agregarProducto(Producto producto) {
        boolean resultado = false;
        if (this.index < productos.length) {
            productos[this.index] = producto;
            this.index++;
            resultado = true;
        }
        return resultado;
    }

    public boolean eliminarProducto(String id) {
        for (int i = 0; i < index; i++) {
            if (productos[i].getId().equals(id)) {
                for (int j = i; j < index - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[index - 1] = null;
                index--;
                
                // Actualizar los IDs para que sean secuenciales
                for (int j = 0; j < index; j++) {
                    productos[j].setId(String.valueOf(j));
                }
                return true;
            }
        }
        return false;
    }

    public Producto buscarProducto(String id) {
        for (int i = 0; i < this.index; i++) {
            if ( productos[i] != null && productos[i].getId().equals(id) ){
                return productos[i];
            }
        }
        return null;
    }
    
    public Producto[] getProductos() {
        return productos;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        String resultado = "=========================================================\n";
        for (int i = 0; i < this.index; i++) {
            resultado += this.productos[i] + "\n";
        }
        return resultado;
    }

}


