package modelo.excepciones;

public class IdNoEncontradoException extends Exception {
    public IdNoEncontradoException() {
        super("No se ha encontrado el elemento que busca por la id");
    }
}
