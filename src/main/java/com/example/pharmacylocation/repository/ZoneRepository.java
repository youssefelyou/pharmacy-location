package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {

    Zone findById(int id);


}
