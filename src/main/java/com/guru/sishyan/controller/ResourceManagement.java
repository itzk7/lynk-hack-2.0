package com.guru.sishyan.controller;

import com.guru.sishyan.models.Volunteer;
import com.guru.sishyan.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ResourceManagement {

    @Autowired
    ResourceRepository repository;

    @RequestMapping(value= "/addVolunteer", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addVolunteer(@RequestBody Volunteer volunteer){
        repository.save(volunteer);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
