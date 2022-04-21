package com.jessica.ProjetIntegration.service;

import com.jessica.ProjetIntegration.model.Categorie;
import com.jessica.ProjetIntegration.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public void save(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public List<Categorie> showAllCattegorie(){
        return categorieRepository.findAll();
    }

    public Categorie selectOneCategorie(int id_cat){
        return categorieRepository.findById(id_cat).get();
    }

    public void deleteCategorie(int id_cat){
        categorieRepository.deleteById(id_cat);
    }
}
