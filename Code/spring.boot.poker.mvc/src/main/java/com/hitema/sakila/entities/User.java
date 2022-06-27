package com.hitema.sakila.entities;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "post")
    private String Poste;

    @Column(name = "roles")
    private String Role;


    @ManyToMany
    @JoinTable(name = "users_has_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    @ManyToMany
    @JoinTable(name = "session_has_users",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "idSession")})
    private List<Session> session;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String poste) {
        Poste = poste;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public List<com.hitema.sakila.entities.Role> getRoles() {
        return roles;
    }

    public void setRoles(List<com.hitema.sakila.entities.Role> roles) {
        this.roles = roles;
    }

    public List<Session> getSession() {
        return session;
    }

    public void setSession(List<Session> session) {
        this.session = session;
    }

    public User(Integer id, String nom, String poste, String role, List<com.hitema.sakila.entities.Role> roles, List<Session> session) {
        this.id = id;
        this.nom = nom;
        Poste = poste;
        Role = role;
        this.roles = roles;
        this.session = session;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", Poste='" + Poste + '\'' +
                ", Role='" + Role + '\'' +
                ", roles=" + roles +
                ", session=" + session +
                '}';
    }
}

