package Controler;

import Models.Data.AccountService;
import Models.Person;
import Enums.Role;
import Enums.Gender;
import View.User.LoginView;
import View.User.RegisterView;
import Models.Account;
import View.User.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RegisterController {
    private RegisterView view;
    private AccountService accountService;

    public RegisterController(RegisterView view, AccountService accountService) {
        this.view = view;
        this.accountService = accountService;

        this.view.addRegisterListener(new RegisterListener());
        this.view.addLoginListener(new LoginListener());
    }

    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            String firstName = view.getFirstName();
            String lastName = view.getLastName();
            String address = view.getAddress();
            Gender gender = Gender.valueOf(view.getGender().toUpperCase());

            if (!accountService.usernameExists(username)) {
                Account account = new Account(username, password);
                Person person = new Person(
                        accountService.getFreeID(),
                        firstName,
                        lastName,
                        Role.REGISTERED_USER,
                        address,
                        new Date(),
                        gender
                );
                account.setPerson(person);
                accountService.addAccount(account);

                JOptionPane.showMessageDialog(view, "Registration Successful!");
                view.dispose();
                // Otvoriti novi prozor za korisnika
                UserView userView = new UserView(person.getName());
                userView.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view, "Username already exists!");
            }
        }
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            LoginView loginView = new LoginView();
            LoginController loginController = new LoginController(accountService,loginView);
            loginView.setVisible(true);
        }
    }


}
