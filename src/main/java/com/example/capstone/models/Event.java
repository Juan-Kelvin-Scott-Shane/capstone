package com.example.capstone.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Column()
    private String flyer;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Genre> genres;
//    @ManyToMany(mappedBy = "events")
//    List<User> users;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    User owner;

    public Event() {
    }

    public Event(String title, String description, String city,String state,String location, String date, String time) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time=time;
        this.city=city;
        this.state=state;
    }

    public Event(String title, String description,String city,String state, String location, String date, String time, String flyer, List<Genre> genres, User owner) {
        this.title = title;
        this.description = description;
//        this.location = location;
        this.date = date;
        this.time = time;
        this.flyer = flyer;
        this.genres = genres;
        this.owner = owner;
        this.city=city;
        this.state=state;
    }

    public Event(long id, String title,String city, String state, String description, String location, String date, String time, List<Genre> genres, User owner) {
        this.id = id;
        this.title = title;
        this.description = description;
//        this.location = location;
        this.date = date;
        this.time = time;
        this.genres = genres;
        this.owner = owner;
        this.state=state;
        this.city=city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getFlyer() {
        return flyer;
    }

    public void setFlyer(String flyer) {
        this.flyer = flyer;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
