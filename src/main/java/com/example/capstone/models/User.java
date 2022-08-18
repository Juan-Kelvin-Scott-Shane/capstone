package com.example.capstone.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 100)
    private String city;

    @Column(length = 50)
    private String state;

    @Column()
    private String description;

    @Column()
    private String profile_img;

    @Column()
    private String youtube;

    @Column()
    private String social_media;

    @Column(name= "verification_code",length=64)
    private String verification_code;

    @Column(name="enable")
    private boolean enable;

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
    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public User(long id, String firstName, String lastName, String social_media, String username, String email, String password, String city, String state, String description, String profile_img, String verification_code, boolean enable, List<Instrument> instruments, List<Genre> genres, List<Proficiency> proficiencies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.social_media = social_media;
        this.city = city;
        this.state = state;
        this.description = description;
        this.profile_img = profile_img;
        this.verification_code = verification_code;
        this.enable = enable;
        this.instruments = instruments;
        this.genres = genres;
        this.proficiencies = proficiencies;
    }

    public User(String username, String firstName, String lastName, String social_media, String email, String password, String city, String state, String description, String profile_img, String verification_code, boolean enable, List<Instrument> instruments, List<Genre> genres, List<Proficiency> proficiencies) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.city = city;
        this.state = state;
        this.description = description;
        this.social_media = social_media;

        this.profile_img = profile_img;
        this.verification_code = verification_code;
        this.enable = enable;
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

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getSocial_media() {
        return social_media;
    }

    public void setSocial_media(String social_media) {
        this.social_media = social_media;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }
}