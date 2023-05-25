package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie,Integer> {
    Pharmacie findById(int id);

    @Query("SELECT p FROM Pharmacie p JOIN p.zone z JOIN z.ville v JOIN p.pharmacieGardeList pg WHERE v.nom = :ville AND z.nom = :zone AND pg.garde.type = :period ")
    List<Pharmacie> findPharmacyAvailableZonePer(@Param("ville") String ville, @Param("zone") String zone, @Param("period") String period);

}
