package com.example.demo.controllers;

import com.example.demo.entities.Commande;
import com.example.demo.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/Commande")
public class CommandeController  {
    @Autowired
    CommandeRepository CR ;
    @PostMapping("/AddCommande")
    public void SaveCommande(@RequestBody Commande C ){
        CR.save(C);
    }
}
