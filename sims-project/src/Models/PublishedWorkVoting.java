package Models;

import java.time.LocalDateTime;

public class PublishedWorkVoting {
    private String id;
    private PublishedWork publishedWork;
    private Person voter;
    private LocalDateTime votingDate;

    public PublishedWorkVoting(String id, PublishedWork publishedWork, Person voter, LocalDateTime votingDate) {
        this.id = id;
        this.publishedWork = publishedWork;
        this.voter = voter;
        this.votingDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PublishedWork getPublishedWork() {
        return publishedWork;
    }

    public void setPublishedWork(PublishedWork publishedWork) {
        this.publishedWork = publishedWork;
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
