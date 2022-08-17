package com.example.capstone.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true, length = 100)
    private String city;

    @Column(length = 50, nullable = true)
    private String state;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String profile_img;

    @Column(nullable = true)
    private String youtube;


    @Column(nullable = true)
    private String embed_link;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Proficiency> proficiencies;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_instrum",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "instrum_id")})
    private List<Instrument> instruments;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_genres",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genres;


    public User() {
    }

    public User(long id, String firstName, String lastName, String embed_link, String username, String email, String password, String city, String state, String description, String profile_img, List<Instrument> instruments, List<Genre> genres, List<Proficiency> proficiencies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.embed_link = embed_link;
        this.city = city;
        this.state = state;
        this.description = description;

        this.profile_img = profile_img;
        this.instruments = instruments;
        this.genres = genres;
        this.proficiencies = proficiencies;
    }

    public User(String username, String firstName, String lastName, String embed_link, String email, String password, String city, String state, String description, String profile_img, List<Instrument> instruments, List<Genre> genres, List<Proficiency> proficiencies) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public User(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmbed_link() {
        return embed_link;
    }

    public void setEmbed_link(String embed_link) {
        this.embed_link = embed_link;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }
}