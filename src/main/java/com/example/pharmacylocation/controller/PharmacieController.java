package com.example.pharmacylocation.controller;


import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.repository.PharmacieRepository;
import com.example.pharmacylocation.service.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacieController {

    @Autowired
    private PharmacieService pharmacieService;

    @GetMapping("/{id}")
    public Pharmacie findById(@PathVariable int id) {
        return pharmacieService.findById(id);
    }

    @GetMapping("/pharmacies")
    public List<Pharmacie> findAll() {
        return pharmacieService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Pharmacie pharmacie) {
        pharmacieService.save(pharmacie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        pharmacieService.deleteById(id);
    }

}
