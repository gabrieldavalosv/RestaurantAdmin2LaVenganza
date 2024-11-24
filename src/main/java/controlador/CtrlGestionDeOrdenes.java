package controlador;

import modelo.OrdenArreglo;
import modelo.Orden;
import modelo.Menu;


import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.personal.Administrador;
import vista.GestionDeOrden;
import vista.GestionDeOrdenes;
import vista.PanelPrincipal;

/**
 * @author Davi
 */

public class CtrlGestionDeOrdenes {
    GestionDeOrdenes vista;
    OrdenArreglo modelo;
    Administrador administrador;

    private Menu menu;

    public CtrlGestionDeOrdenes(OrdenArreglo modelo, GestionDeOrdenes vista, Administrador administrador) {
        this.vista = vista;
        this.modelo = modelo;
        this.administrador = administrador;

        vista.labelRol.setText("Rol: " + administrador.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + administrador.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + administrador.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        this.actualizarTablaOrdenes();

        vista.buttonVolverPanel.addActionListener(e -> this.irPanelPrincipal());
        vista.buttonAgregarOrden.addActionListener(e -> this.eventoAgregarOrden());
        vista.buttonTerminarOrden.addActionListener(e -> this.eventoTerminarOrden());

        this.vista.setVisible(true);
    }

    private void irPanelPrincipal() {
        var vistaPanel = new PanelPrincipal();
        var ctrlPanel = new CtrlPanelPrincipal(administrador, vistaPanel);

        vista.dispose();
    }

    private void irGestionOrden(Orden orden) {
        var vistaOrden = new GestionDeOrden();
        var ctrlOrden = new CtrlGestionDeOrden(orden, vistaOrden, administrador);

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
        Orden orden = modelo.getOrdenes()[filaSeleccionada];

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione una fila de la tabla.");
        } else {
            modelo.buscarOrden(orden.getId()).setEstado("Terminada");
            modelo.eliminarOrden(orden.getId());
            actualizarTablaOrdenes();
        }
    }

}
