package com.serratec.livraria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.livraria.model.Categoria;

public interface CategoriaRepositorio extends JpaRepository <Categoria, Integer> {
	
	Optional<Categoria> findById(String string);
	
	

}
