package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@IdClass(TransfertboutiquePK.class)
public class Transfertboutique {
    private String refTran;
    private int idBouEmetteur;
    private int idBouDestinataire;
    private Transfert transfertByRefTran;
    private Boutique boutiqueByIdBouEmetteur;
    private Boutique boutiqueByIdBouDestinataire;

    @Id
    @Column(name = "ref_tran")
    public String getRefTran() {
        return refTran;
    }

    public void setRefTran(String refTran) {
        this.refTran = refTran;
    }

    @Id
    @Column(name = "id_bou_emetteur")
    public int getIdBouEmetteur() {
        return idBouEmetteur;
    }

    public void setIdBouEmetteur(int idBouEmetteur) {
        this.idBouEmetteur = idBouEmetteur;
    }

    @Id
    @Column(name = "id_bou_destinataire")
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

        Transfertboutique that = (Transfertboutique) o;

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
    @JsonBackReference(value = "TransfertBoutiqueId")
    @ManyToOne
    @MapsId("reference_transfert")
    @JoinColumn(name = "ref_tran", referencedColumnName = "reference_transfert", nullable = false)
    public Transfert getTransfertByRefTran() {
        return transfertByRefTran;
    }

    public void setTransfertByRefTran(Transfert transfertByRefTran) {
        this.transfertByRefTran = transfertByRefTran;
    }
    @JsonBackReference(value = "BoutiqueIDemetteur")
    @ManyToOne
    @MapsId("id_boutique")
    @JoinColumn(name = "id_bou_emetteur", referencedColumnName = "id_boutique", nullable = false)
    public Boutique getBoutiqueByIdBouEmetteur() {
        return boutiqueByIdBouEmetteur;
    }

    public void setBoutiqueByIdBouEmetteur(Boutique boutiqueByIdBouEmetteur) {
        this.boutiqueByIdBouEmetteur = boutiqueByIdBouEmetteur;
    }
    @JsonBackReference(value = "BoutiqueIDdestinataire")
    @ManyToOne
    @MapsId("id_boutique")
    @JoinColumn(name = "id_bou_destinataire", referencedColumnName = "id_boutique", nullable = false)
    public Boutique getBoutiqueByIdBouDestinataire() {
        return boutiqueByIdBouDestinataire;
    }

    public void setBoutiqueByIdBouDestinataire(Boutique boutiqueByIdBouDestinataire) {
        this.boutiqueByIdBouDestinataire = boutiqueByIdBouDestinataire;
    }
}
