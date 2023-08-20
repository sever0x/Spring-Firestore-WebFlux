package com.shdwraze.firestore.model.request;

import com.shdwraze.firestore.model.entity.Address;
import com.shdwraze.firestore.model.entity.Car;
import lombok.Builder;

import java.util.List;

@Builder
public record UserDTO(

        String firstName,

        String lastName,

        int age,

        Address address,

        List<Car> cars
) {
}
