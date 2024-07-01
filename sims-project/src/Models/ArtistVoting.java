package Models;

import java.time.LocalDateTime;

public class ArtistVoting {
    private String artistId;
    private String voterId;
    private LocalDateTime votingDate;

    public ArtistVoting(String artistId, String voterId) {
        this.artistId = artistId;
        this.voterId = voterId;
        this.votingDate = LocalDateTime.now();
    }
    public String getArtistId() {
        return artistId;
    }
    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
    public String getVoterId() {
        return voterId;
    }
    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }
    public LocalDateTime getVotingDate() {
        return votingDate;
    }
    public void setVotingDate(LocalDateTime votingDate) {
        this.votingDate = votingDate;
    }

}
