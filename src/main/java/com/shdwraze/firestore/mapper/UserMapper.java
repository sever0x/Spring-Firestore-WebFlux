package com.shdwraze.firestore.mapper;

import com.shdwraze.firestore.model.entity.User;
import com.shdwraze.firestore.model.request.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.firstName())
                .lastName(userDTO.lastName())
                .age(userDTO.age())
                .homeAddress(userDTO.address())
                .build();
    }
}
