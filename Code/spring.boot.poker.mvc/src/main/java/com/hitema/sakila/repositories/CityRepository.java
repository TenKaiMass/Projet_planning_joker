package com.hitema.sakila.repositories;

import com.hitema.sakila.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    // Named Query - JPQL
    @Query("from City where capital=true")
    List<City> findCapitals();

    // Magic - By Method Name
    List<City> findAllByCapitalIsTrue();
    List<City> findAllByCityContains(String name);
}