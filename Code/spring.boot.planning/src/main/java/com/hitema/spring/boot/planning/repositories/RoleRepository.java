package com.hitema.spring.boot.planning.repositories;


import com.hitema.spring.boot.planning.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
