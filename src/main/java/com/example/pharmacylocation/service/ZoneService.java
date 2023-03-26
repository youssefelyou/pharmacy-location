package com.example.pharmacylocation.service;

import com.example.pharmacylocation.bean.Garde;
import com.example.pharmacylocation.bean.Ville;
import com.example.pharmacylocation.bean.Zone;
import com.example.pharmacylocation.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ZoneService {
    
    @Autowired
    private ZoneRepository zoneRepository;

    public Zone findById(int id) {
        return zoneRepository.findById(id);
    }

    public List<Zone> findAll() {
        return zoneRepository.findAll();
    }

    public Zone save(Zone zone) {
        return zoneRepository.save(zone);
    }

    @Transactional
    public void deleteById(Integer integer) {
        zoneRepository.deleteById(integer);
    }
}
