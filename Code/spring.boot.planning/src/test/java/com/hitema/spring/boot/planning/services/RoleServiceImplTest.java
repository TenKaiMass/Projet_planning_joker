package com.hitema.spring.boot.planning.services;

import com.hitema.spring.boot.planning.entities.Role;
import com.hitema.spring.boot.planning.entities.User;
import org.junit.jupiter.api.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest
@TestInstance(PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoleServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(RoleServiceImplTest.class);
    @Autowired
    private RoleService service;

    private Role role;


    @BeforeEach
    void setUp() {
        log.info("Start before each");
        assertTrue(service!=null, "Service Role NOT Injected !!!");
    }

    @Test
    void ReadAll() {
        log.info("<<<<< START ReadAll Roles >>>>>");
        service.readAll().forEach(c->log.trace("{}",c));
        log.info("<<<<< END ReadAll Roles >>>>>");
    }

    @Test
    @Order(0)
    void Create() {
        role = new Role();
        log.info("<<<START CreateNewRole >>>");
        role.setRole("Role TEST");
        role.setLabel("Label TEST");
        service.create(role);
        assertNotNull(role.getId(),"ERROR Role NOT CREATED !!!!");
        log.info("Role Created : {}",role);
        log.info("<<<END   CreateNewRole >>>");
    }

    @Test
    @Order(1)
    void Read() {
        log.info("<<<START ReadNewCreatedRole >>>");
        var newRole = service.read(role.getId());
        log.info("Role readed : {}",role);
        assertNotNull(newRole,"ERROR New Created Role cannot be found !!!!");
        log.info("<<<END   ReadNewCreatedRole >>>");
    }

    @Test
    @Order(2)
    void Update() {
        log.info("<<<START Update Role>>>>");
        Assertions.assertNotNull(this.role, "ERROR While Read Role, empty role !!!");
        Role r = this.service.read(this.role.getId());
        r.setLabel(r.getLabel() + "----Modified----");
        this.service.update(r);
        log.trace("Update Ok :{}", r);
        log.info("<<<END   Update Role>>>>");
    }

    @Test
    @Order(3)
    void Delete() {
        log.info("<<<START DeleteNewCreatedRole >>>");
        assertTrue(service.delete(role.getId()),"ERROR While DELETE New Created Role, id"+role.getId());
        log.info("role Id:{} deleted",role.getId());
        log.info("<<<END   DeleteNewCreatedRole >>>");
    }
}