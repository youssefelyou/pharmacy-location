package com.example.pharmacylocation.bean;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToOne
    private Ville ville;

    @OneToMany(mappedBy = "zone")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Pharmacie> pharmacieList;

    public Zone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
