package com.example.loginPage.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginPage.Model.LoginModel;
import com.example.loginPage.Service.loginService;

@RestController
public class loginController {
	
	@Autowired
	private loginService loginservice;
	
	@PostMapping("/create")
	public LoginModel create(@RequestBody LoginModel loginModel) {
		LoginModel createlogin = loginservice.createlogin(loginModel);
		return createlogin;
		
	}
	
	@GetMapping("/readAll")
	public List<LoginModel> readAlllogin(){
		return loginservice.readloginAll();	
	}
	
	@GetMapping("/readId/{id}")
	public Optional<LoginModel> readLoginId(@PathVariable int id) {
		return loginservice.readloginById(id);
		
	}
	
	
	@PutMapping("/updateId/{id}")
	public ResponseEntity<?> updateLoginById(@RequestBody LoginModel loginModel,@PathVariable int id) {
		return loginservice.updateLogin(loginModel, id);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteId(@PathVariable int id) {
		this.loginservice.deleteLoginById(id);
	}

}
