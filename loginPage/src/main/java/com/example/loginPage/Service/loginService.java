package com.example.loginPage.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.loginPage.Model.LoginModel;

public interface loginService {

	//create
	public LoginModel createlogin(LoginModel loginModel);
	//readAll
	public List<LoginModel> readloginAll();
	//readById
	public Optional<LoginModel> readloginById(int id);
	//update
	public ResponseEntity<?> updateLogin(LoginModel loginModel,int id);
	//delete
	public void deleteLoginById(int id);
}
