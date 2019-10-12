package com.guru.sishyan.controller;


import com.guru.sishyan.models.Hub;
import com.guru.sishyan.models.Request;
import com.guru.sishyan.models.RequestType;
import com.guru.sishyan.service.HubService;
import com.guru.sishyan.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hub")
public class HubController {

    @Autowired
    RequestService requestService;

    @Autowired
    HubService hubService;

    @PostMapping("/help")
    public void helpRequestHandler(@RequestBody Request request) {
        request.setRequestType(RequestType.EMERGENCY);
        Hub hub = hubService.getNearestHubForEmergencyRequest();
        saveRequest(request, hub);
    }

    @PostMapping("/demand")
    public void demandRequestHandler(@RequestBody Request request) {
        request.setRequestType(RequestType.DEMAND);
        Hub hub = hubService.getNearestHubForDemandRequest();
        saveRequest(request, hub);
    }

    @PostMapping("/supply")
    public void supplyRequestHandler(@RequestBody Request request) {
        request.setRequestType(RequestType.RESOURCE_PROVIDER);
        Hub hub = hubService.getNearestHubForSupplyRequest();
        saveRequest(request, hub);
    }

    private void saveRequest(Request request, Hub hub) {
        request.setHub(hub);
        requestService.save(request);
    }
}
