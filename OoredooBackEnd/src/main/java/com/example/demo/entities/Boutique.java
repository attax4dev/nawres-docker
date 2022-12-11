    package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Boutique {
    private int idBoutique;
    private String localisation;
    private String nomBoutique;
    private Long numTelBoutique;
    private Collection<Boutiqueproduit> boutiqueproduitsByIdBoutique;
    private Collection<Transfertboutique> transfertboutiquesByIdBoutique;
   private Collection<Transfertboutique> transfertboutiquesByIdBoutique_0;
    private Collection<Alert> alertsByIdBoutique;

    public Boutique(int idBoutique, String localisation, String nomBoutique, Long numTelBoutique) {
        super();
        this.idBoutique = idBoutique;
        this.localisation = localisation;
        this.nomBoutique = nomBoutique;
        this.numTelBoutique = numTelBoutique;
    }

    public Boutique(){

    }

    @Id
    @Column(name = "id_boutique")
    public int getIdBoutique() {
        return idBoutique;
    }

    public void setIdBoutique(int idBoutique) {
        this.idBoutique = idBoutique;
    }

    @Basic
    @Column(name = "localisation")
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Basic
    @Column(name = "nom_boutique")
    public String getNomBoutique() {
        return nomBoutique;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    @Basic
    @Column(name = "num_tel_boutique")
    public Long getNumTelBoutique() {
        return numTelBoutique;
    }

    public void setNumTelBoutique(Long numTelBoutique) {
        this.numTelBoutique = numTelBoutique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boutique boutique = (Boutique) o;

        if (idBoutique != boutique.idBoutique) return false;
        if (localisation != null ? !localisation.equals(boutique.localisation) : boutique.localisation != null)
            return false;
        if (nomBoutique != null ? !nomBoutique.equals(boutique.nomBoutique) : boutique.nomBoutique != null)
            return false;
        if (numTelBoutique != null ? !numTelBoutique.equals(boutique.numTelBoutique) : boutique.numTelBoutique != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBoutique;
        result = 31 * result + (localisation != null ? localisation.hashCode() : 0);
        result = 31 * result + (nomBoutique != null ? nomBoutique.hashCode() : 0);
        result = 31 * result + (numTelBoutique != null ? numTelBoutique.hashCode() : 0);
        return result;
    }

    @JsonManagedReference(value = "idBouBoutiqueProduit")
    @OneToMany(mappedBy = "boutiqueByIdBou")
    public Collection<Boutiqueproduit> getBoutiqueproduitsByIdBoutique() {
        return boutiqueproduitsByIdBoutique;
    }

    public void setBoutiqueproduitsByIdBoutique(Collection<Boutiqueproduit> boutiqueproduitsByIdBoutique) {
        this.boutiqueproduitsByIdBoutique = boutiqueproduitsByIdBoutique;
    }

    @JsonManagedReference(value = "BoutiqueIDemetteur")
    @OneToMany(mappedBy = "boutiqueByIdBouEmetteur")
    public Collection<Transfertboutique> getTransfertboutiquesByIdBoutique() {
        return transfertboutiquesByIdBoutique;
    }

    public void setTransfertboutiquesByIdBoutique(Collection<Transfertboutique> transfertboutiquesByIdBoutique) {
        this.transfertboutiquesByIdBoutique = transfertboutiquesByIdBoutique;
    }

    @JsonManagedReference(value = "BoutiqueIDdestinataire")
    @OneToMany(mappedBy = "boutiqueByIdBouDestinataire")
    public Collection<Transfertboutique> getTransfertboutiquesByIdBoutique_0(){
        return transfertboutiquesByIdBoutique_0 ; }

    public void setTransfertboutiquesByIdBoutique_0(Collection<Transfertboutique> transfertboutiquesByIdBoutique_0) {
        this.transfertboutiquesByIdBoutique_0 = transfertboutiquesByIdBoutique_0;
    }
    @JsonManagedReference(value = "boutiqueAlert")
    @OneToMany(mappedBy = "boutiqueByIdBoutique")
    public Collection<Alert> getAlertsByIdBoutique() {
        return alertsByIdBoutique;
    }

    public void setAlertsByIdBoutique(Collection<Alert> alertsByIdBoutique) {
        this.alertsByIdBoutique = alertsByIdBoutique;
    }
}
