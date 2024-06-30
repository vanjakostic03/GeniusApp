package Models;

import java.util.ArrayList;

public class Genre {
    private String id;
    private String name;
    private ArrayList<String> subgenres;

    public Genre(String id, String name) {
        this.id = id;
        this.name = name;
        this.subgenres = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(ArrayList<String> subgenres) {
        this.subgenres = subgenres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSubgenre(String subgenre) {
        this.subgenres.add(subgenre);
    }

    public void removeSubgenre(String subgenre) {
        this.subgenres.remove(subgenre);
    }
}
