package com.example.loginPage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginPage.Model.LoginModel;

@Repository
public interface LoginRepo extends JpaRepository<LoginModel, Integer> {

}
