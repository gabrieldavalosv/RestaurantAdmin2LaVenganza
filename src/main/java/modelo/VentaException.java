package modelo;

// Clase personalizada de excepción para manejar errores en las ventas
public class VentaException extends Exception {

    public VentaException(String message) {
        super(message); // Llama al constructor de la clase Exception con el mensaje proporcionado
    }
}