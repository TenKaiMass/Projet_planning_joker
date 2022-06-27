package com.hitema.sakila.services;

import com.hitema.sakila.entities.City;
import com.hitema.sakila.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    private final CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> readAll() {
        return repository.findAll();
    }

    @Override
    public City create(City city) {
        return null;
    }

    @Override
    public City read(Long id) {
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public List<City> readAllCapitals() {
        return repository.findAllByCapitalIsTrue();
    }

    @Override
    public List<City> readNameLike(String name) {
        return repository.findAllByCityContains(name);
    }


}
