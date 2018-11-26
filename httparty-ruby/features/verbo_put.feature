#language: pt

Funcionalidade: Utilizar o verbo PUT

@put
Cenario: Realizar uma requisição PUT com sucesso
  Dado que altero as informações do endpoint clientes
  Quando realizar uma requisição PUT para o endpoint "clientes"
  Então o status code '200'