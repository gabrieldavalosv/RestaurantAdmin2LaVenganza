package modelo;

import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class OrdenArreglo {
    private Orden[] ordenes;
    private int index;

    public OrdenArreglo(int tamano) {
        ordenes = new Orden[tamano];
        this.index = 0;
    }



    public void agregarOrden(Orden orden) throws ArregloLLenoException {
        if (this.index < ordenes.length) {
            ordenes[this.index] = orden;
            this.index++;
        } else {
            throw new ArregloLLenoException();
        }
    }

    public void eliminarOrden(String id) throws IdNoEncontradoException {
        for (int i = 0; i < index; i++) {
            if (ordenes[i].getId().equals(id)) {
                for (int j = i; j < index - 1; j++) {
                    ordenes[j] = ordenes[j + 1];
                }
                ordenes[index - 1] = null;
                index--;
            } else {
                throw new IdNoEncontradoException();
            }
        }
    }

    public Orden buscarOrden(String id) throws IdNoEncontradoException {
        for (int i = 0; i < this.index; i++) {
            if (ordenes[i] != null && ordenes[i].getId().equals(id)) {
                return ordenes[i];
            }
        }
        throw new IdNoEncontradoException();
    }

    public int getIndex() {
        return index;
    }    

    public Orden[] getOrdenes() {
        return ordenes;
    }
    
    @Override
    public String toString() {
        String resultado = "=========================================================\n";
        resultado += "Listado de Órdenes:\n";
        for (int i = 0; i < this.index; i++) {
            resultado += ordenes[i] + "\n";
        }
        return resultado;
    }
}
