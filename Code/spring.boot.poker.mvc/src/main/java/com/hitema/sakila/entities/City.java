package com.hitema.sakila.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
    @Table(name = "city")
public class City {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="city_id")
    private Long id;
    private String city;

    @ManyToOne
        @JoinColumn(name = "country_id")
    private Country country;

    private Boolean capital;

    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    public Country getCountry() {
        return country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", capital=" + capital +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
