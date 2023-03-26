package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Garde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardeRepository extends JpaRepository<Garde,Integer> {

    Garde findById(int id);
}
