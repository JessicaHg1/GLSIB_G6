package com.jessica.ProjetIntegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private int prix;
    private LocalDate date_creation;

    @ManyToOne()
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;



    @OneToMany(mappedBy = "produit")
    private List<Approvisionnement> approvisionnements;



    // @ManyToOne()
    // @JoinColumn(name = "approvisionnement_id", insertable = false, updatable = false)
    // private Approvisionnement approvisionnement;
    // private int approvisionnement_id;
}
