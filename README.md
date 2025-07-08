![banner](https://github.com/SergioBrito47/sistema_gestao_industria/blob/main/Copilot_20250708_193057.png)

![banner](https://github.com/SergioBrito47/sistema_gestao_industria/blob/main/Gemini_Generated_Image_da7ud0da7ud0da7u.png)

# Sistema de gestão Indústria

Projeto Java: Sistema de Gestão Industrial
# Projeto Java: Sistema de Gestão Industrial

## 📌 Visão Geral

Este projeto consiste em um sistema de gerenciamento para uma indústria, desenvolvido em **Java** com **JDBC**, utilizando **MySQL** como banco de dados. Ele permite o controle de **setores**, **funcionários**, **produtos** e **produções**.

O sistema inclui um **menu interativo em console** para testes das funcionalidades CRUD de cada entidade.

---

## 📋 Requisitos do Sistema

Para executar corretamente o projeto, você deve ter instalado em sua máquina:

- ✅ **Java JDK 11** ou superior
- ✅ **MySQL Server**
- ✅ **IntelliJ IDEA** (ou outra IDE compatível com Java)

Além disso, é necessário **restaurar o banco de dados** MySQL com o script fornecido no projeto para que o sistema funcione corretamente.

---

## 🏗️ Estrutura do Projeto

```
Industria/
├── src/
│   ├── dao/
│   │   ├── FuncionarioDAO.java
│   │   ├── ProdutoDAO.java
│   │   ├── ProducaoDAO.java
│   │   └── SetorDAO.java
│   ├── model/
│   │   ├── Funcionario.java
│   │   ├── Produto.java
│   │   ├── Producao.java
│   │   └── Setor.java
│   ├── menu/
│   │   ├── MenuFuncionario.java
│   │   ├── MenuProduto.java
│   │   ├── MenuProducao.java
│   │   └── MenuSetor.java
│   ├── conexao/
│   │   └── ConexaoMySQL.java
│   └── Main.java
├── script_banco.sql
└── README.md
```

---

## 🗃️ Banco de Dados

### Nome: `industria`

```sql
CREATE DATABASE industria;
USE industria;
```

### Script de Criação e População

O arquivo `script_banco.sql` contém toda a estrutura e os dados iniciais do banco. Você pode executá-lo diretamente:

#### Usando MySQL Workbench:
1. Abra o MySQL Workbench.
2. Vá em **File > Open SQL Script...** e selecione o arquivo `script_banco.sql`.
3. Execute com o botão de raio (⚡️).

#### Usando terminal:
```bash
mysql -u root -p < script_banco.sql
```

As tabelas estão relacionadas com **chaves estrangeiras** e **ações de cascata** para manter a integridade referencial.

---

## 📦 DAO (Data Access Object)

Cada DAO realiza as operações de:

- `listar()`
- `buscarPorId(int id)`
- `cadastrar(objeto)`
- `atualizar(objeto)`
- `remover(int id)`

### Exemplo: ProdutoDAO

```java
Produto produto = new Produto(null, "Caneta", "Caneta esferográfica azul");
produtoDAO.cadastrar(produto);
```

Trechos importantes de manipulação com JDBC:

```java
String sql = "INSERT INTO produtos (nome_produto, descricao) VALUES (?, ?);";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, produto.getNomeProduto());
ps.setString(2, produto.getDescricao());
ps.executeUpdate();
```

---

## 📋 Classes de Modelo

Cada classe (`Funcionario`, `Produto`, `Setor`, `Producao`) representa uma entidade com os seguintes campos e métodos:

- Construtores
- Getters e Setters
- Método `toString()` formatado

Exemplo:

```java
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;

    public Produto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String toString() {
        return "Produto{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", descricao='" + descricao + '\'' +
            '}';
    }
}
```

---

## 🎛️ Menu Interativo

O sistema é controlado por um menu principal via console:

```text
========= MENU PRINCIPAL =========
1. Setor
2. Funcionário
3. Produto
4. Produção
0. Sair
```

Cada módulo possui:

```text
1. Listar
2. Cadastrar
3. Atualizar
4. Remover
5. Buscar por ID
```

---

## 🔧 Tecnologias Usadas

- Java 11+
- JDBC
- MySQL
- Scanner (console interativo)

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/industria-java.git
cd industria-java
```

2. **Crie o banco de dados:**

Use o script SQL `script_banco.sql` incluído no projeto.

3. **Configure a conexão:**

Edite `ConexaoMySQL.java` com seus dados de acesso ao MySQL:

```java
String url = "jdbc:mysql://localhost:3306/industria";
String user = "root";
String password = "senha";
```

4. **Compile e execute:**

```bash
javac Main.java
java Main
```

---

## 👨‍💻 Autor

**Sérgio Brito**\
[LinkedIn](https://linkedin.com/in/seu-perfil) | [GitHub](https://github.com/seu-usuario)

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License** – veja o arquivo [LICENSE](LICENSE) para mais detalhes

LinkedIn | GitHub



