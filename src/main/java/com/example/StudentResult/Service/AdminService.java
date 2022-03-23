package com.example.StudentResult.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentResult.Domain.Admin;
import com.example.StudentResult.Repository.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	public List<Admin> listAllAdmin(){
		return adminRepo.findAll();
	}
	

}
