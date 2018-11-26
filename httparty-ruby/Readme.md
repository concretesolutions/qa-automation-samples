Projeto usado para apresentação do Coders on Beers de QA da Concrete no dia 21/11
Foco em passagem de conhecimento em como realizar testes de serviço

## Passo a Passo

Abra o terminal e execute o comando abaixo :
```
bundle install      
```

Vamos instalar  o servidor Json-server:
```
npm install -g json-server
```
Agora vamos rodar o servidor Json-Server:

```
json-server --watch endpoints.json
````

O resultado será esse: 
```
\{^_^}/ hi!

Loading db.json
Done

Resources
http://localhost:3000/clientes

Home
http://localhost:3000

Type s + enter at any time to create a snapshot of the database
Watching...

```

## Executando os testes

Abra uma nova aba e digite o comando abaixo:

```
cucumber
```

## Referências
Acesso o github do <a href="https://github.com/danilopolicarpos/Httparty
l">danilopolicarpos/Httparty</a>