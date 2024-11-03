package modelo;

public class CajeroArreglo {
    private Cajero[] cajeros;
    private int index;

    public CajeroArreglo(int tamano) {
        cajeros = new Cajero[tamano];
        this.index = 0;
    }

    public boolean agregarCajero(Cajero cajero) {
        boolean resultado = false;
        if (this.index < cajeros.length) {
            cajeros[this.index] = cajero;
            this.index++;
            resultado = true;
        }
        return resultado;
    }

    public boolean eliminarCajero(String id) {
        for (int i = 0; i < index; i++) {
            if (cajeros[i].getId().equals(id)) {
                for (int j = i; j < index - 1; j++) {
                    cajeros[j] = cajeros[j + 1];
                }
                cajeros[index - 1] = null;
                index--;
                return true;
            }
        }
        return false;
    }

    public Cajero buscarCajero(String id) {
        for (int i = 0; i < this.index; i++) {
            if (cajeros[i] != null && cajeros[i].getId().equals(id)) {
                return cajeros[i];
            }
        }
        return null;
    }
}
