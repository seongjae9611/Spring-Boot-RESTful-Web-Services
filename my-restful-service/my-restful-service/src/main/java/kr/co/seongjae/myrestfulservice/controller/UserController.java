package kr.co.seongjae.myrestfulservice.controller;

import jakarta.validation.Valid;
import kr.co.seongjae.myrestfulservice.bean.User;
import kr.co.seongjae.myrestfulservice.dao.UserDaoService;
import kr.co.seongjae.myrestfulservice.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("id[%s] not found", id));
        }

        return user;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        User deleteUser = service.deleteById(id);

        if (deleteUser == null) {
            throw new UserNotFoundException(String.format("id[%s] not found", id));
        }

        return ResponseEntity.noContent().build();
    }
}
