package Models;

import java.util.ArrayList;

public class Genre {
    private String id;
    private String name;
    private String cover;
    private ArrayList<Genre> subgenres;

    public Genre(String id, String name) {
        this.id = id;
        this.name = name;
        this.subgenres = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Genre> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(ArrayList<Genre> subgenres) {
        this.subgenres = subgenres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSubgenre(Genre subgenre) {
        this.subgenres.add(subgenre);
    }

    public void removeSubgenre(Genre subgenre) {
        this.subgenres.remove(subgenre);
    }
}
