
import Models.Data.AccountService;
import Models.Data.ArtistService;
import Models.Data.CommentService;
import Models.Data.PublishedWorkService;
import Models.PublishedWork;
import View.Moderator.ModeratorFrame;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Main.java
public class Main {
    public static void main(String[] args) {
//        AccountService service = new AccountService();
//        RegisterView registerView = new RegisterView();
//        RegisterController registerController = new RegisterController(registerView, service);
        PublishedWorkService pwService = new PublishedWorkService();
        for(PublishedWork pw:pwService.getPublishedWorks()){
            System.out.println(pw.getId()+"\n");
        }
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
        AccountService accountService = new AccountService();
        ArtistService artistService = new ArtistService();
        //PublishedWorkService pwService2 = new PublishedWorkService();
        CommentService commentService = new CommentService();
        ModeratorFrame mf = new ModeratorFrame("nesto",pwService,artistService,commentService);

    }
}
