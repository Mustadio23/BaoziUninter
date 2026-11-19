# Baozi Store – API REST

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
| Cliente  | id (Long), nome (String), clienteDesde (LocalDate) |
| Produto  | id (Long), nome (String), preco (BigDecimal), estoque (Boolean) |
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

## Como executar

### Opção 1 – MySQL (padrão)
1. Tenha o MySQL rodando em `localhost:3306`.
2. Ajuste `spring.datasource.username` e `spring.datasource.password` em `src/main/resources/application.properties`.
3. `mvn spring-boot:run` (o banco `baozi_store` é criado sozinho).

### Opção 2 – H2 (sem instalar nada)
`mvn spring-boot:run -Dspring-boot.run.profiles=h2`
Console do banco: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:baozi_store`, usuário `sa`, senha vazia).

A API sobe em http://localhost:8080.

## Testes no Postman
Importe `postman/BaoziStore.postman_collection.json` e execute as requisições na ordem das pastas.
Antes de começar, troque `SeuNome123456` pelo seu nome + RU no corpo do POST de cliente.
