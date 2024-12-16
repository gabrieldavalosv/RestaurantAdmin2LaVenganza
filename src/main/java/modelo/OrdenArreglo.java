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

                actualizarOrdenesTxt();
            } else {
                throw new ArregloLLenoException();
            }
            
        } catch (ArregloLLenoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarOrden(String id) {
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
        }

        try {
            throw new IdNoEncontradoException();
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_ORDENES, false))) {

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

            while ((linea = reader.readLine()) != null) {
                // Divide la línea usando ":" como separador
                String[] datos = linea.split(" : ");

                // Validar que la línea tenga al menos 4 partes esperadas
                if (datos.length < 4) {
                    System.out.println("Línea no válida: " + linea);
                    continue; // Salta a la siguiente línea
                }

                try {
                    // Asignar y limpiar los datos
                    String id = datos[0].trim();
                    String cliente = datos[1].trim();
                    String estado = datos[2].trim();

                    // Crear la orden
                    Orden orden = new Orden(id, cliente, estado);

                    // Procesar los productos
                    String productosLine = datos[3].trim();

                    // Verificar si contiene productos (entre corchetes)
                    if (productosLine.startsWith("[") && productosLine.endsWith("]")) {
                        
                        // Eliminar corchetes y dividir productos por coma
                        productosLine = productosLine.substring(1, productosLine.length() - 1).trim();
                        String[] productos = productosLine.isEmpty() ? new String[0] : productosLine.split(" , ");

                        for (String productoData : productos) {
                            // Dividir los detalles del producto
                            String[] detallesProducto = productoData.split(" : ");

                            // Validar que haya al menos 4 elementos para un producto
                            if (detallesProducto.length < 4) {
                                System.out.println("Producto no válido: " + productoData);
                                continue;
                            }

                            String idProducto = detallesProducto[0].trim();
                            String nombreProducto = detallesProducto[1].trim();
                            float precioProducto = Float.parseFloat(detallesProducto[2].trim());
                            String categoriaProducto = detallesProducto[3].trim();

                            // Crear y agregar el producto a la orden
                            Producto producto = new Producto(idProducto, nombreProducto, precioProducto, categoriaProducto);
                            orden.getProductoArreglo().agregarProducto(producto);
                        }
                    }

                    // Agregar la orden al arreglo principal
                    if (this.index < ordenes.length) {
                        ordenes[this.index] = orden;
                        this.index++;
                    } else {
                        throw new ArregloLLenoException();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error al procesar el precio de un producto: " + e.getMessage());
                } catch (ArregloLLenoException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar las órdenes desde el archivo: " + e.getMessage());
        }
    }
    
    public static Orden buscarOrdenTxt(String idOrden) {
        try (BufferedReader reader = new BufferedReader(new FileReader("ordenes.txt"))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(" : ");

                if (datos.length < 4) {
                    System.out.println("Línea no válida: " + linea);
                    continue;
                }

                try {
                    // Asignar y limpiar los datos
                    String id = datos[0].trim();

                    if (id.equals(idOrden)) {
                        String cliente = datos[1].trim();
                        String estado = datos[2].trim();

                        // Crear la orden
                        Orden orden = new Orden(id, cliente, estado);

                        // Procesar los productos
                        String productosLine = datos[3].trim();

                        // Verificar si contiene productos (entre corchetes)
                        if (productosLine.startsWith("[") && productosLine.endsWith("]")) {
                            
                            // Eliminar corchetes y dividir productos por coma
                            productosLine = productosLine.substring(1, productosLine.length() - 1).trim();
                            String[] productos = productosLine.isEmpty() ? new String[0] : productosLine.split(" , ");

                            for (String productoData : productos) {
                                
                                // Dividir los detalles del producto
                                String[] detallesProducto = productoData.split(" : ");

                                if (detallesProducto.length < 4) {
                                    System.out.println("Producto no válido: " + productoData);
                                    continue;
                                }

                                String idProducto = detallesProducto[0].trim();
                                String nombreProducto = detallesProducto[1].trim();
                                float precioProducto = Float.parseFloat(detallesProducto[2].trim());
                                String categoriaProducto = detallesProducto[3].trim();

                                
                                Producto producto = new Producto(idProducto, nombreProducto, precioProducto, categoriaProducto);
                                orden.getProductoArreglo().agregarProducto(producto);
                            }
                        }

                        return orden; // Retorna la orden encontrada
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error al procesar el precio de un producto: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar las órdenes desde el archivo: " + e.getMessage());
        }

        return null; // Retorna null si no se encuentra la orden
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
