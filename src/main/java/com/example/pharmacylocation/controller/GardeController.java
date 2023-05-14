package com.example.pharmacylocation.controller;

import com.example.pharmacylocation.bean.Garde;
import com.example.pharmacylocation.service.GardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/garde")
@RestController
public class GardeController {

    @Autowired
    private GardeService gardeService;

    @GetMapping("/{id}")
    public Garde findById(@PathVariable int id) {
        return gardeService.findById(id);
    }
    @GetMapping("/")
    public List<Garde> findAll() {
        return gardeService.findAll();
    }

    @PostMapping("/save")
    public Garde save(@RequestBody Garde garde) {
        return gardeService.save(garde);
    }

    @Transactional
    @DeleteMapping("/{integer}")
    public void deleteById(@PathVariable Integer integer) {
        gardeService.deleteById(integer);
    }
}