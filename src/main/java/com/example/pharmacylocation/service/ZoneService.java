package com.example.pharmacylocation.service;

import com.example.pharmacylocation.bean.Garde;
import com.example.pharmacylocation.bean.Ville;
import com.example.pharmacylocation.bean.Zone;
import com.example.pharmacylocation.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ZoneService {
    
    @Autowired
    private ZoneRepository zoneRepository;

    public Zone getZoneById(int id) {
        return zoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
    }

    public List<Zone> getZonesByVilleId(int cityId) {
        return zoneRepository.findByVilleId(cityId);
    }

    public List<Zone> findAll() {
        return zoneRepository.findAll();
    }

    public Zone save(Zone zone) {
        return zoneRepository.save(zone);
    }

    public void deleteZone(int id) {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
        zoneRepository.delete(zone);
    }

    public Zone updateZone(int id, Zone zoneDetails) {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
        zone.setNom(zoneDetails.getNom());
        zone.setVille(zoneDetails.getVille());
        return zoneRepository.save(zone);
    }

    public List<Zone> findAllByVille(String nom){

        return zoneRepository.findZoneByVille(nom);
    }
}
