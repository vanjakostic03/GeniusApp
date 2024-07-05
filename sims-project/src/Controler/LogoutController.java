package Controler;

import Models.Data.AccountService;

import javax.swing.*;
public class LogoutController {

    private AccountService accountService; // Prilagodite prema vašoj implementaciji

    public LogoutController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void logout() {
        // Implementirajte logiku odjavljivanja
        // Na primer, brisanje trenutne sesije ili vraćanje na ekran za prijavljivanje

        JOptionPane.showMessageDialog(null, "Logged out successfully.");
    }
    public void setVisible(boolean b) {
    }
}
