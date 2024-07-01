package Models;

import java.util.Date;
import Enums.Role;
import Enums.Gender;
public class Admin extends Person {

    public Admin(String id, String name, String lastName, String address, Date dateOfBirth, Gender gender, Account account) {

        super(id, name, lastName, Role.ADMIN, address, dateOfBirth, gender, account);
    }
}
