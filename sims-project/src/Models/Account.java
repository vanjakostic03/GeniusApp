package Models;

import java.util.ArrayList;

public class Account {
    private Person person;
    private String email;
    private  boolean isBlocked;
    private boolean isPrivate;

    public Account(Person person, String email, boolean isBlocked, boolean isPrivate) {
        this.person = person;
        this.email = email;
        this.isBlocked = isBlocked;
        this.isPrivate = isPrivate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
    public void block(){
        this.isBlocked = true;
    }
    public void unBlock(){
        this.isBlocked = false;
    }
    public void changePrivacy(){
        this.isPrivate = !isPrivate;
    }
    public void sendNotification(Notification notification){
        ArrayList<Notification> n;
        n = this.person.getNotifications();
        n.add(notification);
        this.person.setNotifications(n);
    }
}
