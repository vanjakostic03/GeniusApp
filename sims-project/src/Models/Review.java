package Models;

import java.util.Date;

public class Review {
    private String id;
    private String description;
    private int grade;
    private boolean isApproved;
    private Date date;
    // da li moze ovako posto je kardinalitet 1
    private PublishWork publishWork;
    private Moderator moderator;

    public Review() {
    }

    public Review(String id, String description, int grade, boolean isApproved, Date date, PublishWork publishWork, Moderator moderator) {
        this.id = id;
        this.description = description;
        this.grade = grade;
        this.isApproved = isApproved;
        this.date = date;
        this.publishWork = publishWork;
        this.moderator = moderator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PublishWork getPublishWork() {
        return publishWork;
    }

    public void setPublishWork(PublishWork publishWork) {
        this.publishWork = publishWork;
    }

    public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }

    public void approve() {
        this.isApproved = true;
    }
}
