package com.example.pharmacylocation.controller;


import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.repository.PharmacieRepository;
import com.example.pharmacylocation.service.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacies")
@CrossOrigin
public class PharmacieController {

    @Autowired
    private PharmacieService pharmacieService;

    @GetMapping("/{id}")
    public Pharmacie findById(@PathVariable int id) {
        return pharmacieService.findById(id);
    }

    @GetMapping("/")
    public List<Pharmacie> findAll() {
        return pharmacieService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Pharmacie pharmacie) {
        pharmacieService.save(pharmacie);
    }

    @DeleteMapping("/delete/{integer}")
    public void deleteById(@PathVariable int integer) {
        pharmacieService.deleteById(integer);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Pharmacie pharmacie) {
        pharmacieService.update(id, pharmacie);
    }

    @GetMapping("/ville/{ville}/zone/{zone}/period/{period}")
    public List<Pharmacie> findPharmacyAvailableZonePer(@PathVariable String ville,@PathVariable String zone,@PathVariable String period) {
        return pharmacieService.findPharmacyAvailableZonePer(ville, zone, period);
    }

}
