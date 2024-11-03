package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionOrdenes extends JFrame {

    private JLabel orderIdLabel;
    private JTextField customerNameField;
    private JLabel totalLabel;
    private JTable itemsTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> menuComboBox;
    private JButton addItemButton;
    private JButton cancelButton;
    private JButton finishButton;

    public GestionOrdenes(String orderId) {
        // Configuración básica de la ventana
        setTitle("Gestión de Órdenes");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel superior para ID del pedido, nombre del cliente y total
        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        orderIdLabel = new JLabel("ID del Pedido: " + orderId);
        totalLabel = new JLabel("Total a pagar: $0.00", SwingConstants.RIGHT);

        JPanel orderInfoPanel = new JPanel(new BorderLayout());
        orderInfoPanel.add(orderIdLabel, BorderLayout.WEST);
        orderInfoPanel.add(totalLabel, BorderLayout.EAST);

        // Panel para ingresar el nombre del cliente
        JPanel customerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerPanel.add(new JLabel("Cliente:"));
        customerNameField = new JTextField(20);  // Campo de texto para ingresar el nombre del cliente
        customerPanel.add(customerNameField);

        topPanel.add(orderInfoPanel);
        topPanel.add(customerPanel);

        // Panel de la tabla de items
        tableModel = new DefaultTableModel(new Object[]{"ID", "Item", "Precio/u", "Total", "Acción"}, 0);
        itemsTable = new JTable(tableModel);
        itemsTable.getColumn("Acción").setCellRenderer(new ButtonRenderer());
        itemsTable.getColumn("Acción").setCellEditor(new ButtonEditor(new JCheckBox()));
        JScrollPane tableScrollPane = new JScrollPane(itemsTable);

        // Agregar un ejemplo de items a la tabla
        addItemToTable("01", "Chaufa de Pollo", 15.00);
        addItemToTable("02", "Chaufa de Carne", 15.00);
        addItemToTable("03", "Chaufa de Mariscos", 15.00);
        updateTotal();

        // Panel inferior para añadir ítems y botones de acción
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));

        // Panel para añadir ítems
        JPanel addItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addItemPanel.add(new JLabel("Añadir Item:"));

        // ComboBox para seleccionar ítems del menú
        String[] menuItems = {"Chaufa de Pollo", "Chaufa de Carne", "Chaufa de Mariscos", "Lomo Saltado", "Ají de Gallina"};
        menuComboBox = new JComboBox<>(menuItems);
        addItemPanel.add(menuComboBox);

        addItemButton = new JButton("+");
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para añadir un nuevo item seleccionado del ComboBox
                String itemName = (String) menuComboBox.getSelectedItem();
                if (itemName != null) {
                    addItemToTable(String.valueOf(tableModel.getRowCount() + 1), itemName, 15.00); // Ejemplo de precio
                    updateTotal();
                }
            }
        });
        addItemPanel.add(addItemButton);

        // Panel para los botones de Cancelar y Terminar
        JPanel actionButtonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cancelar la orden
                JOptionPane.showMessageDialog(null, "Orden cancelada");
                dispose();
            }
        });
        actionButtonsPanel.add(cancelButton);

        finishButton = new JButton("Terminar");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para terminar la orden, guardando el nombre del cliente
                String customerName = customerNameField.getText().trim();
                if (customerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Orden terminada para el cliente: " + customerName);
                    dispose();
                }
            }
        });
        actionButtonsPanel.add(finishButton);

        bottomPanel.add(addItemPanel, BorderLayout.WEST);
        bottomPanel.add(actionButtonsPanel, BorderLayout.EAST);

        // Agregar componentes al panel principal
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Agregar el panel principal a la ventana
        add(mainPanel);
    }

    private void addItemToTable(String id, String item, double precio) {
        double total = precio;
        tableModel.addRow(new Object[]{id, item, precio, total, "X"});
    }

    private void updateTotal() {
        double total = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            total += (double) tableModel.getValueAt(i, 3);
        }
        totalLabel.setText("Total a pagar: $" + String.format("%.2f", total));
    }
}

// Clases adicionales para renderizar el botón "X" en la tabla

class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
    public ButtonRenderer() {
        setText("X");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    private JButton button;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton("X");
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, button);
                int row = table.getSelectedRow();
                ((DefaultTableModel) table.getModel()).removeRow(row);
                SwingUtilities.getWindowAncestor(button).repaint();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }
}
