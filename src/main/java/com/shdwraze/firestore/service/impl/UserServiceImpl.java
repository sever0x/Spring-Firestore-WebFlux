package com.shdwraze.firestore.service.impl;

import com.shdwraze.firestore.mapper.UserMapper;
import com.shdwraze.firestore.model.entity.User;
import com.shdwraze.firestore.model.request.UserDTO;
import com.shdwraze.firestore.repository.UserRepository;
import com.shdwraze.firestore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    public Flux<User> getUsers(String city) {
        if (city == null) {
            return userRepository.findAll();
        }
        return userRepository.findByHomeAddress_City(city);
    }

    @Override
    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> addUser(UserDTO addUser) {
        return userRepository.save(userMapper.toUser(addUser));
    }

    @Override
    public Mono<Void> updateUser(String id, UserDTO updateUser) {
        return userRepository.findById(id).flatMap(user -> {
            if (updateUser.firstName() != null) user.setFirstName(updateUser.firstName());
            if (updateUser.lastName() != null) user.setLastName(updateUser.lastName());
            if (updateUser.age() > 0) user.setAge(updateUser.age());
            if (updateUser.address() != null && !updateUser.address().equals(user.getHomeAddress()))
                user.setHomeAddress(updateUser.address());

            return userRepository.save(user);
        }).then();
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id);
    }
}
