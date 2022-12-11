package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Alert {
    private int idAlert;
    private int idBoutique;
    private String marque;
    private  int type;
    private Typeprod typeprodByType;
    private String libelle;
    private Boutique boutiqueByIdBoutique;



    @JsonBackReference(value = "AlertType")
    @MapsId("id_type")
    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id_type", nullable = false)
    public Typeprod getTypeprodByType() {
        return typeprodByType;
    }

    public void setTypeprodByType(Typeprod typeprodByType) {
        this.typeprodByType = typeprodByType;
    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_alert")
    public int getIdAlert() {
        return idAlert;
    }

    public void setIdAlert(int idAlert) {
        this.idAlert = idAlert;
    }

    @Basic
    @Column(name = "id_boutique")
    public int getIdBoutique() {
        return idBoutique;
    }

    public void setIdBoutique(int idBoutique) {
        this.idBoutique = idBoutique;
    }

    @Basic
    @Column(name = "marque")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alert alert = (Alert) o;

        if (libelle != null ? !libelle.equals(alert.libelle) : alert.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return libelle != null ? libelle.hashCode() : 0;
    }

    @JsonBackReference(value = "boutiqueAlert")
    @ManyToOne
    @MapsId("id_boutique")
    @JoinColumn(name = "id_boutique", referencedColumnName = "id_boutique", nullable = false)
    public Boutique getBoutiqueByIdBoutique() {
        return boutiqueByIdBoutique;
    }

    public void setBoutiqueByIdBoutique(Boutique boutiqueByIdBoutique) {
        this.boutiqueByIdBoutique = boutiqueByIdBoutique;
    }
}
