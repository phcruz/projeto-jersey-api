# projeto-jersey-api

Projeto de criação de API utilizando o framework Jersey.
Criação de CRUD em memória para exemplificar a criação de endpoints.

O modelo Usuário contem os campos abaixo:
id, nome, email e senha.

A API cria 3 usuários padrão, no qual é possível alterá-los, excluí-los, consulta-los e criar novos usuários.

 - Para criação de novos usuários:
Acessar a URL http://localhost:8080/projeto-jersey-api/usuario realizando um POST com os dados do usuário na corpo da requisição.

 - Para edição de novo usuários:
Acessar a URL http://localhost:8080/projeto-jersey-api/usuario realizando um PUT com os dados do usuário na corpo da requisição juntamente com o id do usuário.

 - Para buscar um usuário:
Acessar a URL http://localhost:8080/projeto-jersey-api/usuario/{id} realizando um GET substituindo o "{id}" pelo valor do id a ser consultado.

 - Para listar os usuários:
Acessar a URL http://localhost:8080/projeto-jersey-api/usuario realizando um GET na URL.

 - Para excluir um usuário:
Acessar a URL http://localhost:8080/projeto-jersey-api/usuario/{id} realizando um DELETE substituindo o "{id}" pelo valor do id a ser deletado.
