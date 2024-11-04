package modelo;

public class OrdenArreglo {
    private Orden[] ordenes;
    private int index;

    public OrdenArreglo(int tamano) {
        ordenes = new Orden[tamano];
        this.index = 0;
    }



    public void agregarOrden(Orden orden) {
        if (this.index < ordenes.length) {
            ordenes[this.index] = orden;
            this.index++;
        }
    }

    public void eliminarOrden(String id) {
        for (int i = 0; i < index; i++) {
            if (ordenes[i].getId().equals(id)) {
                for (int j = i; j < index - 1; j++) {
                    ordenes[j] = ordenes[j + 1];
                }
                ordenes[index - 1] = null;
                index--;
            }
        }
    }

    public Orden buscarOrden(String id) {
        for (int i = 0; i < this.index; i++) {
            if (ordenes[i] != null && ordenes[i].getId().equals(id)) {
                return ordenes[i];
            }
        }
        System.out.println("NO SE ENCONTRO LA ORDEN");
        return null;
    }

    public int getIndex() {
        return index;
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
