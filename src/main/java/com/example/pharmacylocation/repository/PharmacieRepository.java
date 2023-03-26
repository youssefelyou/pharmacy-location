package com.example.pharmacylocation.repository;

import com.example.pharmacylocation.bean.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie,Integer> {
    Pharmacie findById(int id);
}
