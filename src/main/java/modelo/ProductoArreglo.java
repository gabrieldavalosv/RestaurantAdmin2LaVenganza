package modelo;

import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class ProductoArreglo {
    private Producto[] productos;
    private int index;

    public ProductoArreglo(int tamano) {
        productos = new Producto[tamano];
        this.index = 0;
    }

    public void agregarProducto(Producto producto){
        try {
            if (producto != null && this.index < productos.length) {
                productos[this.index] = producto;
                this.index++;
            } else {
                throw new ArregloLLenoException();
            }
        } catch (ArregloLLenoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarProducto(String id){
        try {
            for (int i = 0; i < index; i++) {
                if (productos[i].getId().equals(id)) {
                    for (int j = i; j < index - 1; j++) {
                        productos[j] = productos[j + 1];
                    }
                    productos[index - 1] = null;
                    index--;
                } else {
                    throw new IdNoEncontradoException();
                }
            }
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Producto buscarProducto(String id){
        try {
            for (int i = 0; i < this.index; i++) {
                if ( productos[i] != null && productos[i].getId().equals(id) ){
                    return productos[i];
                }
            }
            throw new IdNoEncontradoException();
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
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


