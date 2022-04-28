package com.jessica.ProjetIntegration.repository;


import java.util.List;

import com.jessica.ProjetIntegration.model.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovisionnementRepository extends JpaRepository <Approvisionnement, Integer> {

    List<Approvisionnement> findByProduitNotNull();
}
