package Controler;

import Models.Data.PublishedWorkService;
import View.Moderator.AlbumForm;

public class AlbumController {
    private AlbumForm albumForm;
    private PublishedWorkService publishedWorkService;

    public AlbumController(AlbumForm albumForm, PublishedWorkService publishedWorkService) {
        this.albumForm = albumForm;
        this.publishedWorkService = publishedWorkService;


    }
}
