package com.guru.sishyan.repository;

import com.guru.sishyan.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourceRepository extends MongoRepository<User,String> {
    public User findByUsernameAndPassword(String username, String password);
}
