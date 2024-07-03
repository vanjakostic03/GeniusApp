package Models;

import java.util.Date;

public class Comment {
    private String id;
    private String text;
    private int grade;
    private boolean isApproved;
    private Date date;
    private PublishedWork publishWork;
    private Person person;

    public Comment() {
    }

    public Comment(String id, String text, int grade, boolean isApproved, Date date, PublishedWork publishWork, Person person) {
        this.id = id;
        this.text = text;
        this.grade = grade;
        this.isApproved = isApproved;
        this.date = date;
        this.publishWork = publishWork;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public PublishedWork getPublishWork() {
        return publishWork;
    }

    public void setPublishWork(PublishedWork publishWork) {
        this.publishWork = publishWork;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void approve() {
        this.isApproved = true;
    }
}
