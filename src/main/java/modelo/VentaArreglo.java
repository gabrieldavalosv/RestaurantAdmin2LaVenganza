package modelo;

import modelo.excepciones.ArregloLLenoException;
import modelo.excepciones.IdNoEncontradoException;

public class VentaArreglo {
    private Venta[] ventas;
    private int index;

    public VentaArreglo(int tamano) {
        ventas = new Venta[tamano];
        this.index = 0;
    }

    public void agregarOrden(Venta venta) {
        try {
            if (venta != null && this.index < ventas.length) {
                ventas[this.index] = venta;
                this.index++;
            } else {
                throw new ArregloLLenoException();
            }
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

    public int getIndex() {
        return index;
    }

    public Venta[] getVentas() {
        return ventas;
    }
}
