package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.Session;

import java.util.List;

public interface SessionService {
    List<Session> readAll();
    Session create(Session session);
    Session update(Session session);
    Session read(Integer id);
    Boolean delete(Integer id);

}
