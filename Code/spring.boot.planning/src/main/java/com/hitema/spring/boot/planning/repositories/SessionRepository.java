package com.hitema.spring.boot.planning.repositories;

import com.hitema.spring.boot.planning.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
