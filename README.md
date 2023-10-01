##LGS System

Api Rest para cadastro de usuários, produtos e pedidos. Sendo todas entidades vinculadas entre si.

## Diagrama de Classes

 ```mermaid

classDiagram
class Produto{
-Integer id
-String nome
-String descricao
-Double preco
-Set<Categoria> categorias
-OrdemDePedidos[] itens

}
class Categoria{
-Long id
-String nome
-Produto[] produtos
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
class StatusPedido{
    <<enumeration>>
    ESPERANDO_PAGAMENTO
    PAGO
    ENVIADO
    ENTREGUE
    CANCELADO
}

Pedido "1..N" <|.. "1"OrdemPedido
Categoria"1"  <|.. "N"Produto
Pagamento"1" <|.. "1"pedido
Usuario"1" <|.."1..N" pedido
OrdemPedido .. Pedido
OrdemPedido..Produto
StatusPedido..Pedido
