##LGS System

Api Rest para cadastro de usuários, produtos e pedidos. Sendo todas entidades vinculadas entre si.

## Diagrama de Classes

 ```mermaid

Modelo de domínio

class Produto{
-Integer id
-String nome
-String descricao
-Double preco
-Set<Categoria> categorias
-Set<OrdemDePedidos> itens

}
class Categoria{
-Long id
-String nome
-Set<Produto> produtos
}

class OrdemPedido{
-OrdemPedidoPK id
-Integer quantidade
-Double preco
}

class Pedido {
-Long id
-Instant Momento
-Integer pedidoStatus
-Usuario usuário
-Pagamento pagamento
+total()double
}

class Pagamento{
-Long id
-Instant momento
-Pedido pedido
}

class Usuario{
-Long id
-String nome
-String email
-String telefone
-String senha
-List<Pedido> pedidos 

}

Enum Status pedido{
-int ESPERANDO_PAGAMENTO
-int PAGO
-int ENVIADO
-int ENTREGUE
-int CANCELADO
-int codigo
+SubTotal()double
}

Pedido "1..N" <-- "1"OrdemPedido
Categoria"1"  <-- "N"Produto
Pagamento"1" -- "1"pedido
Usuario"1" <--"1..N" pedido


