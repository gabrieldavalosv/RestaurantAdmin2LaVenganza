package controlador;

import modelo.Menu;
import modelo.Producto;
import modelo.personal.Trabajador;
import vista.GestionDePlatos;
import vista.GestionDelMenu;
import vista.PanelPrincipal;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class CtrlGestionDeMenu {
    private Trabajador modelo;
    private Menu menu;
    private GestionDelMenu vista;

    public CtrlGestionDeMenu(Trabajador modelo, Menu menu, GestionDelMenu vista) {
        this.modelo = modelo;
        this.menu = menu;
        this.vista = vista;

        // Inicialización de datos en la vista
        vista.labelRol.setText("Rol: " + modelo.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + modelo.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + modelo.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        vista.buttonVolverPanel.addActionListener(e -> this.irPanelPrincipal());

        this.actualizarTablaMenu();
        this.mostrarMenu();

        vista.buttonObtenterPlato.addActionListener(e -> this.eventoObtenerPlato());
        vista.buttonAgregarPlato.addActionListener(e -> this.eventoAgregarPlato());
        vista.buttonModificarPlato.addActionListener(e -> this.eventoModificarPlato());
        vista.buttonEliminarPlato.addActionListener(e -> this.eventoEliminarPlato());
        this.vista.setVisible(true);
    }

    private void irPanelPrincipal() {
        var vistaPanel = new PanelPrincipal();
        var ctrlPanel = new CtrlPanelPrincipal(modelo, vistaPanel);

        vista.dispose();
    }

    private void mostrarMenu() {

        var tablaMenu = (DefaultTableModel) vista.tablaMenu.getModel();

        for (Producto p : menu.getProductoArreglo().getProductos()) {
            if (p != null) {
                tablaMenu.addRow(new Object[]{p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio()});
            }
        }

        vista.tablaMenu.revalidate();
        vista.tablaMenu.repaint();
    }

    private void eventoAgregarPlato() {
        String nombre = vista.fieldNombre.getText();
        String precio = vista.fieldPrecio.getText();
        String categoria = vista.fieldCategoria.getText();

        if (nombre.isEmpty() || precio.isEmpty() || categoria.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Error. Todos los campos deben estar llenos");
            return;
        }

        Producto ultimoProducto = menu.getProductoArreglo().getUltimoProducto();
        String idProducto = String.valueOf(Integer.parseInt(ultimoProducto.getId()) + 1);
        float precioFloat = Float.parseFloat(precio);

        Producto nuevoProducto = new Producto(idProducto, nombre, precioFloat, categoria);

        if (!menu.agregarProducto(nuevoProducto)) {
            return;
        }

        JOptionPane.showMessageDialog(vista, "Plato agregado en el menú correctamente!");
        actualizarTablaMenu();
        limpiarInputs();
    }

    private void actualizarTablaMenu() {
        var tablaMenu = (DefaultTableModel) vista.tablaMenu.getModel();

        tablaMenu.setRowCount(0);

        for (Producto p : menu.getProductoArreglo().getProductos()) {
            if (p != null) {
                tablaMenu.addRow(new Object[]{p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio()});
            }
        }
    }

    private void eventoModificarPlato() {
        String nombre = vista.fieldNombre.getText();
        String precio = vista.fieldPrecio.getText();
        String categoria = vista.fieldCategoria.getText();

        if (nombre.isEmpty() || precio.isEmpty() || categoria.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Error. Todos los campos deben estar llenos");
            return;
        }

        Producto ultimoProducto = menu.getProductoArreglo().getUltimoProducto();
        String idProducto = String.valueOf(Integer.parseInt(ultimoProducto.getId()) + 1);
        float precioFloat = Float.parseFloat(precio);

        int filaSeleccionada = vista.tablaMenu.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor, primero seleccione un plato.");
            return;
        }

        Object idProductoSeleccionado = vista.tablaMenu.getValueAt(filaSeleccionada, 0);

        if (!menu.modificarProducto(idProductoSeleccionado.toString(), nombre, categoria, precioFloat)) {
            return;
        }

        JOptionPane.showMessageDialog(vista, "Plato modificado en el menú correctamente!");
        actualizarTablaMenu();
        limpiarInputs();
    }

    private void eventoEliminarPlato() {
        int filaSeleccionada = vista.tablaMenu.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor, primero seleccione un plato.");
            return;
        }

        Object idProducto = vista.tablaMenu.getValueAt(filaSeleccionada, 0);

        if (!menu.eliminarProducto(idProducto.toString())) {
            JOptionPane.showMessageDialog(vista, "Id invalido: " + idProducto.toString());
            return;
        }

        var tablaMenu = (DefaultTableModel) vista.tablaMenu.getModel();

        tablaMenu.removeRow(filaSeleccionada);
        JOptionPane.showMessageDialog(vista, "Plato eliminado del menu correctamente!");

        actualizarTablaMenu();
        this.mostrarMenu();
    }

    public void limpiarInputs() {
        vista.fieldNombre.setText("");
        vista.fieldPrecio.setText("");
        vista.fieldCategoria.setText("");

    }

    private void eventoObtenerPlato() {
        int filaSeleccionada = vista.tablaMenu.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor, primero seleccione un plato.");
            return;
        }

        Object nombreProducto = vista.tablaMenu.getValueAt(filaSeleccionada, 1);
        Object categoriaProducto = vista.tablaMenu.getValueAt(filaSeleccionada, 2);
        Object precioProducto = vista.tablaMenu.getValueAt(filaSeleccionada, 3);


        vista.fieldNombre.setText(nombreProducto.toString());
        vista.fieldCategoria.setText(categoriaProducto.toString());
        vista.fieldPrecio.setText(precioProducto.toString());
    }
}
