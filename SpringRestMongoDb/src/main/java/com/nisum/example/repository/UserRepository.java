package com.nisum.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.nisum.example.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
