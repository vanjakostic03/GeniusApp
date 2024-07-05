package Controler;

import Models.*;
import Models.Data.ArtistService;
import Models.Data.PublishedWorkService;
import View.Moderator.AlbumForm;
import View.Moderator.SongForm;
import View.User.ComentForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AlbumController {
    private AlbumForm albumForm;
    private ComentForm comentForm;
    private PublishedWorkService publishedWorkService;
    private ArtistService artistService;

    public AlbumController(AlbumForm albumForm,PublishedWorkService publishedWorkService, ArtistService artistService) {
        this.albumForm = albumForm;
        this.publishedWorkService = publishedWorkService;
        this.artistService = artistService;

    }

    public AlbumController(ComentForm comentForm, PublishedWorkService publishedWorkService, ArtistService artistService) {
        this.comentForm = comentForm;
        this.publishedWorkService = publishedWorkService;
        this.artistService = artistService;

    }

}