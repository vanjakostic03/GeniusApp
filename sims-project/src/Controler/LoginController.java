package Controler;


// LoginController.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.LoginView;
import Models.Account;

import javax.swing.*;

public class LoginController {
    private Account model;
    private LoginView view;

    public LoginController(Account model, LoginView view) {
        this.model = model;
        this.view = view;

        view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            Account account = model.findAccount(username, password);
            if (account != null) {
                JOptionPane.showMessageDialog(view, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(view, "Invalid username or password!");
            }
        }
    }
}
