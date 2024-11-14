package modelo.excepciones;

public class MetodoInvalidoException extends Exception {
    public MetodoInvalidoException() {
        super("El metodo a usar no es valido");
    }
}
