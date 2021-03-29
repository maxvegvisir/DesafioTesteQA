#language: pt
#encoding: UTF-8
Funcionalidade: Validar Funcionalidade da API cadastro de Usuario

  @cadastrarUsuario
  Cenario: verificar o cadastro de um usuario com sucesso
    Dado que tenho um url de cadastro de usuario valida
    E preencho os headers
    E tenho dados validos para o cadastro de um usuario
    Quando realizo uma chamada POST
    Entao e apresentado o caminho da chamada
    E e apresentado o retorno da chamada
    E o status e igual a 201

  @senhaEmBranco
  Cenario: verificar no cadastro senha não pode esta em branco
    Dado que tenho um url de cadastro de usuario valida
    E preencho os headers
    E tenho dados validos senha em branco
    Quando realizo uma chamada POST
    Entao e apresentado o caminho da chamada
    E e apresentado o retorno da chamada
    E o status e igual a 422
    E valido se o campo "errors.password[0]" da resposta e igual "não pode ficar em branco"

  @senhaDiferentes
  Cenario: verificar no cadastro confirmar senha não é igual
    Dado que tenho um url de cadastro de usuario valida
    E preencho os headers
    E tenho dados validos confirmar senha não é igual
    Quando realizo uma chamada POST
    Entao e apresentado o caminho da chamada
    E e apresentado o retorno da chamada
    E o status e igual a 422
    E valido se o campo "errors.password_confirmation[0]" da resposta e igual "não é igual a Password"

  @emailJaEmUsuao
  Cenario: verificar no cadastro email ja em uso
    Dado que tenho um url de cadastro de usuario valida
    E preencho os headers
    E tenho dados validos para email ja em uso
    Quando realizo uma chamada POST
    Entao e apresentado o caminho da chamada
    E e apresentado o retorno da chamada
    E o status e igual a 422
    E valido se o campo "errors.email[0]" da resposta e igual "já está em uso"
