package com.hitema.sakila.repositories;

import com.hitema.sakila.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
