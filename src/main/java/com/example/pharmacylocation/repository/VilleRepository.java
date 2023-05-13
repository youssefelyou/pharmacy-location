package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Integer> {

    Ville findById(int id);

    @Query("SELECT v FROM Ville v WHERE v.nom = :nom")
    Ville findByNom(String nom);

}
