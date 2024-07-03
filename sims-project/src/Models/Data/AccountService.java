package Models.Data;

import Models.Account;
import Models.Person;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountService {

    private ArrayList<Account> accounts ;

    public AccountService() {
        this.accounts = new ArrayList<>();
        loadAccountsFromXML();
    }
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

        try (FileWriter writer = new FileWriter("./Data/accounts.xml")) {
            xstream.toXML(accounts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAccountsFromXML() {
        XStream xstream = new XStream();
        xstream.alias("account", Account.class);
        xstream.addPermission(AnyTypePermission.ANY); // Dodavanje permisije

        try (FileReader reader = new FileReader("./Data/accounts.xml")) {
            accounts = (ArrayList<Account>) xstream.fromXML(reader);
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
