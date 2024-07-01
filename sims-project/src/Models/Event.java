package Models;

import java.util.Date;
import java.util.List;

public class Event {
    private Date date;
    private String id;
    private String place;
    private String description;
    private List<Artist> artists;

    public Event() {
    }

    public Event(Date date, String id, String place, String description, List<Artist> artists) {
        this.date = date;
        this.id = id;
        this.place = place;
        this.description = description;
        this.artists = artists;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
