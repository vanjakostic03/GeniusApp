
import GUI.AdminFrame;
import GUI.ModeratorFrame;
import Controler.RegisterController;
import Models.Account;
import View.RegisterView;
import Serialization.Serialization;
import util.Setup;

import java.io.IOException;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Main.java
public class Main {
    public static void main(String[] args) {
        //Account model = new Account();
        //RegisterView registerView = new RegisterView();
        // registerController = new RegisterController(registerView, model);

        //registerView.setVisible(true);

        // For login
        //LoginView loginView = new LoginView();
        //LoginController loginController = new LoginController(model, loginView);
        //loginView.setVisible(true);
      
      //----------------------------VANJIN MAIN------------------------
//      Setup.initializeUsers();
//        Setup.initializeArtists();
//        Setup.initializePublishedWorks();
//        Serialization serialization = new Serialization();
//        serialization.load();
        //treba pozvati prozor za nereg.korisnika
        ModeratorFrame mf = new ModeratorFrame("nesto");

    }
}
