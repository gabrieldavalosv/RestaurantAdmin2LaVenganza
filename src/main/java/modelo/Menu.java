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

    @Override
    public String toString() {
        String resultado = " ID |          NOMBRE           |  PRECIO  |  CATEGORIA\n";
        resultado += productoArreglo;
        return resultado;
    }
}
