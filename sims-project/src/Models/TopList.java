package Models;

import java.util.Date;

public class TopList {
    private String id;
    private String description;
    private String title;
    private Date year;
    //topListTyple

    public TopList() {
    }

    public TopList(String id, String description, String title, Date year) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
}
