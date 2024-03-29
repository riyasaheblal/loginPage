package com.example.loginPage.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.loginPage.Model.LoginModel;
import com.example.loginPage.Repository.LoginRepo;

@Service
public class LoginServiceImpl implements loginService {

	@Autowired
	private LoginRepo loginRepo;
	
	
	@Override
	public LoginModel createlogin(LoginModel loginModel) {   
		return loginRepo.save(loginModel);
	}

	@Override
	public List<LoginModel> readloginAll() {
			return loginRepo.findAll();
	}

	@Override
	public Optional<LoginModel> readloginById(int id) {
		return loginRepo.findById(id);
	}

	@Override
	public ResponseEntity<?> updateLogin (LoginModel loginModel,int id) {
		Optional<LoginModel> opt=this.loginRepo.findById(id);
		if(opt.isPresent()) {
			loginModel.setId(id);
			return ResponseEntity.ok(this.loginRepo.save(loginModel))	;
		}	
		else {

			return ResponseEntity.badRequest().body("To this id no data is available:: "+ id);
		}
//		loginModel.setId(id);
//		return ResponseEntity.ok(this.loginRepo.save(loginModel));


		
	}

	@Override
	public void deleteLoginById(int id) {
         loginRepo.deleteById(id);		
	}

}
