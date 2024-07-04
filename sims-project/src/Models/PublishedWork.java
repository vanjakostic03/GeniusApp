package Models;

import Enums.TypeOfWork;

import java.util.ArrayList;
import java.util.Date;

public abstract class PublishedWork {
    protected String id;
    protected String title;
    protected String cover;
    protected ArrayList<Artist> artists;
    protected TypeOfWork typeOfWork;
    protected ArrayList<Genre> genres;
    protected Date releaseDate;
    protected String description;

    public PublishedWork() {}

    public PublishedWork(String id, String title, String cover, ArrayList<Artist> artists, TypeOfWork typeOfWork, ArrayList<Genre> genres, String description) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.artists = artists;
        this.typeOfWork = typeOfWork;
        this.genres = genres;
        this.description = description;
        this.releaseDate = new Date();
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }
    public void removeArtist(Artist artist) {
        this.artists.remove(artist);
    }


}
