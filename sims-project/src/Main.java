import Controler.LoginController;
import Models.Data.AccountService;
import Models.Data.ArtistService;
import Models.Data.CommentService;
import Models.Data.PublishedWorkService;
import Models.PublishedWork;
import View.Moderator.ModeratorFrame;
import View.User.LoginView;
import View.User.UserFrame;

public class Main {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        ArtistService artistService = new ArtistService();
        PublishedWorkService pwService = new PublishedWorkService();
        CommentService commentService = new CommentService();

        LoginView view=new LoginView();
        LoginController loginController=new LoginController(accountService, view,pwService,artistService,commentService,null);
        UserFrame mf = new UserFrame("nesto",pwService,artistService,commentService,accountService,loginController,null);



    }
}
