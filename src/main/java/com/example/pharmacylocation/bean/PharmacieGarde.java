package com.example.pharmacylocation.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PharmacieGarde {

    @EmbeddedId
    private PharmacieGardePK pk;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "pharmacie", insertable = false, updatable = false)
    private Pharmacie pharmacie;
    @ManyToOne
    @JoinColumn(name = "garde", insertable = false, updatable = false)
    private Garde garde;

    public PharmacieGarde() {
    }

    public PharmacieGardePK getPk() {
        return pk;
    }

    public void setPk(PharmacieGardePK pk) {
        this.pk = pk;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
