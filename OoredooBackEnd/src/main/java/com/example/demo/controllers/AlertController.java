package com.example.demo.controllers;


import com.example.demo.entities.Alert;
import com.example.demo.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Alert")
public class AlertController {

    @Autowired
    AlertRepository AR;

    @GetMapping("/getAllAlerts")
    public @ResponseBody
    List<Alert> getAllAlerts() {
        return AR.findAll();
    }

    @PostMapping("/addAlert")
    public boolean  AjouterAlert(@RequestBody Alert AE) {
          boolean Res ;
        try {
            AR.save(AE);
            Res = true ;
        }catch (Exception E){
            Res = false ;
        }
      return  Res ;
    }
}