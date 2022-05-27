package com.serratec.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.livraria.exception.ListaExisteException;
import com.serratec.livraria.exception.ListaNotException;
import com.serratec.livraria.model.Categoria;
import com.serratec.livraria.repository.CategoriaRepositorio;

@Service
public class ServiceCategoria {
	
	@Autowired
	CategoriaRepositorio repositorio;
	
	

	public List<Categoria> listaTudo() {
		return repositorio.findAll();
	}
	
	public Categoria listaCategorias(Integer id) throws ListaNotException {
		Optional<Categoria> optional = repositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ListaNotException("Categoria não existe");
		}
		return optional.get();
	}
	
	public void verificaCategoriaExiste(Categoria categoria) throws ListaExisteException {
		Optional<Categoria> optional = repositorio.findById(categoria.getId());
		if (optional.isPresent()) {
			throw new ListaExisteException("Essa categoria já existe");
		}
	}
	public void inserir(Categoria categoria) throws ListaExisteException {
		verificaCategoriaExiste(categoria);
		 repositorio.save(categoria);
	}
		
		public Categoria atualizarPorId(Categoria categoria, Integer id) throws ListaExisteException, ListaNotException {
			Optional<Categoria> optional = repositorio.findById(id);
			if (optional.isEmpty()) {
				throw new ListaNotException("Categoria não existe");
			}
			Categoria categoriaOld = optional.get();
			
			if ( categoria.getId() != null) {
				verificaCategoriaExiste(categoria);
				categoriaOld.setId(categoria.getId());
			}

				if (categoria.getNome() != null) {
					categoriaOld.setNome(categoria.getNome());
					}
				
				if (categoria.getDescricao() != null) {
					categoriaOld.setDescricao(categoria.getDescricao());
					}
			
				
				return categoriaOld;
			}
	
		
		public void removerPorId(Integer id) throws ListaNotException{
			Optional<Categoria> optional = repositorio.findById(id);
			if (optional.isEmpty()) {
				throw new ListaNotException("Conta não existe");
			}
			repositorio.deleteById(id);
		}


	
}
