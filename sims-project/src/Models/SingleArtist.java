package Models;

import Enums.TypeOfArtist;

import java.util.ArrayList;

public class SingleArtist extends Artist{
    private String biography;
    private String picture;
    private String name;
    private ArrayList<Membership> memberships;

    public SingleArtist(String id, RecordLabel recordLabel, String biography, String picture, String name) {
        super(id,recordLabel,TypeOfArtist.SINGLE_ARTIST);
        this.biography = biography;
        this.picture = picture;
        this.name = name;
        this.memberships = new ArrayList<>();
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Membership> getMemberships() {
        return this.memberships;
    }

    public void addMembership(Membership membership) {
        this.memberships.add(membership);
    }
}
