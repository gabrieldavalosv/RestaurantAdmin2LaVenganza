package controlador;

import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

import modelo.Venta;
import modelo.VentaArreglo;
import modelo.personal.Administrador;
import vista.GestionDeRegistroVentas;
import vista.PanelPrincipal;

public class CtrlGestionRegistroVentas {
    private GestionDeRegistroVentas vista;
    private VentaArreglo modelo;
    private Administrador administrador;

    public CtrlGestionRegistroVentas(VentaArreglo modelo, GestionDeRegistroVentas vista, Administrador administrador) {
        this.vista = vista;
        this.modelo = modelo;
        this.administrador = administrador;

        vista.labelRol.setText("Rol: " + administrador.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + administrador.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + administrador.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        inicializarEventos();

        actualizarTabla();

        this.vista.setVisible(true);
    }

    private void inicializarEventos() {
        vista.buttonVolverPanel.addActionListener(e -> this.irPanelPrincipal());
    }

    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.tablaVentas.getModel();
        model.setRowCount(0);

        for (Venta venta : modelo.getVentas()) {
            if (venta != null) {
                model.addRow(new Object[]{
                        venta.getId(),
                        venta.getOrden().getCliente(),
                        venta.getEstado(),
                        venta.getOrden().calcularPrecioTotal(),
                        venta.getFecha()
                });
            }
        }
    }

    private void irPanelPrincipal() {
        var vistaPanel = new PanelPrincipal();
        new CtrlPanelPrincipal(administrador, vistaPanel);
        vista.dispose();
    }
}
