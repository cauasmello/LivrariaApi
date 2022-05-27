package com.serratec.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.livraria.exception.ListaExisteException;
import com.serratec.livraria.exception.ListaNotException;
import com.serratec.livraria.model.Autor;
import com.serratec.livraria.repository.AutorRepositorio;

@Service
public class ServiceAutor {

	@Autowired
	AutorRepositorio repositorio;
	
	

	public List<Autor> listaTudo() {
		return repositorio.findAll();
	}
	
	public Autor listaAutores(Integer id) throws ListaNotException {
		Optional<Autor> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ListaNotException("Autor não existe");
		}
		return optional.get();
	}
	
	public void verificaAutorExiste(Autor autor) throws ListaExisteException {
		Optional<Autor> optional = repositorio.findById(autor.getId());
		if (optional.isPresent()) {
			throw new ListaExisteException("Autor já existe");
	}
	}
	
	public void inserir(Autor autor) throws ListaExisteException {
		verificaAutorExiste(autor);
		 repositorio.save(autor);
	}

	public Autor atualizarPorId(Autor autor, Integer id) throws ListaNotException, ListaExisteException {
		Optional<Autor> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ListaNotException("Autor não existe");
		}
		Autor autorOld = optional.get();
		
		if ( autor.getId() != null) {
			verificaAutorExiste(autor);
			autorOld.setId(autor.getId());
		}

			if (autor.getNome() != null) {
				autorOld.setNome(autor.getNome());
				}
			
			return autorOld;
		}
	
	public void removerPorId(Integer id) throws ListaNotException {
		Optional<Autor> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ListaNotException("Conta não existe");
		}
		repositorio.deleteById(id);
	}


	}
	        
	        
	





