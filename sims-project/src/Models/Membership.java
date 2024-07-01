package Models;

import java.time.LocalDate;

public class Membership {
    private LocalDate startDate;
    private LocalDate endDate;
    private Bend bend;
    private SingleArtist artist;

    public Membership(LocalDate startDate, LocalDate endDate, Bend bend, SingleArtist artist) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.bend = bend;
        this.artist = artist;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Bend getBend() {
        return bend;
    }

    public void setBend(Bend bend) {
        this.bend = bend;
    }

    public SingleArtist getArtist() {
        return artist;
    }

    public void setArtist(SingleArtist artist) {
        this.artist = artist;
    }
}
