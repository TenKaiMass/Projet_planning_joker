package com.hitema.spring.boot.planning.entities;


import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idroles;
    @Column(name = "role")
    private String role;
    @Column(name = "label")
    private String label;

//    @ManyToMany(mappedBy = "roles")
//    List<User> users;


    public Role(Integer idroles, String role, String label) {
        this.idroles = idroles;
        this.role = role;
        this.label = label;
    }

    public Integer getIdroles() {
        return idroles;
    }

    public void setIdroles(Integer idroles) {
        this.idroles = idroles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idroles=" + idroles +
                ", role='" + role + '\'' +
                ", label='" + label + '\'' +
                '}';
    }

    public Role() {

    }
}