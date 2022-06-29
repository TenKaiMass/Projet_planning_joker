package com.hitema.spring.boot.planning.repositories;

import com.hitema.spring.boot.planning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("FROM User WHERE Role like 'membre'")
    List<User> findAllMemberByRole();

    //String member = "membre";
    //List<User> findAllByRoleIsContaining(member);
}