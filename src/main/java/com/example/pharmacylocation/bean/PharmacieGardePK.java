package com.example.pharmacylocation.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class PharmacieGardePK  implements Serializable {

private int pharmacie;
private int garde;


@JsonFormat(pattern = "dd/MM/yyyy")
private Date dateDebut;

    public PharmacieGardePK() {
    }

    public int getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(int pharmacie) {
        this.pharmacie = pharmacie;
    }

    public int getGarde() {
        return garde;
    }

    public void setGarde(int garde) {
        this.garde = garde;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
}
