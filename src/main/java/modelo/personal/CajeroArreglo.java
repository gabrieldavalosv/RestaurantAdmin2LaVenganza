package modelo.personal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class CajeroArreglo {
    private Cajero[] cajeros;
    private int index;
    
    private static String ARCHIVO_CAJEROS = "cajeros.txt";

    public CajeroArreglo(int tamano) {
        cajeros = new Cajero[tamano];
        this.index = 0;
        
        // Cargar cajeros desde el archivo al iniciar
        this.cargarCajerosTxt();
    }

    public void agregarCajero(Cajero cajero) {
        try {
            if (cajero != null && this.index < cajeros.length) {
                cajeros[this.index] = cajero;
                this.index++;
                
                // Actualizamos el archivo después de agregar el cajero
                actualizarCajerosTxt();
            
            } else {
                throw new ArregloLLenoException();
            }
        } catch (ArregloLLenoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarCajero(String id) {
        try {
            for (int i = 0; i < index; i++) {
                if (cajeros[i].getId().equals(id)) {
                    for (int j = i; j < index - 1; j++) {
                        cajeros[j] = cajeros[j + 1];
                    }
                    cajeros[index - 1] = null;
                    index--;
                    
                    // Actualizamos el archivo después de eliminar el cajero
                    actualizarCajerosTxt();
                    return;
                }
            }
            
            throw new IdNoEncontradoException();    
               
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cajero buscarCajero(String id) {
        try {
            for (int i = 0; i < this.index; i++) {
                if (cajeros[i] != null && cajeros[i].getId().equals(id)) {
                    return cajeros[i];
                }
            }
            throw new IdNoEncontradoException();
        } catch (IdNoEncontradoException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    // Metodos para manipular los archivos txt
    private void actualizarCajerosTxt() {
        try (BufferedWriter writer = new BufferedWriter( new FileWriter(ARCHIVO_CAJEROS) ) ) {

            // Recorre el arreglo de cajeros y guarda cada cajero en el archivo
            for (int i = 0; i < index; i++) {
                if (cajeros[i] != null) {
                    writer.write(cajeros[i].toString());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de cajeros: " + e.getMessage());
        }
    }

    private void cargarCajerosTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CAJEROS))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                try {
                    // Divide la línea usando ":" como separador
                    String[] datos = linea.split(" : ");

                    // Validar que haya al menos 4 datos
                    if (datos.length < 4) {
                        System.out.println("Línea no válida en cajeros.txt: " + linea);
                        continue;
                    }

                    // Extraer y limpiar los datos
                    String id = datos[0].trim();
                    String nombre = datos[1].trim();
                    String contrasenia = datos[2].trim();
                    String ruc = datos[3].trim();

                    // Crear el objeto Cajero
                    Cajero cajero = new Cajero(id, nombre, contrasenia, ruc);

                    // Verificar capacidad del arreglo
                    if (this.index < cajeros.length) {
                        cajeros[this.index] = cajero;
                        this.index++;
                    } else {
                        throw new ArregloLLenoException();
                    }

                } catch (ArregloLLenoException e) {
                    System.out.println(e.getMessage());
                    break; // Detiene el bucle si el arreglo está lleno
                } catch (Exception e) {
                    System.out.println("Error procesando la línea: " + linea + " - " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar los cajeros desde el archivo: " + e.getMessage());
        }
    }


    public static Cajero buscarCajerosTxt(String nombreIngresado, String contraseniaIngresada) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CAJEROS))) {
            String linea;

            while ( (linea = reader.readLine()) != null ) {
                
                // Divide la línea usando ":" como separador y eliminando espacios en los extremos
                String[] datos = linea.split(" : ");
                
                String id = datos[0].trim();
                String nombre = datos[1].trim();
                String contrasenia = datos[2].trim();
                String ruc = datos[3].trim();
                
                if( nombre.equals(nombreIngresado) && contrasenia.equals(contraseniaIngresada) ){
                    Cajero cajero = new Cajero(id, nombre, contrasenia, ruc);
                    return cajero;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar los cajeros desde el archivo: " + e.getMessage());
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        String resultado = "=========================================================\n";
        resultado += "Listado de Cajeros:\n";
        for (int i = 0; i < this.index; i++) {
            resultado += cajeros[i] + "\n";
        }
        return resultado;
    }

    public int getIndex() {
        return index;
    }

    public Cajero[] getCajeros() {
        return cajeros;
    }
}
