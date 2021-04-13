$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/testesFuncionais/Teste.feature");
formatter.feature({
  "name": "exemplo de  teste de API com Cumcumber",
  "description": "Este projeto é um exemplo de testes de API com Cucumber",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Consultar os dados de um usuário;",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "fazer uma requisicao",
  "keyword": "Quando "
});
formatter.match({
  "location": "stepDefinitions.Step.fazerUmaRequisicao()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "devo visualizar os dados",
  "keyword": "Entao "
});
formatter.match({
  "location": "stepDefinitions.Step.devoVisualizarOsDados()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Adicionar um novo usuário",
  "description": "",
  "keyword": "Cenário"
});
formatter.step({
  "name": "que quero adicionar um novo usuario",
  "keyword": "Dado "
});
formatter.match({
  "location": "stepDefinitions.Step.ajdQueroAdicionarUmNovoUsuario()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fazer um post",
  "keyword": "Quando "
});
formatter.match({
  "location": "stepDefinitions.Step.fazerUmPost()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "devo receber cadastro com sucesso",
  "keyword": "Entao "
});
formatter.match({
  "location": "stepDefinitions.Step.devoReceberCadastroComSucesso()"
});
formatter.result({
  "status": "passed"
});
});