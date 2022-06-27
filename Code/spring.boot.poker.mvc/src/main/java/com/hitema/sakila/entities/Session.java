package com.hitema.sakila.entities;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

@Entity
@Table(name="session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSession;

    private String nom ;
    private String Unite ;

    @ManyToMany
    @JoinTable(name = "session_has_users",
            joinColumns = {@JoinColumn(name = "idSession")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<Session> session;

    @Column(name="date_creation")
    private LocalDateTime creationDate;


}

