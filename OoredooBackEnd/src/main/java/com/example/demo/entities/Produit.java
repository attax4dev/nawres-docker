package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Produit {
    private String referenceProduit;
    private String libelle;
    private String marque;
    private Double prix;
    private Integer type;
    private Collection<Boutiqueproduit> boutiqueproduitsByReferenceProduit;
    private Typeprod typeprodByType;
    private Integer nbrUnites;

    @Id
    @Column(name = "reference_produit")
    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
    @Column(name = "prix")
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (referenceProduit != null ? !referenceProduit.equals(produit.referenceProduit) : produit.referenceProduit != null)
            return false;
        if (libelle != null ? !libelle.equals(produit.libelle) : produit.libelle != null) return false;
        if (marque != null ? !marque.equals(produit.marque) : produit.marque != null) return false;
        if (prix != null ? !prix.equals(produit.prix) : produit.prix != null) return false;
        if (type != null ? !type.equals(produit.type) : produit.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = referenceProduit != null ? referenceProduit.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @JsonManagedReference(value = "refProdBoutiqueProduit")
    @OneToMany(mappedBy = "produitByRefProd")
    public Collection<Boutiqueproduit> getBoutiqueproduitsByReferenceProduit() {
        return boutiqueproduitsByReferenceProduit;
    }

    public void setBoutiqueproduitsByReferenceProduit(Collection<Boutiqueproduit> boutiqueproduitsByReferenceProduit) {
        this.boutiqueproduitsByReferenceProduit = boutiqueproduitsByReferenceProduit;
    }

    @JsonBackReference(value = "typeProduit")
    @ManyToOne
    @MapsId("idType")
    @JoinColumn(name = "type", referencedColumnName = "id_type")
    public Typeprod getTypeprodByType() {
        return typeprodByType;
    }

    public void setTypeprodByType(Typeprod typeprodByType) {
        this.typeprodByType = typeprodByType;
    }

    @Basic
    @Column(name = "nbr_unites")
    public Integer getNbrUnites() {
        return nbrUnites;
    }

    public void setNbrUnites(Integer nbrUnites) {
        this.nbrUnites = nbrUnites;
    }
}
