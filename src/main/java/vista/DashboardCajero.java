package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardCajero extends JFrame {

    private JButton newOrderButton;
    private JButton manageOrdersButton;
    private JButton processPaymentButton;

    public DashboardCajero() {
        //Inicialización
        setTitle("Dashboard del Cajero");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Título
        JLabel titleLabel = new JLabel("Bienvenido Cajero", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Botón para crear nueva orden
        newOrderButton = new JButton("Crear Nueva Orden");
        newOrderButton.setBackground(Color.DARK_GRAY);
        newOrderButton.setForeground(Color.WHITE);
        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abrir creación de nueva orden");
            }
        });
        buttonPanel.add(newOrderButton);

        // Botón para gestionar órdenes
        manageOrdersButton = new JButton("Gestionar Órdenes");
        manageOrdersButton.setBackground(Color.DARK_GRAY);
        manageOrdersButton.setForeground(Color.WHITE);
        manageOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abrir gestión de órdenes");
            }
        });
        buttonPanel.add(manageOrdersButton);

        // Botón para procesar pagos
        processPaymentButton = new JButton("Procesar Pago");
        processPaymentButton.setBackground(Color.DARK_GRAY);
        processPaymentButton.setForeground(Color.WHITE);
        processPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abrir procesamiento de pago");
            }
        });
        buttonPanel.add(processPaymentButton);

        // Agregar el panel de botones al centro de la ventana
        add(buttonPanel, BorderLayout.CENTER);
    }
}
