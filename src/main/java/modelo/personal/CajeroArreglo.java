package modelo.personal;

import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class CajeroArreglo {
    private Cajero[] cajeros;
    private int index;

    public CajeroArreglo(int tamano) {
        cajeros = new Cajero[tamano];
        this.index = 0;
    }

    public void agregarCajero(Cajero cajero) {
        try {
            if (cajero != null && this.index < cajeros.length) {
                cajeros[this.index] = cajero;
                this.index++;
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
                } else {
                    throw new IdNoEncontradoException();
                }
            }
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

    @Override
    public String toString() {
        String resultado = "=========================================================\n";
        resultado += "Listado de Cajeros:\n";
        for (int i = 0; i < this.index; i++) {
            resultado += cajeros[i] + "\n";
        }
        return resultado;
    }
}
