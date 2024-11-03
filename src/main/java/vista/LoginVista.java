package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginVista extends JFrame {
    private JTextField nombreCampo;
    private JPasswordField contrasenaCampo;
    private JButton loginButton;
    private JLabel mensageLabel;
    private JCheckBox mostrarContrasenaCheckBox;

    public LoginVista() {
        //Inicialización
        setTitle("Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Panel para el formulario de login
        JPanel formPanel = new JPanel(new GridLayout(5, 1, 0, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Campo de usuario
        formPanel.add(new JLabel("Nombre de usuario"));
        nombreCampo = new JTextField();
        formPanel.add(nombreCampo);

        // Campo de contraseña
        formPanel.add(new JLabel("Contraseña"));
        contrasenaCampo = new JPasswordField();
        formPanel.add(contrasenaCampo);

        // Checkbox para mostrar/ocultar la contraseña
        mostrarContrasenaCheckBox = new JCheckBox("Mostrar contraseña");
        mostrarContrasenaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mostrarContrasenaCheckBox.isSelected()) {
                    contrasenaCampo.setEchoChar((char) 0); // Muestra la contraseña
                } else {
                    contrasenaCampo.setEchoChar('•'); // Oculta la contraseña
                }
            }
        });
        formPanel.add(mostrarContrasenaCheckBox);

        // Botón de iniciar sesión
        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Iniciar sesión");
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.WHITE);
        buttonPanel.add(loginButton);

        // Etiqueta para mensajes
        mensageLabel = new JLabel("", SwingConstants.CENTER);

        // Contenedor de la etiqueta de mensaje y el panel de botón
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        bottomPanel.add(mensageLabel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Agregar panel del formulario y panel inferior
        add(formPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public String getNombre() {
        return nombreCampo.getText();
    }

    public String getContrasena() {
        return new String(contrasenaCampo.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setMensaje(String message) {
        mensageLabel.setText(message);
    }
}
