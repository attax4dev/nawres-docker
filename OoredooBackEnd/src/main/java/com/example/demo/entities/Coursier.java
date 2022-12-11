package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Coursier {
    private String cinCoursier;
    private Boolean disponibilite;
    private User personneByCinCoursier;
    private Collection<Transfert> transfertsByCinCoursier;



    public Coursier(){

    }

    public Coursier(String cinCoursier, Boolean disponibilite) {
        this.cinCoursier = cinCoursier;
        this.disponibilite = disponibilite;
    }


    @Id
    @Column(name = "cin_coursier")
    public String getCinCoursier() {
        return cinCoursier;
    }

    public void setCinCoursier(String cinCoursier) {
        this.cinCoursier = cinCoursier;
    }

    @Basic
    @Column(name = "disponibilite")
    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coursier coursier = (Coursier) o;

        if (cinCoursier != null ? !cinCoursier.equals(coursier.cinCoursier) : coursier.cinCoursier != null)
            return false;
        if (disponibilite != null ? !disponibilite.equals(coursier.disponibilite) : coursier.disponibilite != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cinCoursier != null ? cinCoursier.hashCode() : 0;
        result = 31 * result + (disponibilite != null ? disponibilite.hashCode() : 0);
        return result;
    }
    @JsonBackReference(value = "CoursierUser")
    @OneToOne
    @MapsId("cin")
    @JoinColumn(name = "cin_coursier", referencedColumnName = "cin", nullable = false)
    public User getPersonneByCinCoursier() {
        return personneByCinCoursier;
    }

    public void setPersonneByCinCoursier(User personneByCinCoursier) {
        this.personneByCinCoursier = personneByCinCoursier;
    }
   @JsonManagedReference(value = "TrasnfertCoursier")
   @OneToMany(mappedBy = "coursierByCinC")
    public Collection<Transfert> getTransfertsByCinCoursier() {
        return transfertsByCinCoursier;
    }

    public void setTransfertsByCinCoursier(Collection<Transfert> transfertsByCinCoursier) {
        this.transfertsByCinCoursier = transfertsByCinCoursier;
    }
}
