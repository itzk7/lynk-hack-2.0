package com.guru.sishyan.repository;

import com.guru.sishyan.models.Supply;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplyRepository  extends MongoRepository<Supply, String> {
}
