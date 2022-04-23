package com.example.Projet1.service;

import com.example.Projet1.models.Categorie;
import com.example.Projet1.models.Produit;
import com.example.Projet1.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    //Insérer une catégorie
    public void saveCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    //afficher liste des catégories:Read
    public List<Categorie> showCategorie(){
        return categorieRepository.findAll();
    }

    public Categorie selectOneCategorie(int id){

        return  categorieRepository.findById(id).get();
    }


    //supprimer une categorie
    public void deleteCategorie(int id)
    {
        categorieRepository.deleteById(id);
    }






}
