package com.jessica.ProjetIntegration.service;

import com.jessica.ProjetIntegration.model.Approvisionnement;
import com.jessica.ProjetIntegration.model.Categorie;
import com.jessica.ProjetIntegration.model.Produit;
import com.jessica.ProjetIntegration.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {

    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    public void save(Approvisionnement approvisionnement){
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> showAllAppro(){
        return approvisionnementRepository.findByProduitNotNull();
    }


    public Approvisionnement selectOneProvision(int id){
        return approvisionnementRepository.findById(id).get();
    }

    public void deleteProvision(int id){
        approvisionnementRepository.deleteById(id);
    }

}
