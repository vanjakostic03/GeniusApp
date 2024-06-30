package Models;

import java.util.ArrayList;

public class SingleArtist extends Artist{
    private String Biography;
    private String Picture;
    private String Name;
    private ArrayList<Membership> memberships;

    public SingleArtist(String id, String biography, String picture, String name) {
        super(id);
        this.Biography = biography;
        this.Picture = picture;
        this.Name = name;
        this.memberships = new ArrayList<>();
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        this.Biography = biography;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        this.Picture = picture;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<Membership> getMemberships() {
        return this.memberships;
    }

    public void addMembership(Membership membership) {
        this.memberships.add(membership);
    }
}
