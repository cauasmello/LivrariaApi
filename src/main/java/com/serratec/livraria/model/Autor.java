package com.serratec.livraria.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Autor() {
		super();
	}

	public Autor(Integer id, String nome, List<Livro> livros) {
		super();
		this.id = id;
		this.nome = nome;
		this.livros = livros;
	}

	
	
	
}
