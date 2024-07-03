import GUI.ModeratorFrame;
import Serialization.Serialization;
import util.Setup;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Setup.initializeUsers();
//        Setup.initializeArtists();
//        Setup.initializePublishedWorks();
//        Serialization serialization = new Serialization();
//        serialization.load();
        //treba pozvati prozor za nereg.korisnika
        ModeratorFrame mf = new ModeratorFrame("nesto");
    }
}