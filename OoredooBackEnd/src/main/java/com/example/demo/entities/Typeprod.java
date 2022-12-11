package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Typeprod {
    private int idType;
    private String description;
    private Collection<Produit> produitsByIdType;
    private Collection<Alert> alertsByIdType;

    @Id
    @Column(name = "id_type")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typeprod typeprod = (Typeprod) o;

        if (idType != typeprod.idType) return false;
        if (description != null ? !description.equals(typeprod.description) : typeprod.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idType;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @JsonManagedReference(value = "typeProduit")
    @OneToMany(mappedBy = "typeprodByType")
    public Collection<Produit> getProduitsByIdType() {
        return produitsByIdType
                ;
    }

    public void setProduitsByIdType(Collection<Produit> produitsByIdType) {
        this.produitsByIdType = produitsByIdType;
    }
    @JsonManagedReference(value = "AlertType")
    @OneToMany(mappedBy = "typeprodByType")

    public Collection<Alert> getAlertsByIdType() {
        return alertsByIdType;
    }

    public void setAlertsByIdType(Collection<Alert> alertsByIdType) {
        this.alertsByIdType = alertsByIdType;
    }

}
