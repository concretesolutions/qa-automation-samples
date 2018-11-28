# language: pt

@teste
Funcionalidade: Teste appium

  @teste01
  Cenário: Portador com apenas um cartão para aviso de viagem
    Dado que tenha  aberto o app
    Quando clicar no formulário
    E e colocar o meu nome "Fulado"
    E salvar a alteração
    Então irei visualizar o meu nome na tela
