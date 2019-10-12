package com.guru.sishyan.service;

import com.guru.sishyan.models.Supply;
import com.guru.sishyan.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SupplyService {
    @Autowired
    SupplyRepository supplyRepository;

    public void add(Supply supply) {
        supplyRepository.save(supply);
    }

    public List<Supply> getAll() {
        return supplyRepository.findAll();
    }

    public List<Supply> getUnProcessedSupplies() {
        return supplyRepository.findByIsProcessed(false);
    }

//    @Scheduled(fixedDelay = 5000)
//    public void demoServiceMethod()
//    {
//        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
//    }

}
