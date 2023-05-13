package com.example.pharmacylocation.controller;

import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.bean.Ville;
import com.example.pharmacylocation.bean.Zone;
import com.example.pharmacylocation.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/villes")
@CrossOrigin
public class VilleController {

    @Autowired
    private VilleService villeService;

    @GetMapping("/id/{id}")
    public Ville findById(@PathVariable int id) {
        return villeService.findById(id);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<Ville> findByNom(@PathVariable String nom) {
        Ville ville = villeService.findByNom(nom);
        if (ville == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ville);
    }

    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Ville ville) {
        villeService.save(ville);
    }

    @PutMapping("/{id}")
    public Ville updateCity(@PathVariable int id, @RequestBody Ville ville) {
        Ville existingCity = villeService.findById(id);
        if (existingCity != null) {
            existingCity.setNom(ville.getNom());
            return villeService.save(existingCity);
        }
        return null;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        villeService.deleteById(id);
    }

    @GetMapping("/ville/zones/{nom}")
    public List<Zone> findZoneByNomVille(@PathVariable String nom) {
        return villeService.findZoneByNomVille(nom);
    }

    @GetMapping("/villes/{nomVille}/zones/{nomZone}/pharmacies")
    public List<Pharmacie> findPharmacieByNomVilleAndZone(@PathVariable String nomVille, @PathVariable String nomZone) throws Exception {
        return villeService.findPharmacieByNomVilleAndZone(nomVille, nomZone);
    }
}
