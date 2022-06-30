package com.hitema.spring.boot.planning.entities;



import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "post")
    private String Poste;

    @Column(name = "role")
    private String Role;
    @ManyToMany
    @JoinTable(name = "session_users",
                joinColumns = @JoinColumn(name ="Session_idSession" ),
                inverseJoinColumns = @JoinColumn(name = "Users_idUsers"))
    private List<Session> sessions;



/* @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",
            joinColumns={@JoinColumn(name="users_user_id")},
            inverseJoinColumns={@JoinColumn(name="roles_idroles")})
    private List<Role> roles;*/

    public User() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer idUsers) {
        this.id = idUsers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        this.Role = role;
    }

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String poste) {
        Poste = poste;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", Poste='" + Poste + '\'' +
                ", Role='" + Role + '\'' +
                ", sessions=" + sessions +
                '}';
    }

    public User(Integer id, String nom, String poste) {
        this.id = id;
        this.nom = nom;
        Poste = poste;
    }

}

