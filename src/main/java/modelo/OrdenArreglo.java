package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class OrdenArreglo {
    private Orden[] ordenes;
    private int index;
    
    private final String ARCHIVO_ORDENES = "ordenes.txt";

    public OrdenArreglo(int tamano) {
        ordenes = new Orden[tamano];
        this.index = 0;
        
        this.cargarOrdenesTxt();
    }

    public void agregarOrden(Orden orden) {
        try {
            if (orden != null && this.index < ordenes.length) {
                ordenes[this.index] = orden;
                this.index++;
                
            } else {
                throw new ArregloLLenoException();
            }
            
        } catch (ArregloLLenoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarOrden(String id) {
        try {
            for (int i = 0; i < index; i++) {
                if (ordenes[i].getId().equals(id)) {
                    for (int j = i; j < index - 1; j++) {
                        ordenes[j] = ordenes[j + 1];
                    }
                    ordenes[index - 1] = null;
                    index--;
                    
                    actualizarOrdenesTxt();
                    return;
                }
                
                throw new IdNoEncontradoException();
            }
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Orden buscarOrden(String id) {
        try {
            for (int i = 0; i < this.index; i++) {
                if (ordenes[i] != null && ordenes[i].getId().equals(id)) {
                    return ordenes[i];
                }
            }
            throw new IdNoEncontradoException();
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Metodos para manipular los archivos txt
    public void actualizarOrdenesTxt() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_ORDENES))) {

            // Recorre el arreglo de ordenes y guarda cada orden en el archivo
            for (int i = 0; i < index; i++) {
                if (ordenes[i] != null) {
                    String lineaOrden = ordenes[i].toString();

                    // Guarda la línea en el archivo
                    writer.write(lineaOrden);
                    writer.newLine();  // Agrega una línea en blanco para separar órdenes
                }
            }

        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de ordenes: " + e.getMessage());
        }
    }

    private void cargarOrdenesTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_ORDENES))) {
            String linea;

            while ( (linea = reader.readLine()) != null) {
                
                // Divide la línea usando ":" como separador y eliminando espacios en los extremos
                String[] datos = linea.split(" : ");
                
                String id = datos[0].trim();
                String cliente = datos[1].trim();
                String estado = datos[2].trim();
                
                Orden orden = new Orden(id, cliente, estado);
                    
                // Buscar y procesar los productos (se encuentran entre corchetes)
                String productosLine = linea.substring(linea.indexOf("[") + 1, linea.indexOf("]")).trim();

                // Dividir los productos por coma
                String[] productos = productosLine.split(" , ");

                for (String productoData : productos) {
                    // Separar los detalles de cada producto
                    String[] detallesProducto = productoData.split(" : ");
                        
                    String idProducto = detallesProducto[0].trim();
                    String nombreProducto = detallesProducto[1].trim();
                    float precioProducto = Float.parseFloat(detallesProducto[2].trim());
                    String categoriaProducto = detallesProducto[3].trim();

                    // Crear el objeto Producto con la información extraída
                    Producto producto = new Producto(idProducto, nombreProducto, precioProducto, categoriaProducto);

                    // Agregar el producto a la orden
                    orden.getProductoArreglo().agregarProducto(producto);
                }
                
                try {
                    if ( this.index < ordenes.length) {
                        ordenes[this.index] = orden;
                        this.index++;

                    } else {
                        throw new ArregloLLenoException();
                    }
                } catch (ArregloLLenoException e) {
                    System.out.println(e.getMessage());
                }
                
            }
            
        } catch (IOException e) {
            System.out.println("Error al cargar las ordenes desde el archivo: " + e.getMessage());
        }
    }
    
    public int getIndex() {
        return index;
    }

    public Orden[] getOrdenes() {
        return ordenes;
    }

    @Override
    public String toString() {
        String resultado = "=========================================================\n";
        resultado += "Listado de Órdenes:\n";
        for (int i = 0; i < this.index; i++) {
            resultado += ordenes[i] + "\n";
        }
        return resultado;
    }
}
