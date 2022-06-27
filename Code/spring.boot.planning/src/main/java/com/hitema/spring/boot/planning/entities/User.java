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

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String poste) {
        Poste = poste;
    }

    public User(Integer id, String nom, String poste) {
        this.id = id;
        this.nom = nom;
        Poste = poste;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", Poste='" + Poste + '\'' +
                '}';
    }
}

