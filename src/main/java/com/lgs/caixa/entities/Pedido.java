package com.lgs.caixa.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgs.caixa.entities.enums.StatusPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;

	private Integer pedidoStatus;

	@ManyToOne
	@JoinColumn(name = "cliente_id")

	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<OrdemPedido> pedidos = new HashSet<>();


	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	public Pedido() {
	}

	public Pedido(Long id, Instant momento, StatusPedido statusPedido, Usuario Cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setpedidoStatus(statusPedido);
		this.cliente = Cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getmomento() {
		return momento;
	}

	public void setmomento(Instant momento) {
		this.momento = momento;
	}

	public StatusPedido getpedidoStatus() {
		return StatusPedido.valueOf(pedidoStatus);
	}

	public void setpedidoStatus(StatusPedido statusPedido) {
		if (statusPedido != null) {
			this.pedidoStatus = statusPedido.getcodigo();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario Cliente) {
		this.cliente = Cliente;
	}

	public Pagamento getPayment() {
		return pagamento;
	}

	public void setPayment(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	
	public Set<OrdemPedido> getItems() {
		return pedidos;
	}

	public Double getTotal() {
		double sum = 0.0;
		for (OrdemPedido x : pedidos) {
			sum = sum + x.getSubTotal();
		}
		return sum;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
