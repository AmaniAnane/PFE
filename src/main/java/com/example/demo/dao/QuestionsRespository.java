package com.example.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Questions;





public interface QuestionsRespository extends JpaRepository<Questions, Integer> {



	
	//void save(@Valid Place pk);

	//@Temporal(DATE)

}
