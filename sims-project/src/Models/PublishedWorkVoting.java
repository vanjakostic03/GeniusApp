package Models;

import java.time.LocalDateTime;

public class PublishedWorkVoting {
    private String publishedWorkId;
    private String voterId;
    private LocalDateTime votingDate;

    public PublishedWorkVoting(String publishedWorkId, String voterId) {
        this.publishedWorkId = publishedWorkId;
        this.voterId = voterId;
        this.votingDate = LocalDateTime.now();
    }
    public String getPublishedWorkId() {
        return publishedWorkId;
    }
    public void setPublishedWorkId(String publishedWorkId) {
        this.publishedWorkId = publishedWorkId;
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
