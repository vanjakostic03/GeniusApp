package Models;


import java.util.Date;

public class Song extends PublishedWork{
    private SingleArtist lyricist;
    private SingleArtist composer;
    private String lyrics;
    private String description;
    private Date releaseDate;
    private int views;

    public Song() {}
    public Song(SingleArtist lyricist, SingleArtist composer, String lyrics, String description){
        releaseDate  = new Date();
        this.lyricist = lyricist;
        this.composer = composer;
        this.lyrics = lyrics;
        this.description = description;
        this.views = 0;
    }

    public SingleArtist getLyricist() {
        return lyricist;
    }

    public void setLyricist(SingleArtist lyricist) {
        this.lyricist = lyricist;
    }

    public SingleArtist getComposer() {
        return composer;
    }

    public void setComposer(SingleArtist composer) {
        this.composer = composer;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
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
