package Models;

import java.time.LocalDateTime;

public class ArtistVoting {
    private String id;
    private Artist artist;
    private Person voter;
    private LocalDateTime votingDate;

   public ArtistVoting(String id, Artist artist, Person voter) {
       this.id = id;
       this.artist = artist;
       this.voter = voter;
       this.votingDate = LocalDateTime.now();
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Person getVoter() {
        return voter;
    }

    public void setVoter(Person voter) {
        this.voter = voter;
    }

    public LocalDateTime getVotingDate() {
        return votingDate;
    }

    public void setVotingDate(LocalDateTime votingDate) {
        this.votingDate = votingDate;
    }
}
