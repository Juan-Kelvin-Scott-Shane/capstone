package com.example.capstone.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genre")
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String title;

    @ManyToOne
	@JoinColumn(name="event_id")
    private Event event;

    @ManyToMany(mappedBy = "genres")
	private List<User> user;

	public Genre() {
	}

	public Genre(Long id, String title, Event event, List<User> user) {
		this.id = id;
		this.title = title;
		this.event = event;
		this.user = user;
	}

	public Genre(String title, Event event, List<User> user) {
		this.title = title;
		this.event = event;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
}
