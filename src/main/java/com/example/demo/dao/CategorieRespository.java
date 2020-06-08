package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Categorie;


public interface CategorieRespository extends JpaRepository<Categorie, Integer> {

}
