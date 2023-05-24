package com.example.pharmacylocation.service;


import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PharmacieService {
    
    @Autowired
    private PharmacieRepository pharmacieRepository;

    public Pharmacie findById(int id) {
        return pharmacieRepository.findById(id);
    }

    public Pharmacie save(Pharmacie pharmacie) {
        return pharmacieRepository.save(pharmacie);
    }

    @Transactional
    public void deleteById(Integer integer) {
        pharmacieRepository.deleteById(integer);
    }

    public List<Pharmacie> findAll() {
        return pharmacieRepository.findAll();
    }

    public void update(Integer id,Pharmacie pharmacieinfo) {
        Pharmacie pharmacie=pharmacieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("pharmacie not found with id " + id));
        pharmacie.setAddresse(pharmacieinfo.getAddresse());
        pharmacie.setNom(pharmacieinfo.getNom());
        pharmacie.setZone(pharmacieinfo.getZone());
        pharmacie.setLatitude(pharmacieinfo.getLatitude());
        pharmacie.setLongitude(pharmacieinfo.getLongitude());
        pharmacie.setPhoto(pharmacieinfo.getPhoto());
        pharmacieRepository.save(pharmacie);
    }
}
