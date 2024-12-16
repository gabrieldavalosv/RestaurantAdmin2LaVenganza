package controlador;

import modelo.Orden;
import modelo.Menu;
import modelo.Producto;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.personal.Trabajador;
import vista.GestionDeOrden;
import vista.GestionDePagos;
import vista.PanelPrincipal;

/**
 * @author Davi
 */

public class CtrlGestionDeOrden {
    private Orden modelo;
    private GestionDeOrden vista;
    private Trabajador trabajador;

    private Menu menu;

    public CtrlGestionDeOrden(Orden modelo, GestionDeOrden vista, Trabajador trabajador) {
        this.vista = vista;
        this.modelo = modelo;
        this.trabajador = trabajador;

        vista.labelCliente.setText("Cliente: " + modelo.getCliente());
        vista.labelPrecioTotal.setText("Precio total : " + modelo.calcularPrecioTotal());
        vista.labelTituloOrden.setText("Gestión de Orden " + modelo.getId());

        this.actualizarTablaProductos();
        this.mostrarMenu();

        vista.buttonAgregarProducto.addActionListener(e -> this.eventoAgregarProducto());
        vista.buttonEliminarProducto.addActionListener(e -> this.eventoEliminarProducto());
        vista.buttonTerminarOrden.addActionListener(e -> this.eventoTerminarOrden());
        vista.buttonCancelarPanel.addActionListener(e ->this.eventoCancelarOrden());

        this.vista.setVisible(true);
    }

    private void irGestionarPago() {
        var vistaPago = new GestionDePagos();
        var ctrlPago = new CtrlGestionDePagos(modelo, vistaPago, trabajador);
    }

    private void irPanelPrincipal() {
        var vistaPanel = new PanelPrincipal();
        var ctrlPanel = new CtrlPanelPrincipal(trabajador, vistaPanel);

        vista.dispose();
    }

    private void actualizarTablaProductos() {
        var tablaProductos = (DefaultTableModel) vista.tablaOrdenProductos.getModel();

        tablaProductos.setRowCount(0);

        for (Producto p : modelo.getProductoArreglo().getProductos()) {
            if (p != null) {
                tablaProductos.addRow(new Object[]{p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio()});
            }
        }

        boolean isTerminada = modelo.getEstado().equals("Terminada");

        vista.buttonAgregarProducto.setEnabled(!isTerminada);
        vista.buttonEliminarProducto.setEnabled(!isTerminada);
        vista.buttonTerminarOrden.setEnabled(!isTerminada);

    }

    private void mostrarMenu() {
        menu = new Menu();

        var tablaMenu = (DefaultTableModel) vista.tablaMenu.getModel();

        for (Producto p : menu.getProductoArreglo().getProductos()) {
            if (p != null) {
                tablaMenu.addRow(new Object[]{p.getId(), p.getNombre(), p.getCategoria(), p.getPrecio()});
            }
        }
    }

    private void eventoAgregarProducto() {
        int filaSeleccionada = vista.tablaMenu.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor, primero ingrese un id de un producto.");
            return;
        }
        
        Object idProducto = vista.tablaMenu.getValueAt(filaSeleccionada, 0);

        if (modelo.agregarProductoALaOrden(idProducto.toString(), menu)) {
            var producto = modelo.getProductoArreglo().buscarProducto(idProducto.toString());
            var tablaProductos = (DefaultTableModel) vista.tablaOrdenProductos.getModel();

            tablaProductos.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCategoria(), producto.getPrecio()});
            vista.labelPrecioTotal.setText("Precio total : " + modelo.calcularPrecioTotal());

        } else {
            JOptionPane.showMessageDialog(vista, "El producto con id " + idProducto + " no fue encontrado...");
        }
    }

    private void eventoEliminarProducto() {
        int filaSeleccionada = vista.tablaOrdenProductos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor, primero ingrese un id de un producto.");
            return;
        }
        
        Object idProducto = vista.tablaOrdenProductos.getValueAt(filaSeleccionada, 0);

        if (modelo.eliminarProductoALaOrden(idProducto.toString())) {
            var tablaProductos = (DefaultTableModel) vista.tablaOrdenProductos.getModel();

            int posicion = -1;
            for (int i = 0; i < tablaProductos.getRowCount(); i++) {
                if (tablaProductos.getValueAt(i, 0).toString().equals(idProducto)) {
                    posicion = i;
                    break;
                }
            }

            if (posicion != -1) {
                tablaProductos.removeRow(posicion);
                vista.labelPrecioTotal.setText("Precio total : " + modelo.calcularPrecioTotal());
            } else {
                JOptionPane.showMessageDialog(vista, "El producto no está en la tabla.");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "El producto con id " + idProducto + " no fue encontrado en la orden.");
        }
    }


    private void eventoTerminarOrden() {
        this.vista.dispose();

        irGestionarPago();
    }

    private void eventoCancelarOrden() {
        try {
            Trabajador.getOrdenes().eliminarOrden(modelo.getId());
            JOptionPane.showMessageDialog(vista, "Orden eliminada exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "No se pudo eliminar la orden: " + e.getMessage());
        } finally {
            this.vista.dispose();
            irPanelPrincipal();
        }
    }


}