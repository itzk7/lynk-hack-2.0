package com.guru.sishyan.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SupplyDemandListener {
    @KafkaListener(topics = "supply-demand", groupId = "group_id")
    public void getMessage(String msg) {
        System.out.println(msg);
    }
}
