package com.lgs.caixa.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.lgs.caixa.entities.Pedido;
import com.lgs.caixa.entities.Produto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrdemPedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ordem_id")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Pedido getordem() {
		return pedido;
	}

	public void setordem(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduct() {
		return produto;
	}

	public void setProduct(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemPedidoPK other = (OrdemPedidoPK) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	}

}
