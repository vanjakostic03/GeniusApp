import Controler.RegisterController;
import Models.Account;
import View.RegisterView;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Main.java
public class Main {
    public static void main(String[] args) {
        Account model = new Account();
        RegisterView registerView = new RegisterView();
        RegisterController registerController = new RegisterController(registerView, model);

        registerView.setVisible(true);

        // For login
        //LoginView loginView = new LoginView();
        //LoginController loginController = new LoginController(model, loginView);
        //loginView.setVisible(true);
    }
}
