package com.example.demo.controllers;
import java.security.Principal;
import java.util.List;

import com.example.demo.entities.Agentcommercial;
import com.example.demo.entities.Coursier;
import com.example.demo.entities.User;
import com.example.demo.repository.AgentcommercialRepository;
import com.example.demo.repository.CoursierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.IUserDao;
import com.example.demo.service.UserService;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {


	@Autowired
	private UserService userService;
	@Autowired
	private IUserDao IUD ;
	@Autowired
	public PasswordEncoder  bCryptPasswordEncoder ;
    @Autowired
	CoursierRepository CR;
	@Autowired
	AgentcommercialRepository AR;


	// this is the login api/service
	@GetMapping(path = "/login")
	public Principal user(Principal principal) {
		System.out.println("user logged "+principal);
		return principal;
	}
    @GetMapping(path="/getCoursier")
    public List<String> getCoursier(){
	    return IUD.findCoursier();
    }
	@PostMapping(path = "/addUser")
	public Boolean addUser(@RequestBody User user)
	{	boolean existe ;
	    String Cryptedpassword = bCryptPasswordEncoder.encode(user.getMotdepasse());
		System.out.println("**********************************************");
		System.out.println(Cryptedpassword);
			User u = new User();
			u.setCin(user.getCin());
			u.setMotdepasse(Cryptedpassword);
			u.setMail(user.getMail());
			u.setNom(user.getNom());
			u.setPrenom(user.getPrenom());
			u.setUsername(user.getUsername());
			u.setRole(user.getRole());
			u.setNumTel(user.getNumTel());

		    switch(u.getRole()){
				case  "Admin"  : userService.save(u);
				existe = true ;
				break ;
				case "Coursier" : userService.save(u);
				                   CR.save(new Coursier(u.getCin(),true));
				                   existe = true ;
				                   break ;
				case "AgentCommercial": userService.save(u);
				                        AR.save(new Agentcommercial(u.getCin(),null));
			                            existe = true ;
				                        break;
				default: existe = false ; break ;
		    }

		return existe;
	}

	@GetMapping("/getUserByUserName")
	public  String getUserByUserName(@RequestParam(name= "username") String Test){


	User	U = IUD.findByUsername(Test);
		String NomPrenom = U.getNom()+" "+U.getPrenom();
		return  NomPrenom ;
	}
	@GetMapping("/getUserRole")
	public User getUserRole(@RequestParam(name = "username") String Test){
		User U = IUD.findByUsername(Test) ;
		return U ;
	}
/*	@GetMapping("/GetUsersByRole")
	public List<User>getUserByRole(){
		return IUD.findUserByRole() ;
	}*/
	@GetMapping("/getAllUsers")
	public @ResponseBody List<User> getAllP()
		{
		return IUD.findAll();
		}
	

}