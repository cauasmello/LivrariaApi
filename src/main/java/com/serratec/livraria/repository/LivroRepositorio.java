package com.serratec.livraria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.livraria.model.Livro;

public interface LivroRepositorio extends JpaRepository <Livro, Integer> {
	
	Optional<Livro> findById(String string);
	

}
