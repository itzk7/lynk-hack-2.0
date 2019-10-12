package com.guru.sishyan.repository;

import com.guru.sishyan.models.User;
import com.guru.sishyan.models.Volunteer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VolunteerRepository extends MongoRepository<Volunteer,String> {
    public Volunteer findByUsernameAndPasswordAndRole(String username, String password,String role);
    public User findByUsernameAndPassword(String username,String password);
}