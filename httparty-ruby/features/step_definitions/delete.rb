Dado(/^que envie as informações para deletar$/) do
    @contatos_delete = {
        "id": 1
      }.to_json
end

Quando(/^realizar uma requisição DELETE para o endpoint "([^"]*)"$/) do |endpoint|
    @response = HTTParty.delete 'http://localhost:3000/clientes/1',
    :body => @contatos_delete,
    :headers => {
      "Content-Type" => 'application/json'
    }
end

Entao("retorna a lista de clientes") do 
    expect(@response.code).to eq 404
    expect(@response.size).to eq 0
end