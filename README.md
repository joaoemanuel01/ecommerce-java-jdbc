# 🛒 E-commerce Java JDBC com PostgreSQL

Este é um projeto de **sistema de e-commerce básico** desenvolvido em **Java**, utilizando **JDBC (Java Database Connectivity)** para integração direta com o **PostgreSQL**.  
O objetivo é demonstrar o uso de **CRUD completo (Create, Read, Update, Delete)** e a interação entre **entidades, DAOs e banco de dados relacional**.

---

## 🚀 Tecnologias Utilizadas

- **Java 21 (Amazon Corretto)**
- **JDBC**
- **PostgreSQL**
- **Maven**
- **IntelliJ IDEA**
- **Git & GitHub**

---

## 🧩 Estrutura do Projeto
src/
└── main/
├── java/
│ └── br/com/joaoemanuel/ecommerce/
│ ├── app/ → Classe principal (Main)
│ ├── dao/ → Classes DAO (acesso ao banco)
│ ├── db/ → Classe de conexão (DatabaseConnection)
│ └── entities/ → Entidades do sistema
└── resources/
pom.xml

## 🧠 Conceitos Aplicados

- Programação orientada a objetos (POO)
- CRUD com PreparedStatement e ResultSet
- Conexão com banco PostgreSQL via JDBC
- Manipulação de dados com DAO (Data Access Object)
- Modularização do código com pacotes (`entities`, `dao`, `db`, `app`)
- Uso de Maven para gerenciamento de dependências

---

## 🗄️ Banco de Dados

**Banco:** `MeuBanco`  
**Schema:** `ecomerce`  

### Exemplo de criação de tabelas

```sql
CREATE SCHEMA ecomerce;

CREATE TABLE ecomerce.categoria (
    id_categoria SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE ecomerce.produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    categoria_id INT REFERENCES ecomerce.categoria(id)
);

CREATE TABLE ecomerce.pedido (
    id SERIAL PRIMARY KEY,
    data_pedido DATE NOT NULL,
    valor_total DECIMAL(10,2)
);

CREATE TABLE ecomerce.produto_pedido (
    pedido_id INT REFERENCES ecomerce.pedido(id),
    produto_id INT REFERENCES ecomerce.produto(id),
    quantidade INT NOT NULL,
    PRIMARY KEY (pedido_id, produto_id)
);
