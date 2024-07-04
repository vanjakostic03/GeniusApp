package Controler;

import Models.Artist;
import Models.Data.ArtistService;
import Models.Data.PublishedWorkService;
import Models.Genre;
import Models.SingleArtist;
import Models.Song;
import View.Moderator.SongForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SongController {
    private SongForm songForm;
    private PublishedWorkService publishedWorkService;
    private ArtistService artistService;

    public SongController(SongForm songForm, PublishedWorkService publishedWorkService, ArtistService artistService) {
        this.songForm = songForm;
        this.publishedWorkService = publishedWorkService;
        this.artistService = artistService;

        this.songForm.addSubmitListener(new SubmitListener());
    }

    class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String title = songForm.getTitle();
            String cover = songForm.getCoverURL();
            String lyrics = songForm.getLyrics();
            String description = songForm.getDescription();

            String composerString = songForm.getComposer();
            String lyricistString = songForm.getLyricist();
            String[] genresString = songForm.getGenres();
            String[] artistString = songForm.getArtists();

            String[] tokens = composerString.split(",");
            SingleArtist composer =(SingleArtist) artistService.findArtistById(tokens[0]);
            tokens = lyricistString.split(",");
            SingleArtist lyricist = (SingleArtist) artistService.findArtistById(tokens[0]);

            ArrayList<Genre> genres = new ArrayList<>();
            ArrayList<Artist> artists = new ArrayList<>();

//            for(int i = 0; i < artistString.length; i++) {
//                String[] artistTokens = artistString[i].split(",");
//                genres.add(artistService.findArtistById(tokens[0]));
//            }
            for(int i = 0; i < artistString.length; i++) {
                String[] artistTokens = artistString[i].split(",");
                artists.add(artistService.findArtistById(artistTokens[0]));
            }

            System.out.println(lyricistString);
            System.out.println(lyricist.getName());

            for(Artist a: artists){
                System.out.println(a.getId());
            }

            String id = publishedWorkService.getFreeID();
            Song song = new Song(id,title,cover,lyrics,description,composer,lyricist,genres,artists);
            song.setComposer(composer);
            song.setLyricist(lyricist);
            song.setGenres(genres);
            song.setArtists(artists);
            publishedWorkService.addPublishedWork(song);
            publishedWorkService.savePublishedWorksToXML();
        }

    }
}
