package com.example.demo.repository;

import com.example.demo.entities.Boutiqueproduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BoutiqueProduitRepository  extends JpaRepository<Boutiqueproduit,String> {
    @Query("select BP from Boutiqueproduit BP where BP.idBou = ?1")
    List<Boutiqueproduit> FindBP(Integer T);
    @Query("update Boutiqueproduit bp set bp.nbrUnitesDisponible =?1 where bp.idBou =?2 and bp.refProd= ?3")
    boolean updateProd(Integer nbr,Integer idbou,String refprod);
}
