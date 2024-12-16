package controlador;

import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

import modelo.Venta;
import modelo.VentaArreglo;
import modelo.personal.Administrador;
import modelo.personal.Trabajador;
import vista.GestionDeRegistroVentas;
import vista.PanelPrincipal;

public class CtrlGestionRegistroVentas {
    private GestionDeRegistroVentas vista;
    private VentaArreglo modelo;
    private Trabajador trabajador;

    public CtrlGestionRegistroVentas(VentaArreglo modelo, GestionDeRegistroVentas vista, Trabajador trabajador) {
        this.vista = vista;
        this.modelo = modelo;
        this.trabajador = trabajador;

        vista.labelRol.setText("Rol: " + trabajador.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + trabajador.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + trabajador.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        inicializarEventos();

        actualizarTabla();

        this.vista.setVisible(true);
    }

    private void inicializarEventos() {
        vista.buttonVolverPanel.addActionListener(e -> this.irPanelPrincipal());
    }

    private void actualizarTabla() {
        var tablaRegistro = (DefaultTableModel) vista.tablaVentas.getModel();

        tablaRegistro.setRowCount(0);

        for (Venta v : modelo.getVentas()) {
            if (v != null) {
                tablaRegistro.addRow(new Object[]{v.getId(), v.getFecha(), v.getPago().getMonto(), v.getPago().getMetodo()});
            }
        }
    }

    private void irPanelPrincipal() {
        var vistaPanel = new PanelPrincipal();
        var ctrlPanelPrincipal = new CtrlPanelPrincipal(trabajador, vistaPanel);
        
        vista.dispose();
    }
}
