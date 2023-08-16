package com.shdwraze.firestore.model.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collectionName = "users")
public class User {

    @DocumentId
    private String id;

    private String firstName;

    private String lastName;

    private int age;

    private Address homeAddress;
}
