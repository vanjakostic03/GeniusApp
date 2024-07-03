package nesto;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import Models.Account;

public class UserModel {
    private List<Account> accounts;

    public UserModel() {
        accounts = new ArrayList<>();
        loadAccountsFromXML(); // Učitaj podatke iz XML fajla prilikom kreiranja objekta
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
}
