package Models;

import java.util.Date;
import java.util.List;

public class PlayList {
    public PlayList(String id, String title, String cover, Date creationDate, String description, boolean isPrivate) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        CreationDate = creationDate;
        this.description = description;
        this.isPrivate = isPrivate;
    }

    private String id;
    private String title;
    private String cover;
    private Date CreationDate;
    private String description;
    private boolean isPrivate;
    private List<Song> songs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
