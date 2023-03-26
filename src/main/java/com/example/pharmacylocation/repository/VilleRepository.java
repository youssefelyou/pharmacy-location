package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Integer> {

    Ville findById(int id);
    Ville findByNom(String nom);

}
