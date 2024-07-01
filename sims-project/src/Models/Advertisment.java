package Models;

import java.util.Date;

public class Advertisment {
    private String id;
    private String title;
    private String image;
    private String description;
    private Date startDate;
    private Date endDate;
    private Double profit;

    public Advertisment() {
    }

    public Advertisment(String id, String title, String image, String description, Date startDate, Date endDate, Double profit) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.profit = profit;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}
