package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {

    List<Zone> findByVilleId(int cityId);



}
