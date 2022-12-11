package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@IdClass(BoutiqueproduitPK.class)
public class Boutiqueproduit {
    private Integer nbrUnitesDisponible;
    private int idBou;
    private String refProd;
    private Boutique boutiqueByIdBou;
    private Produit produitByRefProd;

    public Boutiqueproduit(Integer nbrUnitesDisponible, int idBou, String refProd, Boutique boutiqueByIdBou, Produit produitByRefProd) {
        super();
        this.nbrUnitesDisponible = nbrUnitesDisponible;
        this.idBou = idBou;
        this.refProd = refProd;
        this.boutiqueByIdBou = boutiqueByIdBou;
        this.produitByRefProd = produitByRefProd;
    }
    public Boutiqueproduit(){

    }

    @Basic
    @Column(name = "nbr_unites_disponible")
    public Integer getNbrUnitesDisponible() {
        return nbrUnitesDisponible;
    }

    public void setNbrUnitesDisponible(Integer nbrUnitesDisponible) {
        this.nbrUnitesDisponible = nbrUnitesDisponible;
    }

    @Id
    @Column(name = "id_bou")
    public int getIdBou() {
        return idBou;
    }

    public void setIdBou(int idBou) {
        this.idBou = idBou;
    }

    @Id
    @Column(name = "ref_prod")
    public String getRefProd() {
        return refProd;
    }

    public void setRefProd(String refProd) {
        this.refProd = refProd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boutiqueproduit that = (Boutiqueproduit) o;

        if (idBou != that.idBou) return false;
        if (nbrUnitesDisponible != null ? !nbrUnitesDisponible.equals(that.nbrUnitesDisponible) : that.nbrUnitesDisponible != null)
            return false;
        if (refProd != null ? !refProd.equals(that.refProd) : that.refProd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nbrUnitesDisponible != null ? nbrUnitesDisponible.hashCode() : 0;
        result = 31 * result + idBou;
        result = 31 * result + (refProd != null ? refProd.hashCode() : 0);
        return result;
    }
    @JsonBackReference(value = "idBouBoutiqueProduit")
    @ManyToOne
    @MapsId("id_boutique")
    @JoinColumn(name = "id_bou", referencedColumnName = "id_boutique", nullable = false)
    public Boutique getBoutiqueByIdBou() {
        return boutiqueByIdBou;
    }

    public void setBoutiqueByIdBou(Boutique boutiqueByIdBou) {
        this.boutiqueByIdBou = boutiqueByIdBou;
    }
    @JsonBackReference(value = "refProdBoutiqueProduit")
    @ManyToOne
    @MapsId("reference_produit")
    @JoinColumn(name = "ref_prod", referencedColumnName = "reference_produit", nullable = false)
    public Produit getProduitByRefProd() {
        return produitByRefProd;
    }

    public void setProduitByRefProd(Produit produitByRefProd) {
        this.produitByRefProd = produitByRefProd;
    }

}
