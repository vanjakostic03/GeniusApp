package Models;


import Enums.TypeOfWork;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;

@XStreamAlias("album")
public class Album extends PublishedWork{
    private ArrayList<Song> songs;

    @Override
    public void removeArtist(Artist artist) {
        super.removeArtist(artist);
    }

    @Override
    public void addArtist(Artist artist) {
        super.addArtist(artist);
    }

    @Override
    public void removeGenre(Genre genre) {
        super.removeGenre(genre);
    }

    @Override
    public void addGenre(Genre genre) {
        super.addGenre(genre);
    }

    @Override
    public void setGenres(ArrayList<Genre> genres) {
        super.setGenres(genres);
    }

    @Override
    public ArrayList<Genre> getGenres() {
        return super.getGenres();
    }

    @Override
    public void setTypeOfWork(TypeOfWork typeOfWork) {
        super.setTypeOfWork(typeOfWork);
    }

    @Override
    public TypeOfWork getTypeOfWork() {
        return super.getTypeOfWork();
    }

    @Override
    public void setArtists(ArrayList<Artist> artists) {
        super.setArtists(artists);
    }

    @Override
    public ArrayList<Artist> getArtists() {
        return super.getArtists();
    }

    @Override
    public void setCover(String cover) {
        super.setCover(cover);
    }

    @Override
    public String getCover() {
        return super.getCover();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public Album() {
        songs = new ArrayList<>();
    }

    public Album(String id,String title,String cover, String description,ArrayList<Genre> genres,ArrayList<Artist> artists,ArrayList<Song> songs) {
        super(id,title,cover,artists,TypeOfWork.ALBUM,genres,description);
        this.songs = songs;

    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }
}

