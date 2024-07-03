package Models;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

public class Account {
    private Person person;
    private String email;
    private String password;
    private  boolean isBlocked;
    private boolean isPrivate;
    private ArrayList<Notification> notifications;

    public Account(Person person, String email, boolean isBlocked, boolean isPrivate,String password) {
        this.person = person;
        this.email = email;
        this.password=password;
        this.isBlocked = isBlocked;
        this.isPrivate = isPrivate;
        this.notifications = new ArrayList<>();
    }

    public Account(String email, String password) {
        this.password = password;
        this.email = email;
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

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public void sendNotification(Notification notification) {
        ArrayList<Notification> n;
        n = this.getNotifications();
        n.add(notification);
        this.setNotifications(n);
    }
    public void setPassword (String p) {password=p;}

    public String getPassword() {return password;}


}
