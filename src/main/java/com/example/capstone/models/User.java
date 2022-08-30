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
    private String profile_img = "https://cdn.filestackcontent.com/RUeUf2m3SiCYjVoIVXIm";

    @Column()
    private String youtube;

    @Column()
    private String social_media;

    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private String userType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Proficiency> proficiencies;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_instrum",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "instrum_id")})
    private List<Instrument> instruments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Event> hostedEvents;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(User copy) {
        id = copy.id;
        firstName = copy.firstName;
        lastName = copy.lastName;
        username = copy.username;
        email = copy.email;
        password = copy.password;
        city = copy.city;
        state = copy.state;
        description = copy.description;
        profile_img = copy.profile_img;
        youtube = copy.youtube;
        social_media = copy.social_media;
        verificationCode = copy.verificationCode;
        enabled = copy.enabled;
        proficiencies = copy.proficiencies;
        instruments  = copy.instruments;
//        genres = copy.genres;
        userType = copy.userType;


    }

    public User(long id, String firstName, String lastName, String username, String email, String password, String city, String state, String description, String profile_img, String youtube, String social_media, String verificationCode, boolean enabled, String userType, List<Proficiency> proficiencies, List<Instrument> instruments, List<Event> hostedEvents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.state = state;
        this.description = description;
        this.profile_img = profile_img;
        this.youtube = youtube;
        this.social_media = social_media;
        this.verificationCode = verificationCode;
        this.enabled = enabled;
        this.userType = userType;
        this.proficiencies = proficiencies;
        this.instruments = instruments;
        this.hostedEvents = hostedEvents;
    }

    public User(String firstName, String lastName, String username, String email, String password, String city, String state, String description, String profile_img, String youtube, String social_media, String verificationCode, boolean enabled, List<Proficiency> proficiencies, List<Instrument> instruments, List<Genre> genres) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.state = state;
        this.description = description;
        this.profile_img = profile_img;
        this.youtube = youtube;
        this.social_media = social_media;
        this.verificationCode = verificationCode;
        this.enabled = enabled;
        this.proficiencies = proficiencies;
        this.instruments = instruments;
//        this.genres = genres;
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

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public String getSocial_media() {
        return social_media;
    }

    public void setSocial_media(String social_media) {
        this.social_media = social_media;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public void setProficiencies(List<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<Event> getHostedEvents() {
        return hostedEvents;
    }

    public void setHostedEvents(List<Event> hostedEvents) {
        this.hostedEvents = hostedEvents;
    }

}