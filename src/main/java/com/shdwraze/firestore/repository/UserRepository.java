package com.shdwraze.firestore.repository;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import com.shdwraze.firestore.model.entity.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends FirestoreReactiveRepository<User> {

    Flux<User> findByHomeAddress_City(String city);
}
