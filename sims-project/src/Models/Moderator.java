package Models;

import java.util.Date;
import Enums.Role;
import Enums.Gender;

public class Moderator extends Person {
    private boolean hasLicense;

    public Moderator(String id, String name, String lastName, String address, Date dateOfBirth, Gender gender, boolean hasLicense) {
        super(id, name, lastName, Role.MODERATOR, address, dateOfBirth, gender);
        this.hasLicense = hasLicense;
    }

    public boolean isHasLicense() {
        return hasLicense;
    }

    public void setHasLicense(boolean hasLicense) {
        this.hasLicense = hasLicense;
    }
}