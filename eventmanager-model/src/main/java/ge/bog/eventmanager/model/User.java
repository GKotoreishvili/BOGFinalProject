package ge.bog.eventmanager.model;

import ge.bog.eventmanager.model.staticclasses.HashPassword;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FIRST_NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String surName;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "PASSWORD")
    private String password;

    public User(String name, String surName, String phoneNumber, String userName, String password) {
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = HashPassword.hashPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }
}
