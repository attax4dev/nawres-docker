package com.example.demo.repository;

import com.example.demo.entities.Produit;
import java.util.List;

import com.example.demo.entities.Typeprod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,String> {

   @Query("select p from Produit p join Boutiqueproduit b on p.referenceProduit = b.refProd where b.idBou= ?1 ")
   List<Produit> findAvailableProduct(Integer idbou);
   @Query("select p from Produit p where  p.marque = ?1 and p.type = ?2 and p.libelle = ?3")
   List<Produit> FindProdByMLT(String marque,Integer type , String libelle);
   @Query ("select  p.referenceProduit,p.marque,p.libelle,p.type,p.prix,b.nbrUnitesDisponible from Produit p join Boutiqueproduit  b on p.referenceProduit = b.refProd where b.idBou= ?1")
   List<Object> getResult(Integer idbou);
   @Query ("select t from Typeprod t where t.idType = ?1")
   Typeprod getDescription(Integer idtype);


}
