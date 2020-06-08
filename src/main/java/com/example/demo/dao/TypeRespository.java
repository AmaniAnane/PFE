package com.example.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;



import com.example.demo.entities.Type;

public interface TypeRespository  extends JpaRepository<Type, Integer> {

		//	Optional<Categorie> findById(Long id);

		

}
