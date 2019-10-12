package com.guru.sishyan.repository;

import com.guru.sishyan.models.Volunteer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourceRepository extends MongoRepository<Volunteer,String> {
    
}
