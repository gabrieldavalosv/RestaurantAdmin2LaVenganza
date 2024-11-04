package modelo.personal;

public class CajeroArreglo {
    private Cajero[] cajeros;
    private int index;

    public CajeroArreglo(int tamano) {
        cajeros = new Cajero[tamano];
        this.index = 0;
    }

    public void agregarCajero(Cajero cajero) {
        if (this.index < cajeros.length) {
            cajeros[this.index] = cajero;
            this.index++;
        }
    }

    public void eliminarCajero(String id) {
        for (int i = 0; i < index; i++) {
            if (cajeros[i].getId().equals(id)) {
                for (int j = i; j < index - 1; j++) {
                    cajeros[j] = cajeros[j + 1];
                }
                cajeros[index - 1] = null;
                index--;
            }
        }
    }

    public Cajero buscarCajero(String id) {
        for (int i = 0; i < this.index; i++) {
            if (cajeros[i] != null && cajeros[i].getId().equals(id)) {
                return cajeros[i];
            }
        }
        return null;
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
