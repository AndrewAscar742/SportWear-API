
# SportWearAPI

Esta API atende a demanda de realizar o CRUD com os Produtos da loja
Esta API foi desenvolvida para um projeto que eu e meus amigos estão
desenvolvendo


## Stack utilizada

**Front-end:** React, SASS

**Back-end:** SpringBoot, Spring Data JPA, MySQL


## Autores

- [@AndrewAscar742](https://www.github.com/AndrewAscar742)


## Funcionalidades

- Adicionar Produtos
- Buscar Produtos no SGDB MySQL (Busca por ID também)
- Remover Produtos
- Alterar Produtos


## Rodando localmente

Abra o projeto no Eclipse

```bash
  O projeto está na pasta Service do projeto SportWear
```

Espere o Maven realizar todas as importações do Projeto

```bash
  O Maven está instalando as dependências do projeto
```

Abra o MySQL e XAMPP

```bash
  MySQL deve estar na Porta 3306
```

Crie uma conexão e um banco de dados

```bash
  O nome do banco deve-se chamar sportWear
  userName= root
  passWord=
```

Inicie sua aplicação

```bash
  O SpringBoot (Tomcat) está utilizando a porta 8080
```


## Documentação da API

Endpoint: http://localhost:8080/produtos

#### Retorna todos os produtos

```http
  GET http://localhost:8080/produtos
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `null` | `null` | **Obrigatório**. Retornar todos os produtos do banco|

#### Retorna um produto

```http
  GET /produtos/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | **Obrigatório**. Retornar o Produto indicado pelo ID |

#### Adiciona um Produto

```http
  POST /produtos
    Header: Content-Type: JSON
        Body: title, img, price, category
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `null`      | `null` | **Obrigatório**. Retornar o Produto Adicionado|

#### Alterar um Produto

```http
  PUT /produtos
    Header: Content-Type: JSON
        Body: title, img, price, category
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `null`      | `null` | **Obrigatório**. Retornar o Produto Alterado|

#### Remover um Produto

```http
  DELETE /produtos/{ID}

```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `null`      | `null` | **Obrigatório**. Deletar um Produto|

## Usado por

Esse projeto é usado por um site (projeto) chamado SportWear

- [@SportWear](https://github.com/joaoabreu004/SPORT_WEAR)



## Feedback

Se você tiver algum feedback, por favor nos deixe saber por meio de andrewmatosascar@outlook.com

