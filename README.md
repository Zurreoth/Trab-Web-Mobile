# Trab-Web-Mobile

# Requisições REST
# Livro
Listar: 
URL: /livros
Metodo: GET
Variaveis: nomeLivro:String e Paginador

GetById: 
URL: /livros/{id}
Metodo: GET

Cadastrar: 
URL: /livros
Metodo: POST
Body:
{
    "nome" : "nome",
    "autor" : "autor",
    "resenha" : "resenha"
}

Alterar: 
URL: /livros/{id}
Metodo: PUT
Body:
{
    "nome" : "nome",
    "autor" : "autor",
    "resenha" : "resenha"
}

Deletar: 
URL: /livros/{id}
Metodo: DELETE

# Usuario
Listar: 
URL: /usuarios
Metodo: GET

GetById: 
URL: /usuarios/{id}
Metodo: GET

Cadastrar: 
URL: /usuarios
Metodo: POST
Body:
{
    "nome" : "nome",
    "senha" : "senha"
}

Alterar: 
URL: /usuarios/{id}
Metodo: PUT
Body:
{
    "nome" : "nome",
    "senha" : "senha"
}

Deletar: 
URL: /usuarios/{id}
Metodo: DELETE

# Status
Listar: 
URL: /status
Metodo: GET

GetById: 
URL: /status/{id}
Metodo: GET

Cadastrar: 
URL: /status
Metodo: POST
Body:
{
    "status": "status", //Valores aceitos LENDO, LIDO, PLANEJO_LER e PAREI
    "usuario": idUsuario,
    "livro": idLivro,
    "nota": nota
}

Alterar: 
URL: /status/{id}
Metodo: PUT
Body:
{
    "status": "status", //Valores aceitos LENDO, LIDO, PLANEJO_LER e PAREI
    "usuario": idUsuario,
    "livro": idLivro,
    "nota": nota
}

Deletar: 
URL: /status/{id}
Metodo: DELETE
