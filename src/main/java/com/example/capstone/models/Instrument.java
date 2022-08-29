package com.example.capstone.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="instrument")
public class Instrument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String instName;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "instruments")
	private List<Proficiency>proficiencies;

	@ManyToMany(mappedBy = "instruments")
	private List<User> user;

	public Instrument() {
	}

	public Instrument(Long id, String instName, List<User> user) {
		this.id = id;
		this.instName = instName;
		this.user = user;
	}

	public Instrument(Long id, String instName, List<Proficiency> proficiencies, List<User> user, List<Genre> genre) {
		this.id = id;
		this.instName = instName;
		this.proficiencies = proficiencies;
		this.user = user;
//		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}



	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Proficiency> getProficiencies() {
		return proficiencies;
	}

	public void setProficiencies(List<Proficiency> proficiencies) {
		this.proficiencies = proficiencies;
	}

}
