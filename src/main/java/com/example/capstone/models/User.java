package com.example.capstone.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false, unique = true)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, length = 100)
	private String city;

	@Column(length = 50, nullable = false)
	private String state;

	@Column(nullable = false)
	private String description;

    @Column(nullable = true)
    private String embed_link;

    @Column(nullable = true)
    private String profile_img;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Proficiency>proficiencies;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_instrum",
    joinColumns={@JoinColumn(name="user_id")},
    inverseJoinColumns = {@JoinColumn(name="instrum_id")})
	private List<Instrument> instruments;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_genres",
    joinColumns = {@JoinColumn(name="user_id")},
    inverseJoinColumns = {@JoinColumn(name="genre_id")})
    private List<Genre>genres;



    public User() {
    }

    public User(long id, String username, String email, String password, String city, String state, String description, String embed_link, String profile_img, List<Instrument> instruments, List<Genre> genres,List<Proficiency>proficiencies) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.state = state;
        this.description = description;
        this.embed_link = embed_link;
        this.profile_img = profile_img;
        this.instruments = instruments;
        this.genres = genres;
        this.proficiencies = proficiencies;
    }

    public User(String username, String email, String password, String city, String state, String description, String embed_link, String profile_img, List<Instrument> instruments, List<Genre> genres,List<Proficiency>proficiencies) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.state = state;
        this.description = description;
        this.embed_link = embed_link;
        this.profile_img = profile_img;
        this.instruments = instruments;
        this.genres = genres;
        this.proficiencies=proficiencies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmbed_link() {
        return embed_link;
    }

    public void setEmbed_link(String embed_link) {
        this.embed_link = embed_link;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;

    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }
}