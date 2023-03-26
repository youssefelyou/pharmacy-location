package com.example.pharmacylocation.service;

import com.example.pharmacylocation.bean.Garde;
import com.example.pharmacylocation.bean.Ville;
import com.example.pharmacylocation.repository.GardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GardeService {

    @Autowired
    private GardeRepository gardeRepository;

    public Garde findById(int id) {
        return gardeRepository.findById(id);
    }

    public List<Garde> findAll() {
        return gardeRepository.findAll();
    }

    public Garde save(Garde garde) {
        return gardeRepository.save(garde);
    }

    @Transactional
    public void deleteById(Integer integer) {
        gardeRepository.deleteById(integer);
    }
}
