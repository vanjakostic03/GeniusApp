package Models;


import java.time.LocalDate;

public class Song extends PublishedWork{
    private String lyricistId;
    private String composerId;
    private String lyrics;
    private String description;
    private LocalDate releaseDate;
    private int views;

    public Song(String lyricistId, String composerId, String lyrics, String description){
        releaseDate  = LocalDate.now();
        this.lyricistId = lyricistId;
        this.composerId = composerId;
        this.lyrics = lyrics;
        this.description = description;
        this.views = 0;
    }

    public String getLyricistId() {
        return lyricistId;
    }

    public void setLyricistId(String lyricistId) {
        this.lyricistId = lyricistId;
    }

    public String getComposerId() {
        return composerId;
    }

    public void setComposerId(String composerId) {
        this.composerId = composerId;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void addView(){
        this.views++;
    }

}
