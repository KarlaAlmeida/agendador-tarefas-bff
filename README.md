# 🌐 API BFF - Backend for Frontend

Orquestra as chamadas entre o frontend e os microsserviços do sistema, centralizando autenticação, agregações e lógica de apresentação.

## 🚀 Funcionalidades

- Integração com APIs de usuários, tarefas e notificações via FeignClient
- Endpoints agregados para o frontend
- Autenticação única com token JWT
- Agendamento de envios com `@Scheduled` e Cron

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
- Comunicação síncrona com fallback e retry

## ✅ Boas Práticas

- Clean Architecture com controle de domínio e integração
- Centralização da autenticação e autorização
- Propagação segura e transparente de tokens JWT
- Swagger para documentação da API exposta ao frontend

## 📦 Como Rodar

```bash
docker-compose up --build
