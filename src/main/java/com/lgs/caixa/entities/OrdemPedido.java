package com.lgs.caixa.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgs.caixa.entities.pk.OrdemPedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ordem_item")
public class OrdemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdemPedidoPK id = new OrdemPedidoPK();
	
	private Integer quantidade;
	private Double preco;

	public OrdemPedido() {
	}

	public OrdemPedido(Pedido order, Produto produto, Integer quantidade, Double preco) {
		super();
		id.setordem(order);
		id.setProduct(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	@JsonIgnore
	public Pedido getOrder() {
		return id.getordem();
	}

	public void setOrder(Pedido order) {
		id.setordem(order);
	}

	public Produto getProduct() {
		return id.getProduct();
	}

	public void setProduct(Produto produto) {
		id.setProduct(produto);
	}

	public Integer getquantidade() {
		return quantidade;
	}

	public void setquantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getpreco() {
		return preco;
	}

	public void setpreco(Double preco) {
		this.preco = preco;
	}

	public double getSubTotal() {
		return preco * quantidade;
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
		OrdemPedido other = (OrdemPedido) obj;
		return Objects.equals(id, other.id);
	}

 

}
