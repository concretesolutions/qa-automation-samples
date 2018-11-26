Dado(/^que altero as informações do endpoint clientes$/) do
    @contatos = {
        "id": 1, 
        "nome": "joao",
        "cpf": "123.456.789-00",
        "sexo": "Feminino",
        "altura": 1.75
      }.to_json
end

Quando(/^realizar uma requisição PUT para o endpoint "([^"]*)"$/) do |endpoint|
    @response = HTTParty.put 'http://localhost:3000/clientes/1',
    :body => @contatos,
    :headers => {
      "Content-Type" => 'application/json'
    }
end
