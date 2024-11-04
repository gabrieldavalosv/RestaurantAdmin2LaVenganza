package modelo.excepciones;

public class ArregloLLenoException extends Exception {
    public ArregloLLenoException() {
        super("El arreglo se encuentra lleno y no se puede agregar nada mas");
    }
}
