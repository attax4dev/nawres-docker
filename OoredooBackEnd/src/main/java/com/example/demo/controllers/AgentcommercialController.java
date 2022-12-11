package com.example.demo.controllers;

import com.example.demo.entities.Agentcommercial;
import com.example.demo.repository.AgentcommercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Agentcommercial")
public class AgentcommercialController {
    @Autowired
    AgentcommercialRepository AR;

    @GetMapping("/getAllAgents")
    public @ResponseBody List<Agentcommercial> getAllAgents(){
        return AR.findAll();
    }

     @PostMapping("/addAgent")
   public Agentcommercial addAgent(Agentcommercial ac)
     {
         return AR.save(ac);
      }
}
