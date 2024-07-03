package Models.Data;

import Models.Account;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;

@XStreamAlias("accountsList")
public class AccountsList {
    public static AccountsList instance = null;

    @XStreamAlias("accounts")
    private ArrayList<Account> accounts;
    private AccountsList() {
        this.accounts = new ArrayList<Account>();
    }

    public static AccountsList getInstance() {
        if (instance == null) {
            instance = new AccountsList();
        }
        return instance;
    }

    public static void setInstance(AccountsList instance) {
        AccountsList.instance = instance;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    

    public void addAccount(Account account) {
        this.accounts.add(account);

    }
    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

}
