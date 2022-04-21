package com.jessica.ProjetIntegration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "approvisionnement")
public class Approvisionnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;
    private LocalDate date_mv_stock;

    @ManyToOne()
    @JoinColumn(name = "produit_id", insertable = false, updatable = false)
    private Produit produit;
    private  int produit_id;
}
