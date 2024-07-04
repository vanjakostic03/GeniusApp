package Controler;

import Models.Album;
import Models.Data.PublishedWorkService;
import Models.PublishedWork;
import View.Moderator.AlbumsPanelModerator;
import View.Moderator.SongsPanelModerator;

public class PublishedWorkController {
    private AlbumsPanelModerator albumsPanelModerator;
    private SongsPanelModerator songsPanelModerator;
    private PublishedWorkService publishedWorkService;

    public PublishedWorkController(AlbumsPanelModerator albumsPanelModerator,
                                   SongsPanelModerator songsPanelModerator,
                                   PublishedWorkService publishedWorkService) {
        this.albumsPanelModerator = albumsPanelModerator;
        this.songsPanelModerator = songsPanelModerator;
        this.publishedWorkService = publishedWorkService;

        if(songsPanelModerator == null){

            loadAndDisplayAlbums();
        }else{

            loadAndDisplaySongs();
        }
    }

    private void loadAndDisplayAlbums() {
            albumsPanelModerator.setAlbums(publishedWorkService.getAlbums());
//        for(PublishedWork album : publishedWorkService.getAlbums()){
//            System.out.println("Added album: " + album);
//        }
    }

    private void loadAndDisplaySongs() {
        for(PublishedWork song : publishedWorkService.getSongs()){
            //songsPanelModerator.addSong((Song) song);
            System.out.println("Added song: " + song);
        }
    }



}
