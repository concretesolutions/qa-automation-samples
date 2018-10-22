#language: pt

@example
Funcionalidade: Learning to use the protractor
Como um QA
Quero aprender a utilizar o protractor 
Para então poder automatizar aplicações em angular com sucesso 

Esquema do Cenario: Validar textos no site do angular.org
  Dado que eu esteja na página
  Quando preencher o campo de texto com o "<name>"
  Então verifico que o texto "Hello <name>!" foi validado com sucesso

  Exemplos: 
  | name        |
  | Concrete    |
  | QA Analyst  |
  | Any Name    |