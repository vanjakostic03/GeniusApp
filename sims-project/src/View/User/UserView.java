package View.User;

import javax.swing.*;

public class UserView extends JFrame {
    private JLabel welcomeLabel;

    public UserView(String username) {
        setTitle("User Dashboard");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        welcomeLabel = new JLabel("Welcome, " + username + "!");
        add(welcomeLabel);
    }
}