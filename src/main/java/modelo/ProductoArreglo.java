package modelo;

public class ProductoArreglo {
    private int index;
    private Producto[] productos;

    public ProductoArreglo(int tamano) {
        this.productos = new Producto[tamano];
        this.index = 0;
    }

    public boolean agregarProducto(Producto producto) {
        boolean resultado = false;
        if (this.index < productos.length) {
            this.productos[this.index] = producto;
            this.index++;
            resultado = true;
        }
        return resultado;
    }

    public boolean eliminarProducto(Producto producto) {
        boolean resultado = false;
        if (this.index > 0) {
            this.productos[this.index - 1] = producto;
            this.index--;
        }
        return resultado;
    }

    @Override
    public String toString() {
        String resultado = "====================================================\n";
        for (int i = 0; i < this.index; i++) {
            resultado += this.productos[i] + "\n";
        }
        return resultado;
    }

}


