package com.example.pharmacylocation.controller;

import com.example.pharmacylocation.bean.Zone;
import com.example.pharmacylocation.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/zones")
@CrossOrigin
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @GetMapping("/{id}")
    public Zone getZoneById(@PathVariable int id) {
        return zoneService.getZoneById(id);
    }

    @GetMapping("/villeid/{cityId}")
    public List<Zone> getZonesByVilleId(@PathVariable int cityId) {
        return zoneService.getZonesByVilleId(cityId);
    }

    @GetMapping("")
    public List<Zone> findAll() {
        return zoneService.findAll();
    }

    @PostMapping("/save")
    public Zone save(@RequestBody Zone zone)  {
        return zoneService.save(zone);
    }

    @DeleteMapping("/{id}")
    public void deleteZone(@PathVariable int id) {
        zoneService.deleteZone(id);
    }

    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable int id, @RequestBody Zone zone) {
        zone.setId(id);
        return zoneService.save(zone);
    }

    @GetMapping("/ville/{nom}")
    public List<Zone> getAllZone(@PathVariable String nom){
        return zoneService.findAllByVille(nom);
    }
}