#language: pt

Funcionalidade: Utilizar o verbo DELETE

@delete1
Cenario: Realizar uma requisição DELETE com sucesso
  Dado que envie as informações para deletar 
  Quando realizar uma requisição DELETE para o endpoint "clientes"
  E o status code '200'

@delete2
Cenario: Realizar uma requisição DELETE com sucesso
  Dado que envie as informações para deletar
  Quando realizar uma requisição DELETE para o endpoint "clientes"
  E o status code '404'