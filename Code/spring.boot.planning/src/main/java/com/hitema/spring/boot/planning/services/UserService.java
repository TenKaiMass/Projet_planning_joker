package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.User;

import java.util.List;

public interface UserService {
    List<User> readAll();
    User create(User user);
    User update(User user);
    User read(Integer id);

    List<User> readAllMember();

    Boolean delete(Integer id);

}
