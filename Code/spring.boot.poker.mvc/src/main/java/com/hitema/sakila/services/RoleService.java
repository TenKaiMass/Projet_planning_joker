package com.hitema.sakila.services;

import com.hitema.sakila.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> readAll();
    Role create(Role role);
    Role update(Role role);
    Role read(Integer id);
    Boolean delete(Integer id);

}
