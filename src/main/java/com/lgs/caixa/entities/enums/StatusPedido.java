package com.lgs.caixa.entities.enums;

public enum StatusPedido {
	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	public int getcodigo() {
		return codigo;
	}
	
	public static StatusPedido valueOf(int codigo) {
		for(StatusPedido value : StatusPedido.values()) {
			if(value.getcodigo() == codigo) {
				return value;
			}
		}throw new IllegalArgumentException("Código de status do pedido inválido!");
	}
}
