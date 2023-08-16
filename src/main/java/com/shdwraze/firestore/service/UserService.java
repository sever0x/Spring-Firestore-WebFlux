package com.shdwraze.firestore.service;

import com.shdwraze.firestore.model.entity.User;
import com.shdwraze.firestore.model.request.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> getUsers(String city);

    Mono<User> getUserById(String id);

    Mono<User> addUser(UserDTO addUser);

    Mono<Void> updateUser(String id, UserDTO updateUser);

    Mono<Void> deleteUser(String id);
}
