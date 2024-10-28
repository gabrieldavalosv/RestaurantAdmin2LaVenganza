package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Orden {
    private String id;
    private List<Producto> productos;
    private List<Combo> combos;
    private String estado;
    private Cocina cocina;
    private static final List<String> ESTADOS_VALIDOS =
            Arrays.asList("Nueva", "En Preparación", "Lista", "Entregada", "Cancelada");

    public Orden(String id, Cocina cocina) {
        if (id == null || cocina == null) {
            throw new IllegalArgumentException("ID y cocina no pueden ser null");
        }
        this.id = id;
        this.productos = new ArrayList<>();
        this.combos = new ArrayList<>();
        this.estado = "Nueva";
        this.cocina = cocina;
    }

    public String getId() {
        return id;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public List<Combo> getCombos() {
        return new ArrayList<>(combos);
    }

    public String getEstado() {
        return estado;
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null");
        }
        productos.add(producto);
    }

    public void agregarCombo(Combo combo) {
        if (combo == null) {
            throw new IllegalArgumentException("El combo no puede ser null");
        }
        combos.add(combo);
    }

    public Float calcularTotal() {
        float total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        for (Combo combo : combos) {
            total += combo.calcularPrecioTotal();
        }
        return total;
    }

    public void actualizarEstado(String nuevoEstado) {
        if (!ESTADOS_VALIDOS.contains(nuevoEstado)) {
            throw new IllegalArgumentException("Estado no válido");
        }
        this.estado = nuevoEstado;
        if (nuevoEstado.equals("En Preparación")) {
            cocina.prepararOrden(this);
        }
    }
}