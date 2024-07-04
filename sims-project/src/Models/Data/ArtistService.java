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
        //loadArtistsFromXML();
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void updateArtist(Artist artist, Artist updatedArtist) {
        artists.set(artists.indexOf(artist), updatedArtist);
    }

    public void deleteArtist(Artist artist) {
        artists.remove(artist);
    }

    public Artist getArtistById(String id) {
        for (Artist artist : artists) {
            if (artist.getId().equals(id)) {
                return artist;
            }
        }
        return null;
    }

    public ArrayList<SingleArtist> getSingleArtists(){
        ArrayList<SingleArtist> singleArtists = new ArrayList<>();
        for (Artist a : artists) {
            if(a.getTypeOfArtist() == TypeOfArtist.SINGLE_ARTIST){
                singleArtists.add((SingleArtist) a);
            }
        }
        return singleArtists;
    }

//    public ArrayList<Artist> getBands(){
//        ArrayList<Artist> bands = new ArrayList<>();
//        for (Artist a : artists) {
//            if(a.getTypeOfArtist() == TypeOfArtist.BAND){
//                bands.add(a);
//            }
//        }
//        return bands;
//    }

    public ArrayList<Bend> getBands(){
        ArrayList<Bend> bands = new ArrayList<>();
        for (Artist a : artists) {
            if(a.getTypeOfArtist() == TypeOfArtist.BAND){
                Bend b = (Bend)a;
                bands.add(b);
            }
        }
        return bands;
    }

    public String[] getBandStrings(){
        String[] bandStrings = new String[artists.size()];
        int i = 0;
        for(Bend bend : getBands()){
            //treba mi i za single artiste i za bendove
            bandStrings[i] = bend.getId()+"," + bend.getName();
            i++;
        }
        return bandStrings;
    }
    public String[] getSingleArtistsStrings(){
        String[] singleArtistStrings = new String[artists.size()];
        int i = 0;
        for(SingleArtist singleArtist : getSingleArtists()){
            //treba mi i za single artiste i za bendove
            singleArtistStrings[i] = singleArtist.getId()+"," + singleArtist.getName();
            i++;
        }
        return singleArtistStrings;
    }



    public String getFreeID() {
        int maxId = 0;
        for (Artist artist : artists) {
            try {
                int id = Integer.parseInt(artist.getId().substring(2));
                if (id > maxId) {
                    maxId = id;
                }
            } catch (NumberFormatException e) {
                // Ignore invalid IDs
            }
        }
        return "AR" + String.format("%03d", maxId + 1);
    }

}
