package Models;

import java.util.Date;

public class Notification {
    private String id;
    private Date date;
    private String message;

    public Notification(String id, Date date, String message) {
        this.id = id;
        this.date = date;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
