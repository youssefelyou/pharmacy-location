package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {

    List<Zone> findByVilleId(int cityId);

    @Query("select z from Zone z where z.ville.nom= :nom order by z.nom")
    List<Zone> findZoneByVille(@Param("nom") String nom);


}
