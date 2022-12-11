package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Produit;
import com.example.demo.entities.Typeprod;
import com.example.demo.repository.AlertRepository;
import com.example.demo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.ProduitRepository;



@RestController
@CrossOrigin("*")
@RequestMapping("/Produit")
public class ProduitController {
	@Autowired
	ProduitRepository PR;
	@Autowired
	AlertRepository AR ;
	@Autowired
	TypeRepository TR ;
	
	@GetMapping("/getAllProducts")
	public @ResponseBody List<Produit> getAllProduits() {
	return PR.findAll(); 
	}


	@GetMapping("/getType")
	public @ResponseBody List<Typeprod> getAllTypes(){
		return TR.findAll();

	}

	@GetMapping("/getRefProd")
	public List<Produit> getSpecifiedProd(@RequestParam(name = "idbou") Integer idbou ) {

		return PR.findAvailableProduct(idbou);
	}


	@GetMapping("/FindByMLT")
	public List<Produit> getProdByMLT(@RequestParam(name = "marque") String marque,@RequestParam(name = "type") Integer Type,@RequestParam(name = "libelle") String Libelle){
		return  PR.FindProdByMLT(marque,Type,Libelle);
	}
	@GetMapping("/getAllAboutBoutique")
	public List<Object> getAllaboutBoutique(@RequestParam(name = "idbou") Integer idbou){
		return  PR.getResult(idbou);
	}
	@GetMapping("/FindDesc")
	public Typeprod getTypeDescription(@RequestParam(name = "type") Integer type){
		return  PR.getDescription(type);
	}
	
	/*@PutMapping("/Update/{id}")
	public ResponseEntity<Produit> Edit(@PathVariable("id")Long id,@RequestBody Produit temp)
	{
		return PR.findById(id)
				.map(record->{
					record.setNom(temp.getNom());
					record.setDescription(temp.getDescription());
					Produit p1=PR.save(record);
					return ResponseEntity.ok().body(p1);
				}).orElse(ResponseEntity.ok().build());
	
	 
	}*/
		
}
