package com.guru.sishyan.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Document
public class Volunteer implements Serializable {
    @Id
    String id;

    @NotNull
    String Location;

    @NotNull
    String[] phoneNumbers;

    @Range(min = 18)
    String age;
}
