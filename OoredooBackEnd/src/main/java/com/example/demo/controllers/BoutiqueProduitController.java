package com.example.demo.controllers;

import com.example.demo.entities.Boutiqueproduit;
import com.example.demo.repository.BoutiqueProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/BoutiqueProduit")
public class BoutiqueProduitController {
        @Autowired
        BoutiqueProduitRepository BPR ;
    @GetMapping(path = "/getProdBoutique")
    public List<Boutiqueproduit> findA(){
         return  BPR.findAll();
    }
    @GetMapping(path= "/getSpecifiedProd")
    public List<Boutiqueproduit> findById(@RequestParam(name = "IdBou") Integer Id ){
        return  BPR.FindBP(Id);
    }
    @GetMapping (path = "/updateBoutiqueProduit")
    public boolean UpdateBoutiqueProduit(@RequestParam(name = "nbr") Integer nbr,@RequestParam(name = "idbou") Integer idbou,String refprod){
       return BPR.updateProd(nbr, idbou, refprod);
    }
}
