package com.example.capstone.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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

    @Column(nullable = false)
    @CreationTimestamp
    private Date date;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Genre> genres;


    public Event() {
    }

    public Event(long id, String title, String description, String location, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.genres = genres;
    }

    public Event(String title, String description, String location, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.genres = genres;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenre(List<Genre> genres) {
        this.genres = genres;
    }
}
