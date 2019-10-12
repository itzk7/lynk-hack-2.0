package com.guru.sishyan.controller;

import com.guru.sishyan.models.Supply;
import com.guru.sishyan.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/supply")
public class SupplyController {
    @Autowired
    SupplyService supplyService;

    @PostMapping("/")
    public void add(@RequestBody Supply supply) {
        supplyService.add(supply);
    }

    @GetMapping("/all")
    public List<Supply> getAll() {
        return supplyService.getAll();
    }
}
