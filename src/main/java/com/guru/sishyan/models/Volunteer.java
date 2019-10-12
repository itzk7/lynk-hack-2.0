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
public class Volunteer extends User implements Serializable {

    @NotNull
    String Location;

    @NotNull
    String[] phoneNumbers;

    Boolean isAvailable = true;

    String role = "VOLUNTEER";

    @Range(min = 18)
    String age;
}
