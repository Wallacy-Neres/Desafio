# API Desafio

## Introdução a API de transação
Esta API tem como objetivo receber transações e dá estatísticas sob essas transações, as estatísticas retornadas pertecem as transações realizadas nos últimos 60 segundos.

## Tecnologias
- Java
- Spring Boot
- Docker

# Como Executar

## Docker

Basta baixar a imagem da API através do comando:

docker pull wallacyneres/teste_itau:latest

Após o dowload da imagem basta procura-lá com o comando: docker images

E então utilizar o comando:

docker run -p[Porta_que_deseja_subir_o_docker:Port_API_Spring] ID_da_Imagem

Porta API Spring trata-se da 8080.

## Github

Basta clonar o projeto do repesitório do git hub: https://github.com/Wallacy-Neres/Desafio

Após o clone, é preciso abrir a IDE e importar o projeto, lembrando de selecinar a opção projeto Maven.

Feito isto a aplicação estará pronta para ser executada.

## Autenticação

Todas as rotas são públicas.

# Códigos da API

** 200 - OK ** 

Esta requisição foi bem sucedida. O significado do sucesso varia de acordo com o método HTTP: ("Listar transações ou listar estatisticas de transações")

** 201 - Created **

Requisição bem sucedida e um novo recurso foi criado como resultado: ("Uma nova transação")

** 204 - No Content **

Não há conteúdo para enviar para esta solicitação: ("Deletar todas as transações")

** 400 - Bad Request **

Servidor não entendeu a requisição pois está com uma sintaxe inválida: ("Exemplo: Erro ao preencher o JSON na criação de uma nova transação via Postman ou Insomnia")

** 422 - Unprocessable Entity **

A requisição está bem formada mas inabilitada para ser seguida devido a erros semânticos: ("Tentar cadastrar uma transação com data futura")

- Rotas da API
- Rota para cadastrar uma nova transação ("/transacao")
- Rota para listar todas as transações ("/listar")
- Rota para listar estatísticas de transações ("/estatistica")
- Rota para deletar todas as transações ("/transacao")

# Endpoints

@GetMapping("/listar") - Responsável por buscar todas as transações e devolver no corpo da requisição todas as transações cadastradas.

@GetMapping("/estatistica") - Responsável por buscar todas as transações realizadas nos últimos 60 segundos e devolver no corpo da requisição o número de transações, mínima, máxima, média e soma.

@PostMapping("/transacao") - Responsável por cadastrar uma nova transação, mas não devolve nada no corpo da requisição.

@DeleteMapping("/transacao") - Responsável por deletar todas as transações, não devolve nada no corpo da requisição.
