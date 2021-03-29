package automacao.steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import automacao.funcionalidade.CriarConta;
import automacao.util.ChromeContext;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastroStep extends ChromeContext {
	
	private CriarConta criarConta;
	
	public CadastroStep() throws IOException {
		criarConta = new CriarConta();
	}
	
	@Dado("^que tenho uma rota valida para o site da \"([^\"]*)\"$")
	public void que_tenho_uma_rota_valida_para_o_site_da(String site) throws Throwable {
		startWebDriver();
		inputURL(site);
		System.out.println("Site acessado com sucesso!");
	}

	@E("^entra na funcionalidade de cadastrar novo usuario$")
	public void entra_na_funcionalidade_de_cadastrar_novo_usuario() throws Throwable {
		criarConta.clicarLinkSignIn();
		System.out.println("Funcionalidade de cadastro acessada com sucesso!");
	}

	@Quando("^preenche os dados do novo usuario$")
	public void preenche_os_dados_do_novo_usuario() throws Throwable {
		criarConta.criarContaEtapa1();
		criarConta.criarContaEtapa2();
		System.out.println("Campos preenchidos com sucesso!");
	}

	@Entao("^finalizo o cadastro$")
	public void finalizo_o_cadastro() throws Throwable {
		criarConta.clicarBotaoRegister();
		System.out.println("Cadastro realizado com sucesso!");		
	}

	@E("^Valido se cadastrado com sucesso$")
	public void valido_se_cadastrado_com_sucesso() throws Throwable {
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", criarConta.validarMensagemCriarConta());
	}
	
	@E("^finalizo o teste$")
	public void finalizo_o_teste() throws Throwable {	
		stopWebDriver();
		System.out.println("Teste finalizado com sucesso!");
	}
}