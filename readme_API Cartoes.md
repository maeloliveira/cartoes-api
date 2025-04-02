API Cartões
Descrição

A API Cartões (‘api-cartoes’) processa requisições de clientes para oferecer cartões de crédito elegíveis com base nos
dados fornecidos. Ela se comunica com a API Cliente (‘api-cliente’) para registrar clientes e validar informações. Além
disso, utiliza Kafka para comunicação assíncrona.

Tecnologias Utilizadas

-Java 21
-Spring Boot
-Spring Web
-Hibernate (H2 Database para testes)
-Jakarta Validation
-JUnit 5 e Mockito

Endpoints

Criar Cartões para Cliente

POST /cartoesRecebe um payload JSON com os dados do cliente e retorna os cartões elegíveis.

Exemplo de Request:
{
"cliente":{
"name": "Ismael Oliveira",
"cpf": "123.456.789-10",
"age": 33,
"birthDate": "1999-04-02",
"uf": "SP",
"monthPayment": 5000,
"email": "cliente@teste.com",
"phone": "11999992020"

    }

}

Exemplo de Response:
{
"id": "550e8400-e29b-41d4-a716-446655440000",
"dataHora": "2025-04-02T12:00:00",
"cliente": {
"name": "Carlos Almeida",
"cpf": "11122233344",
"birthDate": "1988-07-15",
"uf": "SP",
"monthPayment": 7000.00
},
"cartaoOfertados": [
{
"tipo": "CARTAO_SEM_ANUIDADE",
"limite": 1000.00,
"status": "APROVADO"
}
]
}

