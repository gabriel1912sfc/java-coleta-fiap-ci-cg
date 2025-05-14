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

- Operações CRUD de pedidos de Coleta e de Usuários do sistema

---

## 🔗 Rotas da API

### 📦 Coletas

| Método | Rota                      | Descrição                     |
|--------|---------------------------|-------------------------------|
| GET    | `/api/coleta/coletas`     | Lista todas as coletas        |
| GET    | `/api/coleta/{id}`        | Consulta uma coleta por ID    |
| POST   | `/api/coleta/create`      | Cria um novo pedido de coleta |
| PUT    | `/api/coleta/update/{id}` | Atualiza um pedido de coleta  |
| DELETE | `/api/coleta/{id}`        | Deleta uma coleta             |

### 👤 Usuário

| Método | Rota                               | Descrição                       |
|--------|------------------------------------|---------------------------------|
| GET    | `/api/coleta/user/users`           | Lista todos os usuários         |
| GET    | `/api/coleta/user/{userId}`        | Consulta um usuário por ID      |
| POST   | `/api/coleta/user/create`          | Cria um novo usuário            |
| PUT    | `/api/coleta/user/update/{userId}` | Atualiza os dados de um usuário |
| DELETE | `/api/coleta/user/{userId}`        | Deleta um usuário               |

---

## 🐳 Docker

> O banco de dados Oracle **e a aplicação Java** são executados juntos em containers via Docker Compose.

---

## 📬 Contato

Fique à vontade para contribuir em melhorias para o projeto! 😄

---


