package com.lgs.caixa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgs.caixa.entities.Pedido;
import com.lgs.caixa.services.PedidoService;

@RestController
@RequestMapping(value = "/ordem")
public class PedidoResource {
	@Autowired
	private PedidoService service;

	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}