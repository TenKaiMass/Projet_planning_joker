package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.Session;
import com.hitema.spring.boot.planning.entities.User;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest
@TestInstance(PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SessionServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(SessionServiceImplTest.class);
    @Autowired
    private SessionService service;

    @Autowired
    private UserService serviceUse;

    private Session session;

    @BeforeEach
    void setUp() {
        log.info("Start before each");
    }

    @Test

    void ReadAll() {
        log.info("<<<<< START ReadAll Session >>>>>");
        service.readAll().forEach(c->log.trace("{}",c));
        log.info("<<<<< END ReadAll Session >>>>>");
    }

    @Test
    @Order(0)
    void Create() {
        log.info("<<<START CreateNewSession >>>");
        session = new Session();
        session.setNom("Nom TEST");
        session.setUnites("Unites TEST");
        session.setCreationDate(LocalDateTime.now());
        var user = new User();
        user.setNom("toto");
        user.setPoste("DevOps");
        user = serviceUse.create(user);
        session.setUsers(List.of(user));
        session = service.create(session);
        assertNotNull(session.getId(),"ERROR User NOT CREATED !!!!");
        log.info("User Created : {}",session);
        log.info("<<<END   CreateNewSession >>>");

    }

    @Test
    @Order(1)
    void Read() {
        log.info("<<<START ReadNewCreatedSession >>>");
        var newSession = service.read(session.getId());
        log.info("Role readed : {}",session);
        assertNotNull(newSession,"ERROR New Created Session cannot be found !!!!");
        log.info("<<<END   ReadNewCreatedSession >>>");
    }

    @Test
    @Order(2)
    void Update() {
        log.info("<<<START Update Session>>>>");
        Assertions.assertNotNull(this.session, "ERROR While Read Session, empty session !!!");
        Session s = this.service.read(this.session.getId());
        s.setNom(s.getNom() + "----Modified----");
        this.service.update(s);
        log.trace("Update Ok :{}", s);
        log.info("<<<END   Update Session>>>>");
    }

    @Test
    @Order(3)
    void Delete() {
        log.info("<<<START shouldDeleteNewCreatedSession >>>");
        assertTrue(service.delete(session.getId()),"ERROR While DELETE New Created Session, id"+session.getId());
        log.info("session Id:{} deleted",session.getId());
        log.info("<<<END   shouldDeleteNewCreatedSession >>>");
    }
}