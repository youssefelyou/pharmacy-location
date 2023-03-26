package com.example.pharmacylocation.service;

import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.bean.Ville;
import com.example.pharmacylocation.bean.Zone;
import com.example.pharmacylocation.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {

    @Autowired
    private VilleRepository villeRepository;

    public Ville findById(int id) {
        return villeRepository.findById(id);
    }

    public Ville findByNom(String nom) {
        return villeRepository.findByNom(nom);
    }

    public List<Ville> findAll() {
        return villeRepository.findAll();
    }

    public Ville save(Ville ville) {
        return villeRepository.save(ville);
    }

    public void deleteById(int id) {
        villeRepository.deleteById(id);
    }

    public List<Zone> findZoneByNomVille(String nom){
        Ville v = findByNom(nom);
        return v.getZones();
    }

    public List<Pharmacie> findPharmacieByNomVilleAndZone(String nomVille, String nomZone) throws Exception {
        Ville ville = findByNom(nomVille);
        if (ville.getZones().stream().anyMatch(zone -> zone.getNom().equalsIgnoreCase(nomZone))) {
            return ville.getZones().stream().filter(zone -> zone.getNom().equalsIgnoreCase(nomZone)).findAny().get().getPharmacieList();
        } else {
            throw new Exception("No pharmacies");
        }
    }

}
