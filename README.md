## LGS System

<div>Api com funcionalidades Crud e tratamento de exceções,interface feita através do Swagger UI, api integrada ao railway o banco de dados PostgreSQL sendo realizado o deploy na nuvem.</div>
<div>Ela tem suporte para: Cadastrar, deletar, atualizar, procurar por id, listar todos os usuarios; Cadastrar, deletar, atualizar, procurar por id, listar todos os produtos;Listar todos, ouu por Id os pedidos e categorias de produtos.</div>
<h5>Tecnologias Utilizadas</h5>
<p>Java |SpringBoot |Swagger UI |PostgreSQL |Deploy com RailWay </p>
<div>
 <img align="center" alt="Leo-JAVA" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
   <img align="center" alt="Leo-Spring" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
      <img align="center" alt="Leo-Tomcat" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/tomcat/tomcat-original.svg">
         <img align="center" alt="Leo-Postgresql" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg">
     <img align="center" alt="Leo-Git" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/git/git-original.svg">
</div>

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
```
<h4> Link da API para testa-lá : https://lgs-system.up.railway.app/swagger-ui.html  :sunglasses: :point_down:</h4> 
<img src="swagger.png">

