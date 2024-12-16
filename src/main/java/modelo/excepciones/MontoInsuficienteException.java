package modelo.excepciones;

public class MontoInsuficienteException extends Exception {
    public MontoInsuficienteException() {
        super("El monto ingresado es insuficiente para pagar");
    }
}
