package Controler;

import Enums.Role;
import Models.Data.AccountService;
import Models.Account;
import Models.Data.ArtistService;
import Models.Data.CommentService;
import Models.Data.PublishedWorkService;
import View.User.LoginView;
import View.User.UserFrame; // Pretpostavljamo da imate UserFrame ili odgovarajući prikaz za korisnika

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private AccountService accountService;
    private PublishedWorkService publishedWorkService;
    private ArtistService artistService;
    private CommentService commentService;
    private LoginView view;
    private Account registredUser;

    private UserFrame userFrame;

    public LoginController(AccountService accountService, LoginView view, PublishedWorkService publishedWorkService, ArtistService artistService, CommentService commentService,Account registedUser) {
        this.publishedWorkService = publishedWorkService;
        this.artistService = artistService;
        this.commentService = commentService;
        this.accountService = accountService;
        this.registredUser=registedUser;
        this.view = view;

        view.addLoginListener(new LoginListener());
    }

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
                    case REGISTERED_USER:
                        // Prikazi ili otvori panel za registrovanog korisnika
                        showRegisteredUserPanel(account);
                        break;
                    case MODERATOR:
                        // Prikazi ili otvori panel za moderatora
                        showModeratorPanel(account);
                        break;
                    case ADMIN:
                        // Prikazi ili otvori panel za administratora
                        showAdminPanel(account);
                        break;
                    default:
                        // Default handler, ako je tip nepoznat
                        JOptionPane.showMessageDialog(view, "Unknown user type.");
                        break;
                }

                view.dispose();
            } else {
                // Prikazi poruku o neuspesnoj prijavi
                JOptionPane.showMessageDialog(view, "Invalid username or password!");
            }
        }

        private void showRegisteredUserPanel(Account account) {

            SwingUtilities.invokeLater(() -> {
                registredUser=account;
                System.out.println(registredUser);
                if (userFrame != null) {
                    userFrame.dispose(); // Zatvori trenutni UserFrame ako postoji
                }
                userFrame = new UserFrame(account.getPerson().getName(), publishedWorkService, artistService, commentService, accountService, LoginController.this,registredUser); // Prosleđujemo LoginController
                userFrame.setVisible(true);
            });
        }

        private void showModeratorPanel(Account account) {
            JOptionPane.showMessageDialog(view, "Moderator logged in."); // Primer poruke
        }

        private void showAdminPanel(Account account) {
            JOptionPane.showMessageDialog(view, "Admin logged in."); // Primer poruke
        }
    }


}
