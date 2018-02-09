package com.jnj.honeur.usermgmt.controller;

import com.jnj.honeur.usermgmt.exception.UserNotFoundException;
import com.jnj.honeur.usermgmt.model.User;
import com.jnj.honeur.usermgmt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userService.findById(id);

        if (user == null)
            throw new UserNotFoundException("id-" + id);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody User user, @PathVariable int id) {

        User userEntity = userService.findById(id);

        if (userEntity == null)
            return ResponseEntity.notFound().build();

        user.setId(id);

        userService.save(user);

        return ResponseEntity.noContent().build();
    }

}
