package com.serratec.livraria.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.serratec.livraria.model.Livro;
import com.serratec.livraria.service.ServiceLivro;


@RestController
@RequestMapping("/livro")
public class ControllerLivro {
	
	@Autowired
    private ServiceLivro service;

 
 	@GetMapping
    public List<Livro> listaTodos() {
    	return service.listaTudo();
        }
 	
	
 	@GetMapping("/{id}")
	public Livro getOne(@PathVariable Integer id) throws ListaNotException  {
		return service.listaLivros(id);
	}
 
    @PostMapping
    public void insereTodos(@Valid @RequestBody Livro livro) throws ListaExisteException  {
		 service.inserir(livro);
 }
	
    @PutMapping("/{id}")
	public Livro atualizar(@RequestBody Livro livro, @PathVariable Integer id) throws ListaNotException, ListaExisteException {
    	return service.atualizarPorId(livro, id);
    }
    
    @DeleteMapping("/{id}")
	public void remover(@PathVariable Integer id) throws ListaNotException  {
		service.removerPorId(id);
	}


}
