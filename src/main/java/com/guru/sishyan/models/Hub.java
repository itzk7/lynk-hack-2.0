package com.guru.sishyan.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Hub extends User {
    String location;
    Map<String, Integer> resourceDetails;
    Coordinate coordinate;
}
