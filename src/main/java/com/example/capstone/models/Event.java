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
    private String date;

    @Column(nullable = false)
    private String time;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    User owner;

    public Event() {
    }

    public Event(String title, String description, String location, String date, String time) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time=time;
    }

    public Event(long id, String title, String description, String location, String date, String time, List<Genre> genres, User owner) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.genres = genres;
        this.owner = owner;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
