package com.hitema.sakila.services;

import com.hitema.sakila.entities.Country;
import com.hitema.sakila.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    private CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Country> readAll() {
        return repository.findAll();
    }

    @Override
    public Country create(Country country) {
        return repository.save(country);
    }

    @Override
    public Country read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Country update(Country country) {
        return repository.save(country);
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return (read(id) == null);
    }
}
