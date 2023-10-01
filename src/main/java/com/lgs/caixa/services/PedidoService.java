package com.lgs.caixa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgs.caixa.entities.Pedido;
import com.lgs.caixa.repositories.OrdemRepository;

@Service 
public class PedidoService {

	@Autowired
	private OrdemRepository repository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido findById(Long id) {
		var obj = repository.findById(id);
		return obj.get();
	}

}
