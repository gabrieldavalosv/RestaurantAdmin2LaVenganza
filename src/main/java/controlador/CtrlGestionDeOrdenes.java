package controlador;

import modelo.OrdenArreglo;
import modelo.Orden;
import modelo.Menu;


import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.personal.Trabajador;
import vista.GestionDeOrden;
import vista.GestionDeOrdenes;
import vista.PanelPrincipal;

/**
 * @author Davi
 */

public class CtrlGestionDeOrdenes {
    GestionDeOrdenes vista;
    OrdenArreglo modelo;
    Trabajador trabajador;

    private Menu menu;

    public CtrlGestionDeOrdenes(OrdenArreglo modelo, GestionDeOrdenes vista, Trabajador trabajador) {
        this.vista = vista;
        this.modelo = modelo;
        this.trabajador = trabajador;

        vista.labelRol.setText("Rol: " + trabajador.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + trabajador.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + trabajador.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        this.actualizarTablaOrdenes();

        vista.buttonVolverPanel.addActionListener(e -> this.irPanelPrincipal());
        vista.buttonAgregarOrden.addActionListener(e -> this.eventoAgregarOrden());
        vista.buttonTerminarOrden.addActionListener(e -> this.eventoTerminarOrden());

        this.vista.setVisible(true);
    }

    private void irPanelPrincipal() {
        var vistaPanel = new PanelPrincipal();
        var ctrlPanel = new CtrlPanelPrincipal(trabajador, vistaPanel);

        vista.dispose();
    }

    private void irGestionOrden(Orden orden) {
        var vistaOrden = new GestionDeOrden();
        var ctrlOrden = new CtrlGestionDeOrden(orden, vistaOrden, trabajador);

        vista.dispose();
    }

    private void actualizarTablaOrdenes() {
        var tablaOrdenes = (DefaultTableModel) vista.tablaOrdenes.getModel();
        tablaOrdenes.setRowCount(0);

        for (Orden o : modelo.getOrdenes()) {
            if (o != null) {
                tablaOrdenes.addRow(new Object[]{o.getId(), o.getCliente(), o.getEstado(), o.calcularPrecioTotal()});
            }
        }

        vista.tablaOrdenes.revalidate();
        vista.tablaOrdenes.repaint();
    }

    private void eventoAgregarOrden() {
        var ultimoId = String.valueOf(modelo.getIndex());
        var cliente = vista.fieldCliente.getText();

        if (cliente.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Primero ingrese un nombre antes de registrar una nueva órden.");
            return;
        }

        Orden orden = new Orden(ultimoId, cliente);

        modelo.agregarOrden(orden);

        var tablaOrdenes = (DefaultTableModel) vista.tablaOrdenes.getModel();

        if (orden != null) {
            tablaOrdenes.addRow(new Object[]{orden.getId(), orden.getCliente(), orden.getEstado(), orden.calcularPrecioTotal()});
            this.irGestionOrden(orden);
            actualizarTablaOrdenes();
        }

        vista.fieldCliente.setText("");
    }

    private void eventoTerminarOrden() {
        int filaSeleccionada = vista.tablaOrdenes.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una fila de la tabla.");
        } else {
            Orden orden = modelo.getOrdenes()[filaSeleccionada];
            
            modelo.buscarOrden(orden.getId()).setEstado("Terminada");
            modelo.eliminarOrden(orden.getId());
            actualizarTablaOrdenes();
        }
    }

}
