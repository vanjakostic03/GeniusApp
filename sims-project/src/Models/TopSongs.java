package Models;

import java.util.Date;
import java.util.List;

public class TopSongs extends TopList {
    private List<Song> songs;

    public TopSongs() {
        super();
    }

    public TopSongs(String id, String description, String title, Date year, List<Song> songs) {
        super(id, description, title, year);
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
