package com.hitema.spring.boot.planning.repositories;

import com.hitema.spring.boot.planning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User WHERE Role like 'membre'")
    List<User> findAllMemberByRole();

    @Query("SELECT u FROM User u WHERE u.nom = :nom")
    User getUserByUsername(String nom);



}