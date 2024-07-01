package Models;

import java.util.Date;

public class RecordLabel {
    private String id;
    private String title;
    private String address;
    private String description;
    private Date dateOfEstablishment;

    public RecordLabel() {
    }

    public RecordLabel(String id, String title, String address, String description, Date dateOfEstablishment) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.description = description;
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(Date dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }
}
