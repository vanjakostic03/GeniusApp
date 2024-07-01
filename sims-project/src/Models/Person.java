package Models;
import Enums.Role;
import Enums.Gender;
import java.util.Date;
import java.util.List;

public class Person {

    private String id;
    private String name;
    private String lastName;
    private Role role;
    private String address;
    private Date dateOfBirth;
    private Gender gender;
    private Account account;
    private List<PlayList> playLists;

    public Person(String id, String name, String lastName, Role role, String address, Date dateOfBirth, Gender gender, Account account) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.account = account;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlayList> playLists) {
        this.playLists = playLists;
    }
}
