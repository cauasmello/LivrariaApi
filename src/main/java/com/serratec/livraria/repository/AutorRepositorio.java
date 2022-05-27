package com.serratec.livraria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.livraria.model.Autor;

public interface AutorRepositorio extends JpaRepository <Autor, Integer> {
	
	Optional<Autor> findById(String string);

}
