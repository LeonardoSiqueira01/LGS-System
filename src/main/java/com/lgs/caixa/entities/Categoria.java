package com.lgs.caixa.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nome;

@JsonIgnore
@ManyToMany(mappedBy = "categorias")
private Set<Produto> produtos = new HashSet<>();


public Categoria() {}

public Categoria(Long id, String nome) {
	super();
	this.id = id;
	this.nome = nome;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getnome() {
	return nome;
}

public void setnome(String nome) {
	this.nome = nome;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Categoria other = (Categoria) obj;
	return Objects.equals(id, other.id);
}

public Set<Produto> getProducts() {
	return produtos;
}


}
