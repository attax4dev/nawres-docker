package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Transfert {
    private String referenceTransfert;
    private Date dateTransfert;
    private Byte statut;
    private Collection<Transfertboutique> transfertboutiquesByReferenceTransfert;
    private Coursier coursierByCinC;
    private String cinC;

    @Id
    @Column(name = "reference_transfert")
    public String getReferenceTransfert() {
        return referenceTransfert;
    }

    public void setReferenceTransfert(String referenceTransfert) {
        this.referenceTransfert = referenceTransfert;
    }

    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_transfert")
    public Date getDateTransfert() {
        return dateTransfert;
    }

    public void setDateTransfert(Date dateTransfert) {
        this.dateTransfert = dateTransfert;
    }

    @Basic
    @Column(name = "statut")
    public Byte getStatut() {
        return statut;
    }

    public void setStatut(Byte statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transfert transfert = (Transfert) o;

        if (referenceTransfert != null ? !referenceTransfert.equals(transfert.referenceTransfert) : transfert.referenceTransfert != null)
            return false;
        if (dateTransfert != null ? !dateTransfert.equals(transfert.dateTransfert) : transfert.dateTransfert != null)
            return false;
        if (statut != null ? !statut.equals(transfert.statut) : transfert.statut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = referenceTransfert != null ? referenceTransfert.hashCode() : 0;
        result = 31 * result + (dateTransfert != null ? dateTransfert.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        return result;
    }
    @JsonManagedReference("TransfertBoutiqueId")
    @OneToMany(mappedBy = "transfertByRefTran")
    public Collection<Transfertboutique> getTransfertboutiquesByReferenceTransfert() {
        return transfertboutiquesByReferenceTransfert;
    }

    public void setTransfertboutiquesByReferenceTransfert(Collection<Transfertboutique> transfertboutiquesByReferenceTransfert) {
        this.transfertboutiquesByReferenceTransfert = transfertboutiquesByReferenceTransfert;
    }
    @JsonBackReference(value = "TrasnfertCoursier")
    @ManyToOne
    @MapsId("cin_coursier")
    @JoinColumn(name = "cin_c", referencedColumnName = "cin_coursier", nullable = false)
    public Coursier getCoursierByCinC() {
        return coursierByCinC;
    }

    public void setCoursierByCinC(Coursier coursierByCinC) {
        this.coursierByCinC = coursierByCinC;
    }

    @Basic
    @Column(name = "cin_c")
    public String getCinC() {
        return cinC;
    }

    public void setCinC(String cinC) {
        this.cinC = cinC;
    }
}
