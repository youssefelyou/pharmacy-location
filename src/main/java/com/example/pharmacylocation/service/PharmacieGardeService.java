package com.example.pharmacylocation.service;


import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.bean.PharmacieGarde;
import com.example.pharmacylocation.bean.PharmacieGardePK;
import com.example.pharmacylocation.repository.PharmacieGardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PharmacieGardeService {

    @Autowired
    private PharmacieGardeRepository pharmacieGardeRepository;

    public List<Pharmacie> findDisponiblePharmacie(Long zoneId, Date date) {
        return pharmacieGardeRepository.findDisponiblePharmacie(zoneId, date);
    }

    public List<PharmacieGarde> findAll() {
        return pharmacieGardeRepository.findAll();
    }

    public PharmacieGarde save(PharmacieGarde entity) {
        return pharmacieGardeRepository.save(entity);
    }

    public Optional<PharmacieGarde> findById(PharmacieGardePK pharmacieGardePK) {
        return pharmacieGardeRepository.findById(pharmacieGardePK);
    }

    public void deleteById(PharmacieGardePK pharmacieGardePK) {
        pharmacieGardeRepository.deleteById(pharmacieGardePK);
    }
}
