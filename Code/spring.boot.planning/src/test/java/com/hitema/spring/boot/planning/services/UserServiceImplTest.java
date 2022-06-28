package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.Role;
import com.hitema.spring.boot.planning.entities.User;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest
@TestInstance(PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        log.info("<<<<< START ReadAll User >>>>>");
        service.readAll().forEach(c->log.trace("{}",c));
        log.info("<<<<< END ReadAll User >>>>>");
    }

    @Test
    @Order(0)
    void Create() {
        log.info("<<<START CreateNewUser >>>");
        user = new User();
        user.setNom("Nom TEST");
        user.setPoste("poste TEST");
        service.create(user);
        assertNotNull(user.getId(),"ERROR User NOT CREATED !!!!");
        log.info("User Created : {}",user);
        log.info("<<<END   CreateNewUser >>>");
    }

    @Test
    @Order(1)
    void Read() {
        log.info("<<<START ReadNewCreatedUser >>>");
        var newUser = service.read(user.getId());
        log.info("Role readed : {}",user);
        assertNotNull(newUser,"ERROR New Created User cannot be found !!!!");
        log.info("<<<END   ReadNewCreatedUser >>>");
    }

    @Test
    @Order(2)
    void Update() {
        log.info("<<<START Update User>>>>");
        Assertions.assertNotNull(this.user, "ERROR While Read User, empty user !!!");
        User u = this.service.read(this.user.getId());
        u.setNom(u.getNom() + "----Modified----");
        this.service.update(u);
        log.trace("Update Ok :{}", u);
        log.info("<<<END   Update User>>>>");
    }

    @Test
    @Order(3)
    void Delete() {
        log.info("<<<START shouldDeleteNewCreatedUser >>>");
        assertTrue(service.delete(user.getId()),"ERROR While DELETE New Created User, id"+user.getId());
        log.info("user Id:{} deleted",user.getId());
        log.info("<<<END   shouldDeleteNewCreatedUser >>>");
    }
}