package com.guru.sishyan.repository;

import com.guru.sishyan.models.Hub;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HubRepository extends MongoRepository<Hub,String> {
}
