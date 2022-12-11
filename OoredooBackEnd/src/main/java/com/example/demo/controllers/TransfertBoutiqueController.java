package com.example.demo.controllers;

import com.example.demo.entities.Transfert;
import com.example.demo.entities.Transfertboutique;
import com.example.demo.repository.TransfertBoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/transfertboutique")
public class TransfertBoutiqueController {

    @Autowired
    TransfertBoutiqueRepository TBR ;

            @PostMapping("/SaveTransfertBoutique")
            public boolean AddTTransfertBoutique(@RequestBody  Transfertboutique TT)  {
                boolean Res = false ;
              try {

                  TBR.save(TT);
                  Res = true ;
              }catch (Exception E ){
                  Res = false;
              }
                return  Res ;
            }
            @GetMapping("/getAllBoutiquesTransfert")
           public List<Transfertboutique> getBoutiques(){
                return  TBR.findAll();
            }

}
