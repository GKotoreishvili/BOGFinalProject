package ge.bog.eventmanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FIRST_NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String surName;

    @Column(unique = true)
    private String pin;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();

    public User(int id, String name, String surName, String pin, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.pin = pin;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
