package com.example.demo.entities;

import com.fasterxml.jackson.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "personne", schema = "ooredooproject", catalog = "")
public class User implements UserDetails {
    private String cin;
    private String mail;
    private String motdepasse;
    private String nom;
    private Long numTel;
    private String prenom;
    private String role;
    private String username;

   private Agentcommercial agentcommercialByCin;
  private Coursier coursierByCin;



    @JsonManagedReference(value = "usercin")
    @OneToOne(mappedBy = "personneByCinAgent")
    public Agentcommercial getAgentcommercialByCin() {
        return agentcommercialByCin;
    }

    public void setAgentcommercialByCin(Agentcommercial agentcommercialByCin) {
        this.agentcommercialByCin = agentcommercialByCin;
    }
    @JsonManagedReference(value = "CoursierUser")
    @OneToOne(mappedBy = "personneByCinCoursier")
    public Coursier getCoursierByCin() {
        return coursierByCin;
    }

    public void setCoursierByCin(Coursier coursierByCin) {
        this.coursierByCin = coursierByCin;
    }

    @Id
    @Column(name = "cin")
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "motdepasse")
    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "num_tel")
    public Long getNumTel() {
        return numTel;
    }

    public void setNumTel(Long numTel) {
        this.numTel = numTel;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
    @Transient
    @Override
    public String getPassword() {
        return motdepasse;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (cin != null ? !cin.equals(user.cin) : user.cin != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (motdepasse != null ? !motdepasse.equals(user.motdepasse) : user.motdepasse != null) return false;
        if (nom != null ? !nom.equals(user.nom) : user.nom != null) return false;
        if (numTel != null ? !numTel.equals(user.numTel) : user.numTel != null) return false;
        if (prenom != null ? !prenom.equals(user.prenom) : user.prenom != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cin != null ? cin.hashCode() : 0;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (motdepasse != null ? motdepasse.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (numTel != null ? numTel.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
