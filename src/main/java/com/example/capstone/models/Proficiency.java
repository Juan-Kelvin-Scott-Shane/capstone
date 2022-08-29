package com.example.capstone.models;



import javax.persistence.*;

@Entity
@Table(name="proficiency")
public class Proficiency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length=50)
    private String skill;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="instrum_id")
    private Instrument instruments;

    @ManyToOne
    @JoinColumn(name ="genre_id")
    private Genre genre;

    public Proficiency(long id, String skill, User user, Instrument instruments) {
        this.id = id;
        this.skill = skill;
        this.user = user;
        this.instruments = instruments;
    }

    public Proficiency(String skill, User user, Instrument instruments) {
        this.skill = skill;
        this.user = user;
        this.instruments = instruments;
    }

    public Proficiency() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instrument getInstruments() {
        return instruments;
    }

    public void setInstruments(Instrument instruments) {
        this.instruments = instruments;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
