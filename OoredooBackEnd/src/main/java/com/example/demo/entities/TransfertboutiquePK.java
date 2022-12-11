package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TransfertboutiquePK implements Serializable {
    private String refTran;
    private int idBouEmetteur;
    private int idBouDestinataire;

    @Column(name = "ref_tran")
    @Id
    public String getRefTran() {
        return refTran;
    }

    public void setRefTran(String refTran) {
        this.refTran = refTran;
    }

    @Column(name = "id_bou_emetteur")
    @Id
    public int getIdBouEmetteur() {
        return idBouEmetteur;
    }

    public void setIdBouEmetteur(int idBouEmetteur) {
        this.idBouEmetteur = idBouEmetteur;
    }

    @Column(name = "id_bou_destinataire")
    @Id
    public int getIdBouDestinataire() {
        return idBouDestinataire;
    }

    public void setIdBouDestinataire(int idBouDestinataire) {
        this.idBouDestinataire = idBouDestinataire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransfertboutiquePK that = (TransfertboutiquePK) o;

        if (idBouEmetteur != that.idBouEmetteur) return false;
        if (idBouDestinataire != that.idBouDestinataire) return false;
        if (refTran != null ? !refTran.equals(that.refTran) : that.refTran != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = refTran != null ? refTran.hashCode() : 0;
        result = 31 * result + idBouEmetteur;
        result = 31 * result + idBouDestinataire;
        return result;
    }
}
