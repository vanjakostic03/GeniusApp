package Controler;

import Models.Artist;
import Models.Data.ArtistService;
import Models.Data.PublishedWorkService;
import Models.Genre;
import Models.SingleArtist;
import Models.Song;
import View.Moderator.SongForm;
import View.Moderator.SongPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SongController {
    private SongForm songForm; //za dodavanje
    private SongPanel songPanel; //za brisanje i azuriranje
    private PublishedWorkService publishedWorkService;
    private ArtistService artistService;

    public SongController(SongForm songForm, SongPanel songPanel, PublishedWorkService publishedWorkService, ArtistService artistService) {
        this.songForm = songForm;
        this.publishedWorkService = publishedWorkService;
        this.artistService = artistService;
        this.songPanel = songPanel;

        if(songForm!=null){

        this.songForm.addSubmitListener(new SubmitListener());
        }
        //this.songPanel.addDeleteListener(new DeleteListener());
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
            SingleArtist composer = (SingleArtist) artistService.findArtistById(tokens[0]);
            tokens = lyricistString.split(",");
            SingleArtist lyricist = (SingleArtist) artistService.findArtistById(tokens[0]);

            ArrayList<Genre> genres = new ArrayList<>();
            ArrayList<Artist> artists = new ArrayList<>();

            for (int i = 0; i < artistString.length; i++) {
                String[] artistTokens = artistString[i].split(",");
                artists.add(artistService.findArtistById(artistTokens[0]));
            }

            String id = publishedWorkService.getFreeID();
            Song song = new Song(id, title, cover, lyrics, description, composer, lyricist, genres, artists);
            if (songForm.getAlbumFrame() != null) {
                songForm.getAlbumFrame().addSong(song.getId() + "," + song.getTitle());
            }

            song.setComposer(composer);
            song.setLyricist(lyricist);
            song.setGenres(genres);
            song.setArtists(artists);
            publishedWorkService.addPublishedWork(song);
            publishedWorkService.savePublishedWorksToXML();
        }

    }

    public void deleteSong() {
        Song song = songPanel.getSong();
        publishedWorkService.deletePublishedWork(song);
        publishedWorkService.savePublishedWorksToXML();

    }

}