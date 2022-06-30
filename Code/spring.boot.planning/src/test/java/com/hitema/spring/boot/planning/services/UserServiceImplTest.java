package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.Role;
import com.hitema.spring.boot.planning.entities.User;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    void changePass(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User u = this.service.read(10L);
        u.setPassword(encoder.encode(u.getPassword()));
        this.service.update(u);
        log.info("User update : {}",u);

        User u2 = this.service.read(12L);
        u2.setPassword(encoder.encode(u2.getPassword()));
        this.service.update(u2);
        log.info("User update : {}",u2);

        User u3 = this.service.read(11L);
        u3.setPassword(encoder.encode(u.getPassword()));
        this.service.update(u3);

        log.info("User update : {}",u);
        User u6 = this.service.read(14L);
        u6.setPassword(encoder.encode(u6.getPassword()));
        this.service.update(u6);
        log.info("User update : {}",u6);

        User u4 = this.service.read(15L);
        u4.setPassword(encoder.encode(u4.getPassword()));
        this.service.update(u4);
        log.info("User update : {}",u4);

        User u5 = this.service.read(16L);
        u5.setPassword(encoder.encode(u5.getPassword()));
        this.service.update(u5);
        log.info("User update : {}",u5);
    }
    @Test
    @Order(0)
    void Create() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String mdp = "Admin";
        String mdpEncode = encoder.encode(mdp);
        log.info(mdpEncode);
        log.info("<<<START CreateNewUser >>>");
        user = new User();
        user.setNom("Admin");
        user.setPoste("Developeur");
        user.setRole("admin");
        user.setPassword(mdpEncode);
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
    @Test
    // Test permettant la creation d'utilisateur par defaut
    void createDefaultUser(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        log.info("<<<START CreateNewUser >>>");
        user = new User();
        user.setNom("Admin");
        user.setPoste("Developeur");
        user.setRole("admin");
        user.setPassword(encoder.encode("Admin"));
        service.create(user);
        log.info("User Created : {}",user);

        user = new User();
        user.setNom("Benoit");
        user.setPoste("Chef de Projet");
        user.setRole("membre");
        user.setPassword(encoder.encode("Benoit"));
        service.create(user);
        log.info("User Created : {}",user);

        user = new User();
        user.setNom("Kevin");
        user.setPoste("Developeur SQL");
        user.setRole("membre");
        user.setPassword(encoder.encode("Kevin"));
        service.create(user);
        log.info("User Created : {}",user);

        user = new User();
        user.setNom("Massine");
        user.setPoste("Devops");
        user.setRole("membre");
        user.setPassword(encoder.encode("Massine"));
        service.create(user);
        log.info("User Created : {}",user);

        user = new User();
        user.setNom("Alice");
        user.setPoste("Manageur");
        user.setRole("responsable");
        user.setPassword(encoder.encode("Alice"));
        service.create(user);
        log.info("User Created : {}",user);
        log.info("<<<END   End create User>>>>");
    }
}