package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Enums.Role;
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
                // Prikazi poruku o uspesnoj prijavi
                JOptionPane.showMessageDialog(view, "Login successful!");

                // Proveri tip korisnika
                Role userType = account.getPerson().getRole();
                switch (userType) {
                    case Role.REGISTERED_USER:
                        // Logika za korisnika
                        System.out.println("User logged in.");
                        break;
                    case Role.MODERATOR:
                        // Logika za moderatora
                        System.out.println("Moderator logged in.");
                        break;
                    case Role.ADMIN:
                        // Logika za administratora
                        System.out.println("Admin logged in.");
                        break;
                    default:
                        // Default handler, ako je tip nepoznat
                        System.out.println("Unknown user type.");
                        break;
                }
                view.dispose();
            } else {
                // Prikazi poruku o neuspesnoj prijavi
                JOptionPane.showMessageDialog(view, "Invalid username or password!");
            }
        }
    }
}
