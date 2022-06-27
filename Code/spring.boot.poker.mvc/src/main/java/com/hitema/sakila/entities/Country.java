package com.hitema.sakila.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
    @Table(name="country")
public class Country {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="country_id")
    private Long id;

    private String country;

    @OneToMany
        @JoinColumn(name="country_id")
    private List<City> cities;

    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", cities=[....]" +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
