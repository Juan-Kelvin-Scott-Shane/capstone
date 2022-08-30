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
	@JoinTable(name="event_genre",joinColumns = {@JoinColumn(name="event_id")},inverseJoinColumns = {@JoinColumn(name="genre_id")})
    private Event event;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "genre")
	private List<Proficiency>proficiencies;
	public Genre() {
	}

	public Genre(Long id, String title, Event event, List<Proficiency> proficiencies) {
		this.id = id;
		this.title = title;
		this.event = event;
		this.proficiencies = proficiencies;
	}

	public Genre(String title) {
		this.title = title;
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

	public List<Proficiency> getProficiencies() {
		return proficiencies;
	}

	public void setProficiencies(List<Proficiency> proficiencies) {
		this.proficiencies = proficiencies;
	}

}
