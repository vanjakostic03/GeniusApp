package Models.Data;

import Enums.TypeOfArtist;
import Models.Artist;
import Models.Bend;
import Models.SingleArtist;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArtistService {
    private ArrayList<Artist> artists;

    public ArtistService() {
        this.artists = new ArrayList<>();
        loadArtistsFromXML();
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public ArrayList<SingleArtist> getSingleArtists() {
        ArrayList<SingleArtist> singleArtists = new ArrayList<>();
        for (Artist a : artists) {
            if (a.getTypeOfArtist() == TypeOfArtist.SINGLE_ARTIST) {
                singleArtists.add((SingleArtist) a);
            }
        }
        return singleArtists;
    }

    public ArrayList<Bend> getBands() {
        ArrayList<Bend> bands = new ArrayList<>();
        for (Artist a : artists) {
            if (a.getTypeOfArtist() == TypeOfArtist.BAND) {
                Bend b = (Bend) a;
                bands.add(b);
            }
        }
        return bands;
    }

    public String[] getBandStrings() {
        String[] bandStrings = new String[getBands().size()];
        int i = 0;
        for (Bend bend : getBands()) {
            bandStrings[i] = bend.getId() + "," + bend.getName();
            i++;
        }
        return bandStrings;
    }

    public String[] getSingleArtistsStrings() {
        String[] singleArtistStrings = new String[getSingleArtists().size()];
        int i = 0;
        for (SingleArtist singleArtist : getSingleArtists()) {
            singleArtistStrings[i] = singleArtist.getId() + "," + singleArtist.getName();
            i++;
        }
        return singleArtistStrings;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
        saveArtistsToXML();
    }

    public Artist findArtistById(String id) {
        for (Artist artist : artists) {
            if (artist.getId().equals(id)) {
                return artist;
            }
        }
        return null;
    }

    public boolean artistExists(String id) {
        for (Artist artist : artists) {
            if (artist.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void saveArtistsToXML() {
        XStream xstream = new XStream();
        xstream.alias("artist", Artist.class);
        xstream.alias("singleArtist", SingleArtist.class);
        xstream.alias("bend", Bend.class);
        xstream.addPermission(AnyTypePermission.ANY); // Добавление разрешений

        try (FileWriter writer = new FileWriter("./Data/artists.xml")) {
            xstream.toXML(artists, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadArtistsFromXML() {
        XStream xstream = new XStream();
        xstream.alias("artist", Artist.class);
        xstream.alias("singleArtist", SingleArtist.class);
        xstream.alias("bend", Bend.class);
        xstream.addPermission(AnyTypePermission.ANY);

        try (FileReader reader = new FileReader("./Data/artists.xml")) {
            artists = (ArrayList<Artist>) xstream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFreeID() {
        int maxId = 0;
        for (Artist artist : artists) {
            try {
                int id = Integer.parseInt(artist.getId().substring(1));
                if (id > maxId) {
                    maxId = id;
                }
            } catch (NumberFormatException e) {
            }
        }
        return "A" + String.format("%03d", maxId + 1);
    }
}
