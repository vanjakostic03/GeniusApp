
import Controler.RegisterController;
import Models.Data.AccountService;
import View.Moderator.ModeratorFrame;
import View.User.RegisterView;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Main.java
public class Main {
    public static void main(String[] args) {
        AccountService service = new AccountService();
        RegisterView registerView = new RegisterView();
        RegisterController registerController = new RegisterController(registerView, service);

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
