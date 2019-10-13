package com.guru.sishyan.controller;

import com.guru.sishyan.models.*;
import com.guru.sishyan.repository.HubRepository;
import com.guru.sishyan.repository.SupplyRepository;
import com.guru.sishyan.repository.VolunteerRepository;
import com.guru.sishyan.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class ResourceManagement {

    @Autowired
    HubRepository hubRepository;

    @Autowired
    SupplyRepository supplyRepository;

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
    public ResponseEntity<User> validateUser(@RequestBody User user, HttpServletResponse httpServletResponse) {
        User validatedUser = volunteerRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(validatedUser != null) {
            Cookie cookie = new Cookie("username", validatedUser.getUsername());
            //add cookie to response
            httpServletResponse.addCookie(cookie);
        }
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

    @RequestMapping(value = "/volunteerdetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<VolunteerDetails> userDetails(@RequestParam String username) {
        Volunteer volunteer = volunteerRepository.findByUsername(username);
        Optional<Supply> supply = Optional.empty();
        if(volunteer.getSupplyId() != null)
            supply = supplyRepository.findById( volunteer.getSupplyId() );

        VolunteerDetails details = new VolunteerDetails();
        details.setUserName( volunteer.getUsername() );
        if( supply.isPresent() ) {
            details.setHubLocation(supply.get().getAddress());
        }

        details.setIsActive( volunteer.getIsAvailable() );
        return ok(details);
    }

}
