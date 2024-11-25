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
        try ( BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_VENTAS))) {
            String linea;

            while ( (linea = reader.readLine()) != null ) {
                
                // Divide la línea usando ":" como separador y eliminando espacios en los extremos
                String[] datos = linea.split(" : ");
                
                String id = datos[0].trim();
                var orden = OrdenArreglo.buscarOrdenTxt(id);
                
                if( orden != null){
                    
                    String fecha = datos[1].trim();
                    Pago pago = new Pago( Float.parseFloat( datos[2].trim() ), new MetodoPago( datos[3].trim() ) );
                
                    Venta venta = new Venta(orden, fecha, pago);

                    try {
                        if ( this.index < ventas.length) {
                            ventas[this.index] = venta;
                            this.index++;

                        } else {
                            throw new ArregloLLenoException();
                        }
                    } catch (ArregloLLenoException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar las ventas desde el archivo: " + e.getMessage());
        }
    }
    
    public int getIndex() {
        return index;
    }

    public Venta[] getVentas() {
        return ventas;
    }
}
