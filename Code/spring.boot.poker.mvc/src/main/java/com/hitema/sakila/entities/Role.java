package com.hitema.sakila.entities;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

@Entity
    @Table(name="roles")
public class Role {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name ;
    private String label ;

    @ManyToMany(mappedBy="roles")
    private List<Person> users;

    @Column(name="create_date")
    private LocalDateTime creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<Person> getUsers() {
        return users;
    }

    public void setUsers(List<Person> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }


}
