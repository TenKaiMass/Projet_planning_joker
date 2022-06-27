package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.Session;
import com.hitema.spring.boot.planning.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SessionServiceImpl implements SessionService{


    private SessionRepository repository;

    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Session> readAll() {
        return repository.findAll();
    }

    @Override
    public Session create(Session session) {
        return null;
    }

    @Override
    public Session update(Session session) {
        return null;
    }

    @Override
    public Session read(Integer id) {return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
