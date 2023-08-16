package com.shdwraze.firestore.controller;

import com.shdwraze.firestore.model.entity.User;
import com.shdwraze.firestore.model.request.UserDTO;
import com.shdwraze.firestore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Flux<User> getUsers(@RequestParam String city) {
        return userService.getUsers(city);
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Mono<User> addUser(@RequestBody UserDTO addUser) {
        return userService.addUser(addUser);
    }

    @PutMapping("/{id}")
    public Mono<Void> updateUser(@PathVariable String id, @RequestBody UserDTO updateUser) {
        return userService.updateUser(id, updateUser);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
