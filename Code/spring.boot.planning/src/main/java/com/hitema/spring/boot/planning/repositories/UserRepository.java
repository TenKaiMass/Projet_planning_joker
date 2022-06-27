package com.hitema.spring.boot.planning.repositories;

import com.hitema.spring.boot.planning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}