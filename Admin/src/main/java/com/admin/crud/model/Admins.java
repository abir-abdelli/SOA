package com.admin.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admins", catalog = "test")
public class Admins {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "abscence")
    private Integer abscence;

    @Column(name = "salair")
    private float salair;

    public float getSalair() {
        return salair;
    }

    public void setSalair(float salair) {
        this.salair = salair;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAbscence() {
        return abscence;
    }

    public void setAbscence(Integer abscence) {
        this.abscence = abscence;
    }
}
