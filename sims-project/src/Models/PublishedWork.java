package Models;

import Enums.TypeOfWork;

import java.util.ArrayList;

public abstract class PublishedWork {
    protected String id;
    protected String title;
    protected String cover;
    protected ArrayList<String> artists;
    protected TypeOfWork typeOfWork;
    protected ArrayList<String> genres;

    public PublishedWork() {}

    public PublishedWork(String id, String title, String cover, ArrayList<String> artists, TypeOfWork typeOfWork, ArrayList<String> genres) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.artists = artists;
        this.typeOfWork = typeOfWork;
        this.genres = genres;
    }
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

    public ArrayList<String> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<String> artists) {
        this.artists = artists;
    }

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void addGenre(String genre) {
        this.genres.add(genre);
    }

    public void removeGenre(String genre) {
        this.genres.remove(genre);
    }

    public void addArtist(String artist) {
        this.artists.add(artist);
    }
    public void removeArtist(String artist) {
        this.artists.remove(artist);
    }


}
