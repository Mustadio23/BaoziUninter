Baozi Store – API REST

API REST simples para controle de clientes, produtos e pedidos da Baozi Store (loja de pãozinho chinês).

**Tecnologias:** Java 17, Spring Boot 3.4, Spring Data JPA, Bean Validation, MySQL (ou H2), Postman.

## Estrutura

```
src/main/java/com/baozi/store
├── BaoziStoreApplication.java
├── model/        Cliente, Produto, Pedido (entidades JPA)
├── repository/   ClienteRepository, ProdutoRepository, PedidoRepository
├── controller/   ClienteController, ProdutoController, PedidoController
├── dto/          PedidoRequest
└── exception/    GlobalExceptionHandler
```

## Entidades

| Entidade | Campos |
|----------|--------|
| Cliente  | id (Long), nome (String), telefone (String), clienteDesde (LocalDate) |
| Produto  | id (Long), nome (String), descricao (String), preco (BigDecimal), estoque (Boolean) |
| Pedido   | id (Long), cliente (FK cliente_id), produto (FK produto_id), quantidade (Integer) |

## Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST   | /clientes, /produtos, /pedidos | Criar |
| GET    | /clientes, /produtos, /pedidos | Listar todos |
| GET    | /{entidade}/{id} | Consultar por ID |
| PUT    | /{entidade}/{id} | Atualizar (opcional) |
| DELETE | /{entidade}/{id} | Apagar |

Corpo do POST /pedidos: `{ "clienteId": 1, "produtoId": 1, "quantidade": 3 }`

