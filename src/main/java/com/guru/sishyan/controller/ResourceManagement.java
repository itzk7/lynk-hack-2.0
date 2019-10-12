package com.guru.sishyan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ResourceManagement {
    @RequestMapping(value = "/test", produces = "application/json")
    public ResponseEntity<String> addVolunteer(){
        return ok("Hello world !!!!");
    }
}
