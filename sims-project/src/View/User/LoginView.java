package View.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create main panel with blue background and rounded corners
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(32, 38, 61));
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Add components to the panel
        panel.add(createLabel("Username:"), gbc);

        usernameField = createTextField();
        gbc.gridx = 1;
        gbc.gridwidth = 2; // Širina polja za unos
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Vraćamo na jednu kolonu za sledeće komponente
        panel.add(createLabel("Password:"), gbc);

        passwordField = createPasswordField();
        gbc.gridx = 1;
        gbc.gridwidth = 2; // Širina polja za unos
        panel.add(passwordField, gbc);

        loginButton = createButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3; // Širina dugmeta
        panel.add(loginButton, gbc);

        // Add the panel to the frame
        add(panel);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
        textField.setPreferredSize(new Dimension(200, 30)); // Širina polja za unos
        return textField;
    }

    private JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
        passwordField.setPreferredSize(new Dimension(200, 30)); // Širina polja za unos
        return passwordField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(32, 30, 50));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return button;
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    // Test metoda za prikaz LoginView prozora
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
}
