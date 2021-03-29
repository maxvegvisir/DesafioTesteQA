package automacao.steps;

import org.junit.Assert;

import automacao.funcionalidade.CadastrarUsuario;
import automacao.util.ChromeContext;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PessoaWebSteps extends ChromeContext{
	
	private CadastrarUsuario cadU = new CadastrarUsuario();

	@Dado("^tenho uma rota valida para o cadastro de usuario$")
	public void tenho_uma_rota_valida_para_o_cadastro_de_usuario() throws Throwable {
		startWebDriver();
		inputURL("https://automacaocombatista.herokuapp.com/users/new");
	}
	
	@Dado("^preencho os dados do novo usuario$")
	public void preencho_os_dados_do_novo_usuario() throws Throwable {
		cadU.carregarMassa();
		cadU.preencherNome();
		cadU.preencherUltimoNome();
		cadU.preencherEmail();
		cadU.preencherEndereco();
		cadU.preencherUniversidade();
		cadU.preencherProfissao();
		cadU.preencherGenero();
		cadU.preencherIdade();
	}
	
	@Quando("^crio o usuario$")
	public void realizo_a_cricao_do_usuario() throws Throwable {
	   cadU.clicarBotaoCriar();
	}
	
	@Entao("^e apresentado de usuario cadastrado$")
	public void e_apresentado_de_usuario_cadastrado() throws Throwable {
	  cadU.validarTelaUsuarioCadastrado();
	}

	@Entao("^valido a mensagem de \"([^\"]*)\"$")
	public void valido_a_mensagem_de(String mensagem) throws Throwable {
	
		Assert.assertEquals("Falha ao cadastrar novo Usuario\n Era esperado " + mensagem + " mas foi "
				+ cadU.pegarMensagemUsuarioCadastrado() + ".", cadU.pegarMensagemUsuarioCadastrado(), mensagem);
	}

	@Entao("^finalizo o teste$")
	public void finalizo_o_teste() throws Throwable {
	   stopWebDriver();
	}


}
