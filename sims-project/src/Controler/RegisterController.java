package Controler;

import Models.Person;
import Enums.Role;
import Enums.Gender;
import View.LoginView;
import View.RegisterView;
import Models.Account;
import View.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RegisterController {
    private RegisterView view;
    private Account model;

    public RegisterController(RegisterView view, Account model) {
        this.view = view;
        this.model = model;

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

            if (!model.usernameExists(username)) {
                Account account = new Account(username, password);
                Person person = new Person(
                        model.getFreeID(),
                        firstName,
                        lastName,
                        Role.REGISTERED_USER,
                        address,
                        new Date(),
                        gender,
                        account
                );
                account.setPerson(person);
                model.addAccount(account);

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
            LoginController loginController = new LoginController(model,loginView);
            loginView.setVisible(true);
        }
    }


}
