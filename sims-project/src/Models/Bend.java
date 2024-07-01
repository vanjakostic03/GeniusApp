package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bend extends Artist{
    private String name;
    private String description;
    private LocalDate dateOfEstablishment;
    ArrayList<Membership> memberships;

    public Bend(String id, String name, String description, LocalDate dateOfEstablishment) {
        super(id);
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
