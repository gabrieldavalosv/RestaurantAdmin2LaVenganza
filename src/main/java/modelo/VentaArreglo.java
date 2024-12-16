package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class VentaArreglo {
    private Venta[] ventas;
    private int index;
    
    private final String ARCHIVO_VENTAS = "ventas.txt";

    public VentaArreglo(int tamano) {
        ventas = new Venta[tamano];
        this.index = 0;
        
        this.cargarVentasTxt();
    }
    
    public void agregarVenta(Venta venta) {
        try {
            if (venta != null && this.index < ventas.length) {
                ventas[this.index] = venta;
                this.index++;
                
                actualizarVentasTxt();
            }
            
            throw new ArregloLLenoException();
            
        } catch (ArregloLLenoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Venta buscarVenta(String id) {
        try {
            for (int i = 0; i < this.index; i++) {
                if (ventas[i] != null && ventas[i].getId().equals(id)) {
                    return ventas[i];
                }
            }
            
            throw new IdNoEncontradoException();
            
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Metodos para manipular los archivos txt
    private void actualizarVentasTxt() {
        try (BufferedWriter writer = new BufferedWriter( new FileWriter(ARCHIVO_VENTAS, false) ) ) {

            // Recorre el arreglo de ventas y guarda cada venta en el archivo
            for (int i = 0; i < index; i++) {
                if (ventas[i] != null) {
                    writer.write(ventas[i].toString());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de ventas: " + e.getMessage());
        }
    }

    private void cargarVentasTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_VENTAS))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                try {
                    String[] datos = linea.split(" : ");

                    if (datos.length < 4) {
                        System.out.println("Línea no válida en ventas.txt: " + linea);
                        continue;
                    }

                    // Extraer y limpiar los datos
                    String idOrden = datos[0].trim();
                    String fecha = datos[1].trim();
                    float monto = Float.parseFloat(datos[2].trim());
                    String metodoPago = datos[3].trim();

                    // Buscar la orden asociada en el sistema
                    Orden orden = OrdenArreglo.buscarOrdenTxt(idOrden);
                    if (orden == null) {
                        System.out.println("Orden no encontrada para ID: " + idOrden);
                        continue; // Salta si no existe la orden
                    }

                    // Crear el objeto Pago
                    Pago pago = new Pago(monto, new MetodoPago(metodoPago));

                    // Crear la venta y agregarla al arreglo
                    Venta venta = new Venta(orden, fecha, pago);

                    if (this.index < ventas.length) {
                        ventas[this.index] = venta;
                        this.index++;
                    } else {
                        throw new ArregloLLenoException();
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error en el formato del monto en línea: " + linea);
                } catch (ArregloLLenoException e) {
                    System.out.println(e.getMessage());
                    break; // Termina si el arreglo está lleno
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo ventas.txt: " + e.getMessage());
        }
    }
    
    public int getIndex() {
        return index;
    }

    public Venta[] getVentas() {
        return ventas;
    }
}
