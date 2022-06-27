package com.hitema.sakila.services;

import com.hitema.sakila.entities.Country;

import java.util.List;

public interface CountryService {
    List<Country> readAll();
    Country create(Country country);
    Country read(Long id);
    Country update(Country country);
    Boolean delete(Long id);
}
