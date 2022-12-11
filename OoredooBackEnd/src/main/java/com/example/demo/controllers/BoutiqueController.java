package com.example.demo.controllers;

import com.example.demo.entities.Boutique;
import com.example.demo.repository.BoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Boutique")
public class BoutiqueController {
    @Autowired
    BoutiqueRepository BR ;

    @GetMapping("/GetAllBoutiques")
    public @ResponseBody List<Boutique> getAllBoutiques(){ return BR.findAll(); }

    @GetMapping("/FindBoutiqueById")
    public Boutique getBoutiqueById(@RequestParam(name = "idbou") Integer idbou){
        return BR.FindBoutiqueById(idbou);

    }
}
