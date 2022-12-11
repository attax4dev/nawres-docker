package com.example.demo.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Commande {
    private Date dateCommande;
    private int idCommande;
    private int qteCommande;

    @Basic
    @Column(name = "date_commande")
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Id
    @Column(name = "id_commande")
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (idCommande != commande.idCommande) return false;
        if (dateCommande != null ? !dateCommande.equals(commande.dateCommande) : commande.dateCommande != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateCommande != null ? dateCommande.hashCode() : 0;
        result = 31 * result + idCommande;
        return result;
    }

    @Basic
    @Column(name = "QteCommande")
    public int getQteCommande() {
        return qteCommande;
    }
//Test >1
    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
    }
}
