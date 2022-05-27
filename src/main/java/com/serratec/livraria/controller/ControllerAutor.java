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
import com.serratec.livraria.model.Autor;
import com.serratec.livraria.service.ServiceAutor;


@RestController
@RequestMapping("/autor")
public class ControllerAutor {
	
	@Autowired
    private ServiceAutor service;

 
 	@GetMapping
    public List<Autor> listaTodos() {
    	return service.listaTudo();
        }
 	
	
 	@GetMapping("/{numero}")
	public Autor getOne(@PathVariable Integer id) throws ListaNotException  {
		return service.listaAutores(id);
	}
 
    @PostMapping
    public void insereTodos(@RequestBody Autor autor) throws ListaExisteException  {
		 service.inserir(autor);
 }
	
    @PutMapping("/{id}")
	public Autor atualizar(@RequestBody Autor autor, @PathVariable Integer id) throws ListaNotException, ListaExisteException {
    	return service.atualizarPorId(autor, id);
    }
    
    @DeleteMapping("/{id}")
	public void remover(@PathVariable Integer id) throws ListaNotException  {
		service.removerPorId(id);
	}



}
