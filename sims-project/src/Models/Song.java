package Models;


import Enums.TypeOfWork;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.Date;

@XStreamAlias("song")
public class Song extends PublishedWork{
    private SingleArtist lyricist;
    private SingleArtist composer;
    private String lyrics;
    private int views;

    public Song() {}
    public Song(String id, String title, String cover, String lyrics, String description, SingleArtist composer, SingleArtist lyricist, ArrayList<Genre>genres,ArrayList<Artist> artists) {
        super(id,title,cover,artists, TypeOfWork.SONG,genres,description);

        this.lyricist = lyricist;
        this.composer = composer;
        this.lyrics = lyrics;
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
