package com.example.demo.controllers;

import com.example.demo.entities.Coursier;
import com.example.demo.repository.CoursierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/coursier")
public class CoursierController {
    @Autowired
    CoursierRepository CR;
@GetMapping("/getAllCoursiers")
    public @ResponseBody List<Coursier> getAllCoursiers(){
        return CR.findAll();
    }
@PostMapping("/addCoursier")
public Coursier addCoursier(@RequestBody Coursier c)
    {
     return CR.save(c);
     }
}
