package modelo.excepciones;

public class MontoInsuficienteException extends RuntimeException {
    public MontoInsuficienteException() {
        super("El monto ingresado es insuficiente para pagar");
    }
}
