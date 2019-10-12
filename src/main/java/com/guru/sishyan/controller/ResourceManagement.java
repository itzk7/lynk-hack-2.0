package com.guru.sishyan.controller;

import com.guru.sishyan.models.TestModel;
import com.guru.sishyan.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ResourceManagement {

    @Autowired
    ResourceRepository repository;

    @RequestMapping(value = "/test", produces = "application/json")
    public ResponseEntity<TestModel> addVolunteer(){
        TestModel tm = new TestModel();
        tm.setId("1");

        TestModel res = repository.save(tm);
        return ok(res);
    }
}
