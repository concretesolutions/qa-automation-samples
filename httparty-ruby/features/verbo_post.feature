#language: pt

Funcionalidade: Utilizar o verbo POST

@post
Cenario: Realizar uma requisição POST com sucesso
  Dado que envie as informações para o endpoint clientes
  Quando realizar uma requisição POST para o endpoint "clientes"
  Então o status code '201'
