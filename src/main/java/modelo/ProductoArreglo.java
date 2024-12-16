package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class ProductoArreglo {
    private Producto[] productos;
    private int index;
    
    private final String ARCHIVO_PRODUCTOS = "productos.txt";

    public ProductoArreglo(int tamano) {
        productos = new Producto[tamano];
        this.index = 0;
    }

    public void agregarProducto(Producto producto) {
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

    public void eliminarProducto(String id) {
        try {
            for (int i = 0; i < index; i++) {
                if (productos[i].getId().equals(id)) {
                    for (int j = i; j < index - 1; j++) {
                        productos[j] = productos[j + 1];
                    }
                    productos[index - 1] = null;
                    index--;
                    
                    return;
                }
            }

            throw new IdNoEncontradoException();
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }


    public Producto buscarProducto(String id) {
        try {
            for (int i = 0; i < this.index; i++) {
                if (productos[i] != null && productos[i].getId().equals(id)) {
                    return productos[i];
                }
            }
            throw new IdNoEncontradoException();
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public Producto getUltimoProducto(){
        try ( BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_PRODUCTOS))) {
            String linea;
            boolean isUltimoProducto;
            Producto ultimoProducto = null;
            
            while ( (linea = reader.readLine()) != null ) {
                String[] datos = linea.split(" : ");
                
                String id = datos[0].trim();
                String nombre = datos[1].trim();
                float precio = Float.parseFloat(datos[2].trim());
                String categoria = datos[3].trim();
                
                ultimoProducto = new Producto(id, nombre, precio, categoria);
            }
            
            return ultimoProducto;

        } catch (IOException e) {
            System.out.println("Error al cargar los productos desde el archivo: " + e.getMessage());
        }
        
        return null;
    }

    // Metodos para manipular los archivos txt
    public void actualizarProductosTxt() {
        try (BufferedWriter writer = new BufferedWriter( new FileWriter(ARCHIVO_PRODUCTOS) ) ) {

            // Recorre el arreglo de cajeros y guarda cada cajero en el archivo
            for (int i = 0; i < index; i++) {
                if (productos[i] != null) {
                    writer.write(productos[i].toString());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de productos: " + e.getMessage());
        }
    }

    public void cargarProductosTxt() {
        try ( BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_PRODUCTOS))) {
            String linea;

            while ( (linea = reader.readLine()) != null ) {
                
                // Divide la línea usando ":" como separador y eliminando espacios en los extremos
                String[] datos = linea.split(" : ");
                
                String id = datos[0].trim();
                String nombre = datos[1].trim();
                float precio = Float.parseFloat( datos[2].trim() );
                String categoria = datos[3].trim();

                Producto producto = new Producto(id, nombre, precio, categoria);

                try {
                    if ( this.index < productos.length) {
                        productos[this.index] = producto;
                        this.index++;

                    } else {
                        throw new ArregloLLenoException();
                    }
                } catch (ArregloLLenoException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar los productos desde el archivo: " + e.getMessage());
        }
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


