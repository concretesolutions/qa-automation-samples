Dado(/^que tenho um endpoint clientes$/) do
  # lista para o endpoint clientes em endpoints.json
end

Quando(/^realizar uma requisição GET para o endpoint "([^"]*)"$/) do |endpoint|
  @response = HTTParty.get 'http://localhost:3000/' + endpoint
end

Entao(/^retorna a lista com as informacoes dos clientes$/) do
  @validator=Helper.new
  @validator.validation_of_type @response [0] ["id"], Fixnum , "id" 
  @validator.validation_of_type @response [0] ["nome"], String , "nome" 
  @validator.validation_of_type @response [0] ["cpf"], String , "cpf" 
  @validator.validation_of_type @response [0] ["sexo"], String , "sexo" 
  @validator.validation_of_type @response [0] ["altura"], Float , "altura"

end

E(/^o status code '(\d+)'$/) do |status_code|
  status_code = status_code.to_i
  expect(@response.code).to eq status_code
end
