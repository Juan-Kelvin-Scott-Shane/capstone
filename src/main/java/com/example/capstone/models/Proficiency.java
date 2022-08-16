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

}
