package com.example.capstone.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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


    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date date;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Genre> genres;
    @ManyToMany(mappedBy = "events")
    List<User> users;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    User owner;

    public Event() {
    }

    public Event(long id, String title, String description, String location, Date date, Date time, List<Genre> genres, List<User> users, User owner) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;

        this.genres = genres;
        this.users = users;
        this.owner = owner;
    }

    public Event(String title, String description, String location, Date date, Date time, List<Genre> genres, List<User> users, User owner) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.genres = genres;
        this.users = users;
        this.owner = owner;
    }

    public Event(String title, String description, String location) {
        this.title = title;
        this.description = description;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
