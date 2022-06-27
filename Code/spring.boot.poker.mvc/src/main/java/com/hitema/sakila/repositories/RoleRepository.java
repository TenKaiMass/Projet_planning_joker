package com.hitema.sakila.repositories;

import com.hitema.sakila.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
