package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Pharmacie;
import com.example.pharmacylocation.bean.PharmacieGarde;
import com.example.pharmacylocation.bean.PharmacieGardePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde, PharmacieGardePK> {

    @Query("SELECT g.pharmacie from PharmacieGarde g where g.pharmacie.zone.id =:zoneId  AND g.pk.dateDebut <=  :dateDonner AND  :dateDonner <= g.dateFin")
    List<Pharmacie> findDisponiblePharmacie(@Param("zoneId") Long zoneId, @Param("dateDonner") Date date);
}
