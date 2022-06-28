package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.Role;
import com.hitema.spring.boot.planning.repositories.RoleRepository;
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
        return repository.save(role);
    }

    @Override
    public Role update(Role role) {
        return repository.save(role);
    }

    @Override
    public Role read(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return (read(id) == null);
    }
}
