package com.guru.sishyan.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
@Setter
@Getter
public class Supply {
    @Id
    String id;
    String name;
    Coordinate geoLocation;
    String address;
    Integer numberOfPeople;
    Map<String, Integer> resourceDetails;
    String phoneNumber;
}
