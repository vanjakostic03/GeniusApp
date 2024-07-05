package Models;

import Enums.TypeOfArtist;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.time.LocalDate;
import java.util.ArrayList;

@XStreamAlias("bend")
public class Bend extends Artist{
    private String name;
    private String description;
    private LocalDate dateOfEstablishment;
    private String picture;
    ArrayList<Membership> memberships;

    public Bend(String id,RecordLabel recordLabel, String name, String description, LocalDate dateOfEstablishment) {
        super(id, recordLabel, TypeOfArtist.BAND);
        this.name = name;
        this.description = description;
        this.dateOfEstablishment = dateOfEstablishment;
        this.memberships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(LocalDate dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public ArrayList<Membership> getMemberships() {
        return memberships;
    }

    public void addMembership(Membership membership) {
        this.memberships.add(membership);
    }
}
