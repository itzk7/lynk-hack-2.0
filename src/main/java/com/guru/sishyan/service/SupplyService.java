package com.guru.sishyan.service;

import com.guru.sishyan.models.Supply;
import com.guru.sishyan.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
