package com.guru.sishyan.controller;

import com.guru.sishyan.models.User;
import com.guru.sishyan.models.Hub;
import com.guru.sishyan.models.Volunteer;
import com.guru.sishyan.repository.HubRepository;
import com.guru.sishyan.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class ResourceManagement {

    @Autowired
    HubRepository hubRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    @RequestMapping(value= "/addVolunteer", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addVolunteer(@RequestBody Volunteer volunteer){
        volunteer.setRole("VOLUNTEER");
        volunteerRepository.save(volunteer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> validateUser(@RequestBody User user) {
        User validatedUser = volunteerRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return ok(validatedUser);
    }

    @RequestMapping(value= "hub/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createHub(@RequestBody Hub hub){
        hub.setRole("HUB");
        hubRepository.save(hub);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity updateVolunteer(@RequestBody Volunteer volunteer){
        Volunteer validatedVolunteer = volunteerRepository.findByUsernameAndPasswordAndRole(volunteer.getUsername(),volunteer.getPassword(),volunteer.getRole());
        validatedVolunteer.setIsAvailable(volunteer.getIsAvailable());
        return ok(volunteerRepository.save(validatedVolunteer));
    }

    @RequestMapping(value= "hub/update", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity updateHub(@RequestBody Hub hub){
        Hub fetchedHub =  hubRepository.findByUsername( hub.getUsername() );
        fetchedHub.setResourceDetails( hub.getResourceDetails() );
        hubRepository.save(fetchedHub);
        return new ResponseEntity(HttpStatus.OK);
    }
}
