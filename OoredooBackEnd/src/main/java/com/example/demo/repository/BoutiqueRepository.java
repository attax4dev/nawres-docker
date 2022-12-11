package com.example.demo.repository;

import com.example.demo.entities.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoutiqueRepository extends JpaRepository<Boutique,Long> {
    @Query("select b from Boutique  b where b.idBoutique = ?1")
    Boutique FindBoutiqueById(Integer idbou);
}
