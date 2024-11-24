package controlador;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.personal.Administrador;
import modelo.personal.Cajero;
import vista.GestionDeCajeros;
import vista.PanelPrincipal;

public class CtrlGestionDeCajeros {
    private GestionDeCajeros vista;
    private Administrador administrador;

    public CtrlGestionDeCajeros(GestionDeCajeros vista, Administrador administrador) {
        this.vista = vista;
        this.administrador = administrador;

        // Inicialización de datos en la vista
        vista.labelRol.setText("Rol: " + administrador.getRol());
        vista.labelNombreUsuario.setText("Usuario: " + administrador.getNombre());
        vista.labelIdUsuario.setText("ID Usuario: " + administrador.getId());
        vista.labelFecha.setText("Fecha: " + LocalDate.now());

        // Inicialización de eventos
        inicializarEventos();

        // Mostrar la tabla con los cajeros existentes
        actualizarTabla();

        this.vista.setVisible(true);
    }

    private void inicializarEventos() {
        vista.buttonVolverPanel.addActionListener(e -> this.irPanelPrincipal());
        vista.buttonAgregarCajero.addActionListener(e -> this.agregarCajero());
        vista.buttonEliminarCajero.addActionListener(e -> this.eliminarCajero());
    }

    private void agregarCajero() {
        try {
            String nombre = vista.fieldCajero.getText().trim();
            if (nombre.isEmpty()) {
                throw new IllegalArgumentException("El campo de nombre no puede estar vacío.");
            }

            // Generar un ID único basado en la cantidad de cajeros actuales
            String id = String.valueOf(administrador.getCajeroArreglo().getIndex() + 1);
            String ruc = "RUC" + id; // Generar un RUC ficticio

            // Crear y añadir el cajero
            administrador.agregarCajero(new Cajero(id, nombre, "1234", ruc));
            actualizarTabla();

            // Limpiar el campo de entrada
            vista.fieldCajero.setText("");

            JOptionPane.showMessageDialog(vista, "Cajero agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(vista, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Ocurrió un error al agregar el cajero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarCajero() {
        int selectedRow = vista.tablaCajeros.getSelectedRow();
        if (selectedRow >= 0) {
            String id = (String) vista.tablaCajeros.getValueAt(selectedRow, 0);

            // Confirmar la eliminación
            int confirm = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar este cajero?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                administrador.eliminarCajero(id);
                actualizarTabla();
                JOptionPane.showMessageDialog(vista, "Cajero eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione un cajero para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.tablaCajeros.getModel();
        model.setRowCount(0); // Limpiar tabla

        for (Cajero cajero : administrador.getCajeroArreglo().getCajeros()) {
            if (cajero != null) {
                model.addRow(new Object[]{cajero.getId(), cajero.getNombre(), cajero.getRUC()});
            }
        }
    }

    private void irPanelPrincipal() {
        var vistaPanel = new PanelPrincipal();
        new CtrlPanelPrincipal(administrador, vistaPanel);
        vista.dispose();
    }
}






