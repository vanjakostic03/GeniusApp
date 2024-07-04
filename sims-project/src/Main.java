
import Controler.RegisterController;
import Controler.SongController;
import Models.Data.AccountService;
import Models.Data.ArtistService;
import Models.Data.CommentService;
import Models.Data.PublishedWorkService;
import Models.PublishedWork;
import View.Admin.AdminFrame;
import View.Moderator.ModeratorFrame;
import View.User.RegisterView;

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
//        AccountService accountService = new AccountService();
        ArtistService artistService = new ArtistService();
        CommentService commentService = new CommentService();

        ModeratorFrame mf = new ModeratorFrame("nesto",pwService,artistService,commentService);
       // AdminFrame af = new AdminFrame("f");
    }
}
