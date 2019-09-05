package ge.bog.eventmanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "EVENT_CATEGORIES")
    private List<Category> categories = new ArrayList<>();

    public Event(String name, String description, Date startDate, String imageUrl, Category categoryName) {

        this.name = name;
        this.description = description;

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();

        this.createDate = dateobj;

        this.startDate = startDate;
        this.imageUrl = imageUrl;
        this.categories.add(categoryName);
    }

    public Event() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static void main(String[] args) {

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
    }
}
