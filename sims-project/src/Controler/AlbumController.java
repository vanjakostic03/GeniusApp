package Controler;

import Models.*;
import Models.Data.ArtistService;
import Models.Data.PublishedWorkService;
import View.Moderator.AlbumForm;
import View.Moderator.AlbumPanel;
import View.Moderator.SongForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AlbumController {
    private AlbumForm albumForm;
    private AlbumPanel albumPanel;
    private PublishedWorkService publishedWorkService;
    private ArtistService artistService;

    public AlbumController(AlbumForm albumForm,AlbumPanel albumPanel,PublishedWorkService publishedWorkService, ArtistService artistService) {
        this.albumForm = albumForm;
        this.albumPanel = albumPanel;
        this.publishedWorkService = publishedWorkService;
        this.artistService = artistService;

        if(albumForm!=null){
            this.albumForm.addSongListener(new SongListener());
            this.albumForm.addSubmitListener(new SubmitListener());
        }
    }

    class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String title = albumForm.getTitle();
            String cover = albumForm.getCoverURL();
            String description = albumForm.getDescription();
            String[] genresString = albumForm.getGenres();
            String[] artistString = albumForm.getArtists();
            String[] songsString = albumForm.getSongsStrings();

            ArrayList<Genre> genres = new ArrayList<>();
            ArrayList<Artist> artists = new ArrayList<>();
            ArrayList<Song> songs = new ArrayList<>();

            for(int i = 0; i < artistString.length; i++) {
                String[] artistTokens = artistString[i].split(",");
                artists.add(artistService.findArtistById(artistTokens[0]));
            }

            for(int i = 0; i < songsString.length; i++) {
                String[] songTokens = songsString[i].split(",");
                songs.add((Song)publishedWorkService.getPublishedWorkById(songTokens[0]));
            }


            String id = publishedWorkService.getFreeID();
            Album album = new Album(id,title,cover,description,genres,artists,songs);

            album.setGenres(genres);
            album.setArtists(artists);
            album.setSongs(songs);
            publishedWorkService.addPublishedWork(album);
            publishedWorkService.savePublishedWorksToXML();

        }
    }

    class SongListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            SongForm songForm = new SongForm(albumForm,artistService.getArtists());
            songForm.setVisible(true);
            SongController songController = new SongController(songForm,null,publishedWorkService,artistService);
        }
    }

    public void deleteAlbum(){
        ArrayList<PublishedWork> publishedWorks = publishedWorkService.getPublishedWorks();
        Album album = albumPanel.getAlbum();
        ArrayList<Song> songs = album.getSongs();
        for(Song song : songs){
            publishedWorkService.deletePublishedWorkById(song.getId());
        }

        publishedWorkService.deletePublishedWork(album);
        publishedWorkService.savePublishedWorksToXML();
    }
}
