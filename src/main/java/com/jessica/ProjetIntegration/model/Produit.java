package com.jessica.ProjetIntegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelle;
    private int qte_stock;
    private int qte_seuil;
    private double prix;
    private LocalDate date_creation;

    @ManyToOne()
    @JoinColumn(name = "categorie_id", insertable = false, updatable = false)
    private Categorie categorie;
    private  int categorie_id;


}
