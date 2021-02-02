package com.teachers.crud.model;

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
@Table(name = "teachers", catalog = "test")
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "matiere")
    private String matiere;

    @Column(name = "salair")
    private float salair;

    @Column(name = "abscence")
    private int abscence;

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

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public float getSalair() {
        return salair;
    }

    public void setSalair(float salair) {
        this.salair = salair;
    }

    public int getAbscence() {
        return abscence;
    }

    public void setAbscence(int abscence) {
        this.abscence = abscence;
    }
}
