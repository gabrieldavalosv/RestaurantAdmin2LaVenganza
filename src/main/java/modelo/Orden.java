package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Orden {
    // Identificador único de la orden
    private String id;

    // Lista de productos incluidos en la orden
    private List<Producto> productos;

    // Lista de combos incluidos en la orden
    private List<Combo> combos;

    // Estado actual de la orden
    private String estado;

    // Referencia a la cocina encargada de preparar la orden
    private Cocina cocina;

    // Lista estática de estados válidos para una orden
    private static final List<String> ESTADOS_VALIDOS =
            Arrays.asList("Nueva", "En Preparación", "Lista", "Entregada", "Cancelada");


    public Orden(String id, Cocina cocina) {
        // Validación: El ID y la cocina no pueden ser null
        if (id == null || cocina == null) {
            throw new IllegalArgumentException("ID y cocina no pueden ser null");
        }
        this.id = id;
        this.productos = new ArrayList<>();
        this.combos = new ArrayList<>();
        this.estado = "Nueva"; // Estado inicial de la orden
        this.cocina = cocina;
    }


    public String getId() {
        return id;
    }


    public List<Producto> getProductos() {
        // Retorna una copia de la lista de productos para proteger la integridad de los datos
        return new ArrayList<>(productos);
    }


    public List<Combo> getCombos() {
        // Retorna una copia de la lista de combos para proteger la integridad de los datos
        return new ArrayList<>(combos);
    }



    public String getEstado() {
        return estado;
    }


    public void agregarProducto(Producto producto) {
        // Validación: El producto no puede ser null
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null");
        }
        productos.add(producto); // Añade el producto a la lista de productos
    }

    public void agregarCombo(Combo combo) {
        // Validación: El combo no puede ser null
        if (combo == null) {
            throw new IllegalArgumentException("El combo no puede ser null");
        }
        combos.add(combo); // Añade el combo a la lista de combos
    }


    public Float calcularTotal() {
        float total = 0;

        // Suma los precios de todos los productos en la orden
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        // Suma los precios totales de todos los combos en la orden
        for (Combo combo : combos) {
            total += combo.calcularPrecioTotal();
        }

        return total; // Retorna el total calculado
    }


    public void actualizarEstado(String nuevoEstado) {
        // Validación: El nuevo estado debe estar en la lista de estados válidos
        if (!ESTADOS_VALIDOS.contains(nuevoEstado)) {
            throw new IllegalArgumentException("Estado no válido");
        }
        this.estado = nuevoEstado; // Actualiza el estado de la orden

        // Si el nuevo estado es "En Preparación", se solicita a la cocina que prepare la orden
        if (nuevoEstado.equals("En Preparación")) {
            cocina.prepararOrden(this);
        }
    }
}
