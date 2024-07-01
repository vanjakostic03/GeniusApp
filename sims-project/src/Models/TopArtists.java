package Models;

import java.util.Date;
import java.util.List;

public class TopArtists extends TopList {
    private List<Artist> artists;

    public TopArtists() {
        super();
    }

    public TopArtists(String id, String description, String title, Date year, List<Artist> artists) {
        super(id, description, title, year);
        this.artists = artists;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
