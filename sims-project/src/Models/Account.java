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


    private List<Account> accounts;

    public Account() {
        accounts = new ArrayList<>();
        loadAccountsFromXML();
    }

    public Account(Person person, String email, boolean isBlocked, boolean isPrivate,String password) {
        this.person = person;
        this.email = email;
        this.password=password;
        this.isBlocked = isBlocked;
        this.isPrivate = isPrivate;
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
    public void sendNotification(Notification notification){
        ArrayList<Notification> n;
        n = this.person.getNotifications();
        n.add(notification);
        this.person.setNotifications(n);

    public void setPassword (String p) {password=p;}

    public String getPassword() {return password;}

    public boolean changePassword(String p) {
        return true; //TODO
    }

    public void addAccount(Account account) {
        accounts.add(account);
        saveAccountsToXML();
    }

    public Account findAccount(String username, String password) {
        for (Account account : accounts) {
            if (account.getEmail().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    public boolean usernameExists(String username) {
        for (Account account : accounts) {
            if (account.getEmail().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void saveAccountsToXML() {
        XStream xstream = new XStream();
        xstream.alias("account", Account.class);
        xstream.addPermission(AnyTypePermission.ANY); // Dodavanje permisije

        try (FileWriter writer = new FileWriter("accounts.xml")) {
            xstream.toXML(accounts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAccountsFromXML() {
        XStream xstream = new XStream();
        xstream.alias("account", Account.class);
        xstream.addPermission(AnyTypePermission.ANY); // Dodavanje permisije

        try (FileReader reader = new FileReader("accounts.xml")) {
            accounts = (List<Account>) xstream.fromXML(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFreeID() {
        int maxId = 0;
        for (Account account : accounts) {
            Person person = account.getPerson();
            if (person != null && person.getId().startsWith("U")) {
                try {
                    int id = Integer.parseInt(person.getId().substring(1));
                    if (id > maxId) {
                        maxId = id;
                    }
                } catch (NumberFormatException e) {
                    // Ignore invalid IDs
                }
            }
        }
        return "U" + String.format("%03d", maxId + 1);
    }
}
