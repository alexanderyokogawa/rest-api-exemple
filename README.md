# 📨 Message API

Uma API RESTful simples para gerenciamento de mensagens, construída com **Spring Boot 3** e **Java 21**.

## 🚀 Tecnologias

- Java 21
- Spring Boot 3.5.11
- Spring Web
- Spring Boot Actuator
- Spring Boot DevTools
- Maven

## 📋 Pré-requisitos

- Java 21+
- Maven 3.8+

## ▶️ Como executar

Clone o repositório e execute:


A aplicação estará disponível em: `http://localhost:8080`

## 📡 Endpoints

Base URL: `/message`

| Método   | Rota            | Descrição                        |
|----------|-----------------|----------------------------------|
| `GET`    | `/message`      | Lista todas as mensagens         |
| `GET`    | `/message/{id}` | Busca uma mensagem por ID        |
| `GET`    | `/message/by-id?id={id}` | Busca mensagem por ID via query param |
| `POST`   | `/message`      | Cria uma nova mensagem           |
| `PUT`    | `/message/{id}` | Atualiza uma mensagem existente  |
| `DELETE` | `/message/{id}` | Remove uma mensagem              |

## 📦 Exemplos de uso

### Criar mensagem
http POST /message Content-Type: application/json
```json
{ "message": "Olá, mundo!" }
```

### Resposta de sucesso (`201 Created`)
```json
{ "id": 1, "message": "Olá, mundo!" }
```


### Buscar todas as mensagens
http GET /message
```json
[
  { "id": 1, "message": "Olá, mundo!" },
  { "id": 2, "message": "Outra mensagem" }
]
```


### Atualizar mensagem
http PUT /message/1 Content-Type: application/json
```json
{ "message": "Mensagem atualizada" }
```


### Deletar mensagem
http DELETE /message/1


## ⚠️ Respostas de erro

| Status | Descrição                          |
|--------|------------------------------------|
| `400`  | Requisição inválida                |
| `404`  | Mensagem não encontrada            |

Exemplo de resposta de erro:

```json
{
  "timestamp": "2026-02-26T10:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Message with id 99 not found"
}
```
```
src/main/java/com/jusfy/messageapi/
├── controllers/       # Camada de controle (endpoints REST)
├── dto/               # Objetos de transferência de dados
├── exceptions/        # Tratamento global de exceções
├── models/            # Entidades do domínio
├── repositories/      # Camada de acesso a dados
├── services/          # Regras de negócio
└── MessageApiApplication.java
```

## 📊 Health Check
A API expõe endpoints de monitoramento via **Spring Actuator**:
GET /actuator/health
