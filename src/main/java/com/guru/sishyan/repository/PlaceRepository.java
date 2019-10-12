package com.guru.sishyan.repository;

import com.guru.sishyan.models.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<Place,String> {
}
