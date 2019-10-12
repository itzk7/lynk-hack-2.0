package com.guru.sishyan.controller;


import com.guru.sishyan.models.Hub;
import com.guru.sishyan.models.Request;
import com.guru.sishyan.models.RequestType;
import com.guru.sishyan.repository.HubRepository;
import com.guru.sishyan.service.HubService;
import com.guru.sishyan.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/hub")
public class HubController {

//    @Autowired
//    RequestService requestService;
//
//    @Autowired
//    HubService hubService;
//
//    @PostMapping("/help")
//    public void helpRequestHandler(@RequestBody Request request) {
//        request.setRequestType(RequestType.EMERGENCY);
//        Hub hub = hubService.getNearestHubForEmergencyRequest();
//        saveRequest(request, hub);
//    }
//
//    @PostMapping("/demand")
//    public void demandRequestHandler(@RequestBody Request request) {
//        request.setRequestType(RequestType.DEMAND);
//        Hub hub = hubService.getNearestHubForDemandRequest();
//        saveRequest(request, hub);
//    }
//
//    @PostMapping("/supply")
//    public void supplyRequestHandler(@RequestBody Request request) {
//        request.setRequestType(RequestType.RESOURCE_PROVIDER);
//        Hub hub = hubService.getNearestHubForSupplyRequest();
//        saveRequest(request, hub);
//    }
//
//    private void saveRequest(Request request, Hub hub) {
//        request.setHub(hub);
//        requestService.save(request);
//    }

    @Autowired
    HubRepository hubRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Hub> addHub(@RequestBody Hub hub) {
        Hub addedHub = hubRepository.save(hub);
        return ok(addedHub);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Hub>> getHub(){
        return ok(hubRepository.findAll());
    }
}
