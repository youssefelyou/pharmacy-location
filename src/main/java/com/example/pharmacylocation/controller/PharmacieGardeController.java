package com.example.pharmacylocation.controller;

import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.bean.PharmacieGarde;
import com.example.pharmacylocation.bean.PharmacieGardePK;
import com.example.pharmacylocation.service.PharmacieGardeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Propagation;
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



    public Optional<PharmacieGarde> findById(PharmacieGardePK pharmacieGardePK) {
        return pharmacieGardeService.findById(pharmacieGardePK);
    }

    @GetMapping("/{datedebut}/idpharmacie/{idpharmacie}/idgarde/{idgarde}")
    public PharmacieGarde findByDateDebut(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedebut, @PathVariable int idpharmacie,@PathVariable int idgarde) {
        return pharmacieGardeService.findByDateDebut(datedebut, idpharmacie, idgarde);
    }

    @DeleteMapping("/{datedebut}/idpharmacie/{idpharmacie}/idgarde/{idgarde}")
    @Transactional
    public void deleteByDateDebut(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedebut, @PathVariable int idpharmacie,@PathVariable int idgarde) {
        pharmacieGardeService.deleteByDateDebut(datedebut, idpharmacie, idgarde);
    }


}
