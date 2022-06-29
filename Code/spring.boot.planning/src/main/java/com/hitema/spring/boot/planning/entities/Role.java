package com.hitema.spring.boot.planning.entities;


import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "role")
    private String role;
    @Column(name = "label")
    private String label;


    public Role(Integer id, String role, String label) {
        this.id = id;
        this.role = role;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", role='" + role + '\'' +
                ", label='" + label + '\'' +
                '}';
    }

    public Role() {

    }
}