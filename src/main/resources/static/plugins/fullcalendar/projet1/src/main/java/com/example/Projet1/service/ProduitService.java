package com.example.Projet1.service;

import com.example.Projet1.models.Produit;
import com.example.Projet1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    //Insérer un produit
    public void saveProduit(Produit produit){
        produitRepository.save(produit);
    }

    //afficher liste de produits:Read
    public List<Produit> showProduits(){
        return produitRepository.findAll();
    }

    //trouver un produit précis:Read
    public Produit showOneProduit(int id ){
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;
        if(optional.isPresent()){
            produit = optional.get();
        }
        else
            throw new RuntimeException("id introuvable");

        return produit;
    }

    //supprimer un produit
    public void deleteProduit(int id)
    {
        produitRepository.deleteById(id);
    }


}
