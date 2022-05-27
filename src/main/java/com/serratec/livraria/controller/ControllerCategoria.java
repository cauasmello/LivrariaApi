package com.serratec.livraria.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.livraria.exception.ListaExisteException;
import com.serratec.livraria.exception.ListaNotException;
import com.serratec.livraria.model.Categoria;
import com.serratec.livraria.service.ServiceCategoria;

@RestController
@RequestMapping("/categoria")
public class ControllerCategoria {
	
	@Autowired
    private ServiceCategoria service;

 
 	@GetMapping
    public List<Categoria> listaTodos() {
    	return service.listaTudo();
        }
	
 	@GetMapping("/{id}")
	public Categoria getOne(@PathVariable Integer id) throws ListaNotException  {
		return service.listaCategorias(id);
	}
 
    @PostMapping
    public void insereTodos( @RequestBody Categoria categoria) throws ListaExisteException {
		 service.inserir(categoria);
 }
    @PutMapping("/{id}")
 		public Categoria atualizar(@RequestBody Categoria categoria, @PathVariable Integer id) throws ListaExisteException, ListaNotException  {
 	    	return service.atualizarPorId(categoria, id);
 	    }
 	    
 	    @DeleteMapping("/{id}")
 		public void remover(@PathVariable Integer id) throws ListaNotException {
 			service.removerPorId(id);
 		}


}
