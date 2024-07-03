package Controler;


// LoginController.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Data.AccountService;
import View.User.LoginView;
import Models.Account;

import javax.swing.*;

public class LoginController {
    private AccountService accountService;
    private LoginView view;

    public LoginController(AccountService accountService, LoginView view) {
        this.accountService = accountService;
        this.view = view;

        view.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            Account account = accountService.findAccount(username, password);
            if (account != null) {
                JOptionPane.showMessageDialog(view, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(view, "Invalid username or password!");
            }
        }
    }
}
