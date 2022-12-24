package com.example.JavaFullStackProject.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JavaFullStackProject.entity.Reviews;



public interface ReviewInterface extends JpaRepository<Reviews,Integer> {
     
}
