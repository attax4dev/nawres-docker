package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class BoutiqueproduitPK implements Serializable {
    private int idBou;
    private String refProd;

    @Column(name = "id_bou")
    @Id
    public int getIdBou() {
        return idBou;
    }

    public void setIdBou(int idBou) {
        this.idBou = idBou;
    }

    @Column(name = "ref_prod")
    @Id
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

        BoutiqueproduitPK that = (BoutiqueproduitPK) o;

        if (idBou != that.idBou) return false;
        if (refProd != null ? !refProd.equals(that.refProd) : that.refProd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBou;
        result = 31 * result + (refProd != null ? refProd.hashCode() : 0);
        return result;
    }
}
