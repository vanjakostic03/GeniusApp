package Models.Data;

import Enums.TypeOfArtist;
import Models.Artist;
import Models.Bend;
import Models.SingleArtist;

import java.util.ArrayList;

public class ArtistService {
    private ArrayList<Artist> artists;
    public ArtistService() {
        this.artists = new ArrayList<Artist>();
    }

    public ArrayList<Artist> getArtists() {
        return artists;
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

}
