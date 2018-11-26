#language: pt

Funcionalidade: Utilizar o verbo GET

@get
Cenario: Realizar uma requisição GET com sucesso
  Dado que tenho um endpoint clientes
  Quando realizar uma requisição GET para o endpoint "clientes"
  E retorna a lista com as informacoes dos clientes
  Então o status code '200'
