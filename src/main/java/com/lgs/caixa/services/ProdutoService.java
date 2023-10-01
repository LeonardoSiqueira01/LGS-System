package com.lgs.caixa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lgs.caixa.entities.Produto;
import com.lgs.caixa.repositories.ProdutoRepository;
import com.lgs.caixa.services.exceptions.DataBaseException;
import com.lgs.caixa.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service  
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> EncontrarTodos() {
		return repository.findAll();
	}

	public Produto inserir(Produto prod) {
		return repository.save(prod);
	}
	
	public Produto EncontrarPorId(Long id) {
	var obj = repository.findById(id);
		return obj.get();
	}
	public Produto cadastrar(Produto prod) {
		 return repository.save(prod);
	}
	public void deletar(Long id) {
			try {
				repository.deleteById(id);
			} catch (EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataBaseException(e.getMessage());
			}
	}
	
	public Produto atualizar(Long id, Produto prod) {
		try {
			Produto entity = repository.getReferenceById(id);
			AtualizarDados(entity, prod);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void AtualizarDados(Produto entidade, Produto obj) {
		entidade.setNome(obj.getNome());
		entidade.setDescricao(obj.getDescricao());
		entidade.setPreco(obj.getPreco());
	}
}
