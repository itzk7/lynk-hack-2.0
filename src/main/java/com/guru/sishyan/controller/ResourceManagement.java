package com.guru.sishyan.controller;

import com.guru.sishyan.models.Coordinate;
import com.guru.sishyan.models.User;
import com.guru.sishyan.models.Hub;
import com.guru.sishyan.models.Volunteer;
import com.guru.sishyan.repository.HubRepository;
import com.guru.sishyan.repository.VolunteerRepository;
import com.guru.sishyan.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class ResourceManagement {

    @Autowired
    HubRepository hubRepository;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    VolunteerRepository volunteerRepository;

    @RequestMapping(value= "/addVolunteer", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addVolunteer(@RequestBody Volunteer volunteer) {
        volunteer.setRole("VOLUNTEER");
        Double[] latlon = GeoService.getLatLong(volunteer.getLocation());
        GeoJsonPoint coordinate = new GeoJsonPoint(latlon[0],latlon[1]);
        volunteer.setCoordinate(coordinate);
        volunteerRepository.save(volunteer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> validateUser(@RequestBody User user) {
        User validatedUser = volunteerRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return ok(validatedUser);
    }


    @RequestMapping(value = "/updateStatus", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity updateVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer validatedVolunteer = volunteerRepository.findByUsernameAndPasswordAndRole(volunteer.getUsername(),volunteer.getPassword(),volunteer.getRole());
        validatedVolunteer.setIsAvailable(volunteer.getIsAvailable());
        kafkaTemplate.send("supply-demand","User is online");
        return ok(volunteerRepository.save(validatedVolunteer));
    }

}
