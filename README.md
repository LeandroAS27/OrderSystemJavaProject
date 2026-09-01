# Sistema de Pedidos - Java Moderno

## Sobre o Projeto

Este projeto foi desenvolvido para praticar conceitos modernos do Java, simulando um sistema simples de gerenciamento de pedidos.

O sistema permite:

* Criar clientes
* Criar produtos
* Criar pedidos
* Calcular o valor total de um pedido
* Buscar pedidos por ID
* Listar pedidos pagos
* Gerar relatórios de vendas

Além das funcionalidades de negócio, o principal objetivo do projeto é praticar recursos do Java moderno como Streams, Lambdas, Optional, Records e Functional Interfaces.

---

## Tecnologias Utilizadas

* Java 17+
* Stream API
* Lambdas
* Optional
* Records
* Collections Framework

---

## Estrutura do Projeto

```text
src
├── model
│   ├── Client.java
│   ├── Product.java
│   ├── ItemOrder.java
│   └── Order.java
│
├── service
│   └── OrderService.java
│
└── Main.java
```

---

## Modelagem

### Client

Representa um cliente do sistema.

```java
Client
├── id
├── name
└── email
```

### Product

Representa um produto disponível para venda.

```java
Product
├── id
├── name
└── price
```

### ItemOrder

Representa um produto dentro de um pedido.

```java
ItemOrder
├── product
└── quantity
```

### Order

Representa um pedido realizado por um cliente.

```java
Order
├── id
├── client
├── items
└── paid
```

---

## Funcionalidades

### Calcular Total do Pedido

Calcula o valor total do pedido utilizando Stream API.

Exemplo:

```text
TV x2 = 4000
Notebook x1 = 1500

Total = 5500
```

---

### Buscar Pedido por ID

Permite localizar um pedido utilizando seu identificador.

Exemplo:

```java
orderService.searchForId(1L);
```

Retorno:

```java
Optional<Order>
```

---

### Listar Pedidos Pagos

Filtra todos os pedidos pagos.

Exemplo:

```java
orderService.listPaidOrders();
```

---

### Buscar Pedidos por Cliente

Permite localizar todos os pedidos de um cliente específico.

Exemplo:

```java
orderService.searchByClient("Leandro");
```

---

### Gerar Relatório

Exibe informações gerais sobre os pedidos cadastrados.

Exemplo:

```text
===== REPORT =====

Total Orders: 5
Paid Orders: 3
Pending Orders: 2
Revenue: 15000.0
Average Ticket: 3000.0
```

---

## Conceitos Praticados

### Streams

Utilizados para processar coleções de forma declarativa.

Exemplos:

```java
orders.stream()
```

```java
.filter()
```

```java
.map()
```

```java
.reduce()
```

---

### Lambdas

Utilizadas para simplificar implementações de interfaces funcionais.

Exemplo:

```java
order -> order.isPaid()
```

---

### Optional

Utilizado para evitar retornos nulos.

Exemplo:

```java
Optional<Order>
```

---

### Records

Utilizados para representar objetos imutáveis.

Exemplo:

```java
public record Client(
    Long id,
    String name,
    String email
) {}
```

---

### Functional Interfaces

Prática de programação funcional utilizando interfaces com apenas um método abstrato.

Exemplo:

```java
@FunctionalInterface
public interface DiscountCalculator {
    double apply(double value);
}
```

---

## Como Executar

1. Clone o repositório:

```bash
git clone <url-do-repositorio>
```

2. Acesse o projeto.

3. Compile os arquivos Java.

4. Execute a classe:

```bash
Main.java
```

---

## Aprendizados

Durante o desenvolvimento deste projeto foram praticados:

* Programação Orientada a Objetos
* Java Moderno
* Stream API
* Lambdas
* Optional
* Records
* Collections
* Separação de responsabilidades
* Modelagem de domínio
* Boas práticas de código

---

## Próximos Passos

* Implementar Pedido Mais Caro
* Implementar Produto Mais Vendido
* Implementar Ranking de Clientes
* Adicionar testes unitários com JUnit
* Migrar para Spring Boot
* Persistir dados em banco de dados
* Expor funcionalidades através de APIs REST
