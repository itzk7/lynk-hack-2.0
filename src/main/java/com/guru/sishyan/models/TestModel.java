package com.guru.sishyan.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
public class TestModel implements Serializable {
    @Id
    public String id;
}
