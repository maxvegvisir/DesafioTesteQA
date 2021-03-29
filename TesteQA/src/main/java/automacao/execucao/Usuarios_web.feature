#language: pt
#encoding: UTF-8
Funcionalidade: Validar Funcionalidade da cadastro de Usuario web

  @testeWeb
  Cenario: verificar no cadastro email ja em uso
    Dado tenho uma rota valida para o cadastro de usuario
    E preencho os dados do novo usuario
    Quando crio o usuario
    Entao e apresentado de usuario cadastrado
    E valido a mensagem de "Usuário Criado com sucesso"
    E finalizo o teste

  @BuscarPreçoNaKabum
  Cenario: buscar os preços das placas de videos no site da Kabum
    Dado que tenho uma rota valida para o site da "Kabum"
    E realizo a busca da placa de video "RTX 3070"
    Quando armazeno os dados
    E vejo o melhor preço a vista
    E vejo o melhor preço a prazo
    E finalizo a busca
