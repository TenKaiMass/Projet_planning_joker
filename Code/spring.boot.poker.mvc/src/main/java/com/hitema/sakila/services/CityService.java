package com.hitema.sakila.services;

import com.hitema.sakila.entities.City;

import java.util.List;

public interface CityService {
    List<City> readAll();
    City create(City city);
    City read(Long id);
    City update(City city);
    Boolean delete(Long id);
    List<City> readAllCapitals();
    List<City> readNameLike(String name);
}
