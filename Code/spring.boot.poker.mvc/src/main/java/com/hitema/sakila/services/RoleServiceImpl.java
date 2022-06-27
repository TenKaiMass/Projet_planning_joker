package com.hitema.sakila.services;

import com.hitema.sakila.entities.Role;
import com.hitema.sakila.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{


    private RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> readAll() {
        return repository.findAll();
    }

    @Override
    public Role create(Role role) {
        return null;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public Role read(Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
