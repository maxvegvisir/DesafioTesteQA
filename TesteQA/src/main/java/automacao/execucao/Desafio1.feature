#language: pt
#encoding: UTF-8
Funcionalidade: Validar Cadastro do Site

  @realizarCadastroUsuario
  Cenario: realizar o cadastro de usuario no site automationpractice.com
    Dado que tenho uma rota valida para o site da "http://automationpractice.com/index.php"
    E entra na funcionalidade de cadastrar novo usuario
    Quando preenche os dados do novo usuario
    Entao finalizo o cadastro
    E Valido se cadastrado com sucesso
    E finalizo o teste