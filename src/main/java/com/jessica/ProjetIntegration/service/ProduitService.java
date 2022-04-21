package com.jessica.ProjetIntegration.service;

import com.jessica.ProjetIntegration.model.Produit;
import com.jessica.ProjetIntegration.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public void saveProduit(Produit produit){
        produitRepository.save(produit);
    }

    public List<Produit> showAllProduit(){
        return produitRepository.findAll();
    }

    public Produit selectedProduit(int id){
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;
        if(optional.isPresent())
        {
            produit = optional.get();
        }
        else
        {
            throw new RuntimeException("Id introuvable");
        }
        return produit;
    }

    public void deletedProduit(int id){
        if(selectedProduit(id) !=null){
            produitRepository.deleteById(id);
        }
    }

}
