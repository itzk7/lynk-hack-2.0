package com.guru.sishyan.repository;

import com.guru.sishyan.models.TestModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourceRepository extends MongoRepository<TestModel,String> {

}
