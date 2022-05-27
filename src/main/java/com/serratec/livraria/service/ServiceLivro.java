package com.serratec.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.livraria.exception.ListaExisteException;
import com.serratec.livraria.exception.ListaNotException;
import com.serratec.livraria.model.Livro;
import com.serratec.livraria.repository.LivroRepositorio;

@Service
public class ServiceLivro {


	@Autowired
	LivroRepositorio repositorio;
	
	

	public List<Livro> listaTudo() {
		return repositorio.findAll();
	}
	
	public Livro listaLivros(Integer id) throws ListaNotException {
		Optional<Livro> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ListaNotException("Livro não existe");
		}
		return optional.get();
	}
	
	public void verificaLivroExiste(Livro livro) throws ListaExisteException {
		Optional<Livro> optional = repositorio.findById(livro.getId());
		if (optional.isPresent()) {
			throw new ListaExisteException("Livro já existe");
	}
	}
	
	public void inserir(Livro livro) throws ListaExisteException {
		verificaLivroExiste(livro);
		 repositorio.save(livro);
	}

	public Livro atualizarPorId(Livro livro, Integer id) throws ListaNotException, ListaExisteException {
		Optional<Livro> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ListaNotException("Livro não existe");
		}
		Livro livroOld = optional.get();
		
		if ( livro.getId() != null) {
			verificaLivroExiste(livro);
			livroOld.setId(livro.getId());
		}

			if (livro.getNome() != null) {
				livroOld.setNome(livro.getNome());
				}
			
			return livroOld;
		}
	
	public void removerPorId(Integer id) throws ListaNotException {
		Optional<Livro> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ListaNotException("Conta não existe");
		}
		repositorio.deleteById(id);
	}


	}
	        
	        
	



