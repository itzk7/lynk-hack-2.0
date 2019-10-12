package com.guru.sishyan.controller;

import com.guru.sishyan.models.Hub;
import com.guru.sishyan.models.Place;
import com.guru.sishyan.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceController {
    @Autowired
    PlaceRepository placeRepository;

    @RequestMapping(value= "place/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addPlace(@RequestBody Place request){
        placeRepository.save(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value= "place/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity listAll(){
        List<Place> places = placeRepository.findAll();
        return ResponseEntity.ok(places);
    }

}
