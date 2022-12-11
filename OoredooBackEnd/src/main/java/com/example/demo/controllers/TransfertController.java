package com.example.demo.controllers;

import com.example.demo.entities.Transfert;
import com.example.demo.entities.Transfertboutique;
import com.example.demo.repository.TransfertBoutiqueRepository;
import com.example.demo.repository.TransfertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin("*")
@RequestMapping("/transfert")
public class TransfertController {
    @Autowired
    TransfertRepository TR;

    @GetMapping("/getAllTrans")
    public @ResponseBody
    List<Transfert> getAllTrans() {
        return TR.findAll();
    }

    @GetMapping("/getTransfertByCoursier")
    public List<Transfert> getTransfertByCoursier (@RequestParam(name= "username") String Test) {
        return TR.getTransfertByCoursier(Test);
    }

    @PostMapping("/SaveTrans")
    public boolean addTransfert(@RequestBody Transfert T) {
        System.out.println(T);
        boolean Res = false ;
        Integer i = TR.GetReference(T.getReferenceTransfert());
        String Result = "";
        System.out.println(i);
        int R ;
        try {
            if (i > 0) {
                do {
                    Random r = new Random();
                    int min = 1000;
                    int max = 10000;
                    R = r.nextInt((max - min) + 1) + min;
                    Result = "REF" + R;
                    System.out.println(Result);
                } while (Result.equals(T.getReferenceTransfert()));
                T.setReferenceTransfert(Result);
                TR.save(T);
            } else {
                TR.save(T);
            }
            Res  = true ;
        }catch (Exception E ){ Res = false;}
        return Res;
    }
}