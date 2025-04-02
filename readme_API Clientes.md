API Cliente

Descrição

A API Cliente (‘api-cliente’) recebe os dados dos clientes e os registra. Após o registro, emite um evento no Kafka para que a API Cartões possa processar a requisição.
Tecnologias Utilizadas

-Java 21
-Spring Boot
-Spring Web
-Spring Kafka
-UUID Generator

Endpoints

Criar Cliente

POST /clientesRegistra um cliente e retorna um UUID.

Exemplo de Request:
{
"name": "Carlos Almeida",
"cpf": "11122233344",
"birthDate": "1988-07-15",
"uf": "SP",
"monthPayment": 7000.00
}

Exemplo de Response:
{
"id_cliente": "550e8400-e29b-41d4-a716-446655440000"
}

Integração com Kafka

Ao registrar um cliente, a API publica um evento Kafka:
{
"id_cliente": "550e8400-e29b-41d4-a716-446655440000",
"name": "Carlos Almeida",
"cpf": "11122233344"
}
A api-cartoes consome esse evento para processar a oferta de cartões automaticamente.

Pré-requisitos

Java 21

Kafka rodando em localhost:9092

Docker (opcional para subir Kafka)