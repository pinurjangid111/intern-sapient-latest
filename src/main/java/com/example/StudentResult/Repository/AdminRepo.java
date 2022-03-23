package com.example.StudentResult.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentResult.Domain.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,String>{

}
