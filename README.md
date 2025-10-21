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
```
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

```
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
```

## 🧮 Funcionalidades

✅ Cadastro de Categorias
✅ Cadastro de Produtos
✅ Cadastro de Pedidos
✅ Associação de Produtos a Pedidos
✅ Listagem de todos os registros (categorias, produtos, pedidos e produtos_pedido)
✅ Atualização e exclusão via DAO
✅ Conexão direta com o banco de dados PostgreSQL


## 💻 Como Executar o Projeto

1️⃣ Clonar o repositório
git clone https://github.com/SEU_USUARIO/ecommerce-java-jdbc.git

2️⃣ Abrir no IntelliJ IDEA

Importar como projeto Maven

Garantir que o JDK 21 (Amazon Corretto) esteja configurado

3️⃣ Configurar o banco de dados PostgreSQL

Edite a classe DatabaseConnection.java com suas credenciais:

private static final String URL = "jdbc:postgresql://localhost:5432/MeuBanco";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";

4️⃣ Executar o projeto

Rode a classe Main.java e interaja pelo console:

1 - Cadastrar Categoria
2 - Cadastrar Produto
3 - Cadastrar Pedido
4 - Cadastrar ProdutoPedido
5 - Listar tudo
0 - Sair

## 🧑‍💻 Autor

João Emanuel Ribeiro Silva Martins
📍 Goiânia - Goiás
📧 ribeirojoaoemanuel@gmail.com
[Linkedin](https://www.linkedin.com/in/joão-emanuel-6407a2242)
[Github](https://github.com/joaoemanuel01)
