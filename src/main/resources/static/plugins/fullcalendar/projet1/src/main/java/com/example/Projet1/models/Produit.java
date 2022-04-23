package com.example.Projet1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private int qtStock;
    private int qtSeuil;
    private int prix;
    private LocalDate dateCreation;


    @ManyToOne()
    @JoinColumn(name = "categorie_id",insertable = false,updatable = false)
    private Categorie categorie;
}