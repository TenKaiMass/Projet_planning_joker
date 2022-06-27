package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImplTest.class);
    @Autowired
    private UserService service;

    private User user;

    @BeforeEach
    void setUp() {
        log.info("Start before each");
    }

    @Test
    void ReadAll() {
        log.info("<<<<< START >>>>>");
        service.readAll().forEach(c->log.trace("{}",c));
        log.info("<<<<< END >>>>>");
    }

    @Test
    void Create() {
    }

    @Test
    void Update() {
    }

    @Test
    void Read() {
//        log.info("Start read");
//        var users = service.read(1);
//        log.info("End Read");
    }

    @Test
    void testDelete() {
    }
}