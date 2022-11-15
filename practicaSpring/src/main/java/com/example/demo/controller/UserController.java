package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/nuevo")
	public String nuevo() {
		return "index";
	}

	@GetMapping(value = "/show")
	public String show(Model model) {
		model.addAttribute("UsersData", userRepository.findAll());
		return "show";
	}



	@GetMapping(value = "/ChekIn")
	public String chekIn(Model model) {
		model.addAttribute("UsuarioData", new User());
		return "ChekIn";
	}

	@PostMapping("/ChekIn") //sirve para mapear solicitudes
	public String crear(User user) {
		userRepository.save(user);                                                      //Para persistir un contacto/almacenar
		return "redirect:/show";
	}

	@GetMapping(value = "/deleteUser")
	public String delete(){
		return "deleteUser";
	}

	@PostMapping(value = "/deleteUser")
	public String goDelete(){
		userRepository.deleteAll();
		return "redirect:/show";
	}

	@GetMapping(value = "/LogIn")
	public String getlogIn(){
		return "LogIn";
	}
	@PostMapping(value = "/LogIn")
	public String postLogIn(){
		//userRepository.finUser();
		return "redirect:/show";
	}





/* //Este Cacho de codigo era para hacer un login
	@RequestMapping(value ="/LogIn/{email}/{password}", method=RequestMethod.GET)
	public String logData(@PathVariable String email, @PathVariable String password){
		System.out.println("username is:"+email);
		System.out.println("password is:"+password);
		return "/show";
	}
*/

	/*
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	private ResponseEntity<User> loginUser(@RequestBody ParametrosdeEntradaLogin login){
	
		User u = userservice.logIn(login);
		
		if(u != null) {
			return ResponseEntity.ok(u);
		}else {
			throw new ResourceException(HttpStatus.NO_CONTENT,"Error Amigo Cristian. Coge mejor el usuario. De chill bro");
		}
		
	}
	
	@RequestMapping(value = "/usuario/forgetpaswd", method = RequestMethod.POST)
	private ResponseEntity<Boolean> forgetPasswd (@RequestBody ParametroEntradaContraseñaOlvidar fpaswd){
		boolean	forget = userservice.fpasswd(fpaswd);
		return ResponseEntity.ok(forget);
	}
	
	
	@RequestMapping(value = "usuario/changepaswd", method = RequestMethod.POST)
	private ResponseEntity<Boolean> changepaswd (@RequestHeader(value = "email") String email,
			@RequestBody ParametroEntradaPass cpasdw){
		
		boolean change = false;
		
		change = userservice.cpasswd(cpasdw, email);
		
		return ResponseEntity.ok(change);
	}*/
	
}
