package com.example.pharmacylocation.controller;

import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.bean.PharmacieGarde;
import com.example.pharmacylocation.bean.PharmacieGardePK;
import com.example.pharmacylocation.service.PharmacieGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pharmaciegarde")
public class PharmacieGardeController {


    @Autowired
    private PharmacieGardeService pharmacieGardeService;

    @GetMapping("/pharmacies/zone/{zoneId}/{date}")
    public List<Pharmacie> findDisponiblePharmacie(@PathVariable Long zoneId, @PathVariable  Date date) {
        return pharmacieGardeService.findDisponiblePharmacie(zoneId, date);
    }

    @GetMapping("/")
    public List<PharmacieGarde> findAll() {
        return pharmacieGardeService.findAll();
    }


    @PostMapping("/save")
    public PharmacieGarde save(@RequestBody PharmacieGarde entity) {
        return pharmacieGardeService.save(entity);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestBody PharmacieGardePK pharmacieGardePK) {
        pharmacieGardeService.deleteById(pharmacieGardePK);
    }
}
