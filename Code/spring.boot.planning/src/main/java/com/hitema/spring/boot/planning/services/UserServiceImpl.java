package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.User;
import com.hitema.spring.boot.planning.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{


    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> readAll() {
        return repository.findAll();
    }

    @Override
    public User create(User user) {
        return repository.save(user);    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public User read(Integer id) {return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> readAllMember(){
        return repository.findAllMemberByRole();
    }
    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return (read(id) == null);
    }
}
