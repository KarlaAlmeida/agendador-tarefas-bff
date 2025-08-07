# 🌐 API BFF - Backend for Frontend

Orquestra as chamadas entre o frontend e os microsserviços do sistema, centralizando autenticação, agregações e lógica de apresentação.

## 🚀 Funcionalidades

- Integração com APIs de usuários, tarefas e notificações via FeignClient
- Endpoints agregados para o frontend
- Autenticação única com token JWT
- Agendamento de envios com `@Scheduled` e Cron

## 📍 Endpoints da Aplicação
- **POST /usuario**: Cadastra um novo usuário.
- **POST /usuario/login**: Realiza login de um usuário.
- **GET /usuario**: Busca usuário por email.
- **DELETE /usuario**: Deleta usuário por ID.
- **PUT /usuario**: Atualiza dados do usuário por ID.
- **PUT /usuario/telefone**: Atualiza telefones do usuário por ID.
- **PUT /usuario/endereco**: Atualiza endereços do usuário por ID.
- **POST /usuario/telefone**: Cadastra novo telefone de usuário.
- **POST /usuario/endereco**: Atualiza novo endereço de usuário.
- **GET /usuario/endereco/{cep}**: Busca dados de endereço recebendo um CEP.
- **POST /tarefas**: Cadastra uma nova tarefa.
- **GET /tarefas/eventos**: Busca lista de tarefas por período.
- **GET /tarefas**: Busca tarefas por email.
- **DELETE /tarefas**: Deleta tarefa por ID.
- **PATCH /tarefas**: Altera status de tarefa por ID.
- **PUT /tarefas**: Atualiza tarefas por ID.

## 🔐 Segurança

- Spring Security com autenticação JWT
- Propagação segura do token para os serviços integrados

## 🔗 Integrações

- OpenFeign para consumir APIs internas
- Swagger para facilitar testes do frontend
- JWT incluído automaticamente nas chamadas Feign

## 📚 Documentação

- Swagger OpenAPI disponível em `/swagger-ui.html`

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Security + JWT
- Spring Web + WebClient
- OpenFeign
- Docker

## 🧱 Arquitetura

- Padrão BFF (Backend for Frontend)

 <img width="1553" height="859" alt="image" src="https://github.com/user-attachments/assets/556c9d25-7f70-4dfc-9701-15ceeb28227f" />


## ✅ Boas Práticas

- Clean Architecture com controle de domínio e integração
- Centralização da autenticação e autorização
- Propagação segura e transparente de tokens JWT
- Swagger para documentação da API exposta ao frontend


## 📦 Como Rodar

```bash
docker-compose up --build
