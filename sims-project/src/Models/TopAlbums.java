package Models;

import java.util.Date;
import java.util.List;

public class TopAlbums extends TopList {
    private List<Album> albums;

    public TopAlbums() {
        super();
    }

    public TopAlbums(String id, String description, String title, Date year, List<Album> albums) {
        super(id, description, title, year);
        this.albums = albums;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
