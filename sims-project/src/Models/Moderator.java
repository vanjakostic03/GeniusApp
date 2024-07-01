package Models;

import java.util.Date;
import java.util.List;

import Enums.Role;
import Enums.Gender;

public class Moderator extends Person {
    private boolean hasLicense;
    private List<Review> reviews;
    public Moderator(String id, String name, String lastName, String address, Date dateOfBirth, Gender gender, boolean hasLicense, Account account) {
        super(id, name, lastName, Role.MODERATOR, address, dateOfBirth, gender, account);
        this.hasLicense = hasLicense;
    }

    public boolean isHasLicense() {
        return hasLicense;
    }

    public void setHasLicense(boolean hasLicense) {
        this.hasLicense = hasLicense;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}