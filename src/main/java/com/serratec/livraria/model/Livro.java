package com.serratec.livraria.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	String nome;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "livro_autor",
	joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
	private Set<Autor> autores;
	
	@ManyToOne()
	@JoinColumn(name="categoria_id", referencedColumnName = "id")
	private Categoria categoria;

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

	public Livro() {
		super();
	}

	public Livro(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	
	


	
	
}
