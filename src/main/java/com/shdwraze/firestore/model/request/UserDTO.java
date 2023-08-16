package com.shdwraze.firestore.model.request;

import com.shdwraze.firestore.model.entity.Address;
import lombok.Builder;

@Builder
public record UserDTO(

        String firstName,

        String lastName,

        int age,

        Address address
) {
}
