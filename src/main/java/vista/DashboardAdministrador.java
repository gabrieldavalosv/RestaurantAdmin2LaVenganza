package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardAdministrador extends JFrame {

    private JButton manageCashiersButton;
    private JButton manageProductsButton;
    private JButton manageCombosButton;
    private JButton salesReportButton;

    public DashboardAdministrador() {
        //Inicialización
        setTitle("Dashboard del Administrador");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Título
        JLabel titleLabel = new JLabel("Bienvenido Administrador", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Botón para gestionar cajeros
        manageCashiersButton = new JButton("Gestionar Cajeros");
        manageCashiersButton.setBackground(Color.DARK_GRAY);
        manageCashiersButton.setForeground(Color.WHITE);
        manageCashiersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abrir gestión de cajeros");
            }
        });
        buttonPanel.add(manageCashiersButton);

        // Botón para gestionar productos del menú
        manageProductsButton = new JButton("Gestionar Productos del Menú");
        manageProductsButton.setBackground(Color.DARK_GRAY);
        manageProductsButton.setForeground(Color.WHITE);
        manageProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abrir gestión de productos");
            }
        });
        buttonPanel.add(manageProductsButton);

        // Botón para gestionar combos del menú
        manageCombosButton = new JButton("Gestionar Combos del Menú");
        manageCombosButton.setBackground(Color.DARK_GRAY);
        manageCombosButton.setForeground(Color.WHITE);
        manageCombosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abrir gestión de combos");
            }
        });
        buttonPanel.add(manageCombosButton);

        // Botón para generar reporte de ventas
        salesReportButton = new JButton("Generar Reporte de Ventas");
        salesReportButton.setBackground(Color.DARK_GRAY);
        salesReportButton.setForeground(Color.WHITE);
        salesReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Generar reporte de ventas");
            }
        });
        buttonPanel.add(salesReportButton);

        // Agregar el panel de botones al centro de la ventana
        add(buttonPanel, BorderLayout.CENTER);
    }
}