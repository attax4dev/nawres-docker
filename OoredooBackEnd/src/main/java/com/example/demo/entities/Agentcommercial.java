package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;



import javax.persistence.*;


@Entity
public class Agentcommercial {
    private String cinAgent;
    private String horaireDeTravail;
    private User personneByCinAgent;

    public Agentcommercial() {
    }



    public Agentcommercial(String cinAgent, String horaireDeTravail) {
        this.cinAgent = cinAgent;
        this.horaireDeTravail = horaireDeTravail;
    }

    @Id
    @Column(name = "cin_agent")
    public String getCinAgent() {
        return cinAgent;
    }

    public void setCinAgent(String cinAgent) {
        this.cinAgent = cinAgent;
    }

    @Basic
    @Column(name = "horaire_de_travail")
    public String getHoraireDeTravail() {
        return horaireDeTravail;
    }

    public void setHoraireDeTravail(String horaireDeTravail) {
        this.horaireDeTravail = horaireDeTravail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agentcommercial that = (Agentcommercial) o;

        if (cinAgent != null ? !cinAgent.equals(that.cinAgent) : that.cinAgent != null) return false;
        if (horaireDeTravail != null ? !horaireDeTravail.equals(that.horaireDeTravail) : that.horaireDeTravail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cinAgent != null ? cinAgent.hashCode() : 0;
        result = 31 * result + (horaireDeTravail != null ? horaireDeTravail.hashCode() : 0);
        return result;
    }

    @JsonBackReference(value="usercin")
    @OneToOne
    @MapsId("cin")
    @JoinColumn(name = "cin_agent", referencedColumnName = "cin", nullable = false)
    public User getPersonneByCinAgent() {
        return personneByCinAgent;
    }

    public void setPersonneByCinAgent(User personneByCinAgent) {
        this.personneByCinAgent = personneByCinAgent;
    }



}
