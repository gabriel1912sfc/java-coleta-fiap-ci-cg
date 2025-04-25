# ♻️ API de Coleta Seletiva - Cidades Inteligentes

Esta aplicação é uma **API RESTful** para **cadastro e consulta de pedidos de coleta seletiva**, permitindo que **usuários (físicos ou jurídicos)** agendem a retirada de materiais recicláveis.

> 💡 Ideal para soluções em **cidades inteligentes**, com foco em sustentabilidade e gestão urbana moderna.

---

## 🚀 Tecnologias Utilizadas

- **Java (Spring Boot)**
- **Oracle XE (em container Docker)**
- **Docker & Docker Compose**

---

## 🗂️ Funcionalidades

- Cadastro de coletas seletivas
- Consulta de coletas por ID ou listagem geral
- Registro e autenticação de usuários
- Exclusão de registros de coleta

---

## 🔗 Rotas da API

### 📦 Coletas

| Método | Rota                            | Descrição                        |
|--------|----------------------------------|----------------------------------|
| GET    | `/api/coleta/coletas`           | Lista todas as coletas           |
| GET    | `/api/coleta/{idcoleta}`        | Consulta uma coleta por ID       |
| POST   | `/api/coleta/create`            | Cria um novo pedido de coleta    |
| DELETE | `/api/coleta/{id}`              | Deleta uma coleta                |

### 👤 Usuário

| Método | Rota               | Descrição                      |
|--------|--------------------|--------------------------------|
| POST   | `/auth/register`   | Registro de novo usuário       |
| POST   | `/auth/login`      | Autenticação e geração de token|

---

## 🐳 Docker

> O banco de dados Oracle **e a aplicação Java** são executados juntos em containers via Docker Compose.

---

## 📬 Contato

Fique à vontade para contribuir em melhorias para o projeto! 😄

---

