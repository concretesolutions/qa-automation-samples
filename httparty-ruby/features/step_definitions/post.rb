Dado(/^que envie as informações para o endpoint clientes$/) do
    @contatos = {
        "id": 1,
        "nome": "Maria",
        "cpf": "XXXXXXXX",
        "sexo": "Feminino",
        "altura": 1.75
      }.to_json

end

Quando(/^realizar uma requisição POST para o endpoint "([^"]*)"$/) do |endpoint|
  @response = HTTParty.post 'http://localhost:3000/clientes',
  :body => @contatos,
  :headers => {
      "Content-Type" => 'application/json'
}
end
