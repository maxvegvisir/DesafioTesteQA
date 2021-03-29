package automacao.steps;

import org.junit.Assert;

import automacao.api.API;
import automacao.enuns.EnumURL;
import automacao.util.CarregarMassaJson;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PessoaSteps {

	private API api = new API();
	private CarregarMassaJson massa = new CarregarMassaJson();

	@Dado("^que tenho um url de cadastro valida$")
	public void que_tenho_um_url_de_cadastro_valida() throws Throwable {
		api.setRouteNoProxy(EnumURL.URLBASE.getOpcao() + EnumURL.URLCADASTROCONTATOS.getOpcao());
	}
	
	@Dado("^que tenho um url de cadastro de usuario valida$")
	public void que_tenho_um_url_de_cadastro_de_usuario_valida() throws Throwable {
		api.setRouteNoProxy(EnumURL.URLBASE.getOpcao() + EnumURL.URLCADASTROUSUARIOS.getOpcao());
	}
	
	

	/*@Dado("^que tenho uma url de consulta por telefone valida$")
	public void que_tenho_uma_url_de_consulta_por_telefone_validade() throws Throwable {
		api.setRouteNoProxy(EnumURL.URLBASE.getOpcao());
		api.setRoutePath(EnumURL.URLCONSULTATELEFONE.getOpcao());
	}*/

	@Dado("^preencho os headers$")
	public void preencho_os_headers() throws Throwable {
		api.setHeader("Content-Type", "application/json");
		api.setHeader("Accept", "application/vnd.tasksmanager.v2");
	}

	@E("^tenho dados validos para o cadastro de um usuario$")
	public void tenho_dados_validos_para_o_cadastro_de_um_usuario() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaNovoUsuario.json"));
	}
	
	@E("^tenho dados validos senha em branco$")
	public void tenho_dados_validos_senha_em_branco() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaSenhaBranco.json"));
	}
	
	@E("^tenho dados validos confirmar senha não é igual$")
	public void tenho_dados_validos_confirmar_senha_nao_e_igual() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaSenhaDiferente.json"));
	}
	
	@E("^tenho dados validos para email ja em uso$")
	public void tenho_dados_validos_para_email_ja_em_uso() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaEmailUso.json"));
	}
	
	
	@E("^tenho dados validos para o cadastro de uma pessoa$")
	public void tenho_dados_validos_para_o_cadastro_de_uma_pessoa() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaNovaPessoa.json"));
	}

	@E("^tenho dados validos para email nao valido$")
	public void tenho_dados_validos_para_email_nao_valido() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaEmailNaoValido.json"));
	}
	
	@E("^tenho dados validos para email em branco$")
	public void tenho_dados_validos_para_email_em_branco() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaEmailBranco.json"));
	}
	
	@E("^tenho dados validos para usuario ja em uso$")
	public void tenho_dados_validos_para_usuario_ja_em_uso() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaUsuarioJaEmUso.json"));
	}
	
	@E("^tenho dados validos para usuario com nome em branco$")
	public void tenho_dados_validos_para_usuario_com_nome_em_branco() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaUsuarioNomeBranco.json"));
	}
	
	
	@E("^tenho dados validos para age nao numerico$")
	public void tenho_dados_validos_para_age_nao_numerico() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaAgeNaoNumerico.json"));
	}
	
	@E("^tenho dados validos para phone nao numerico$")
	public void tenho_dados_validos_para_phone_nao_numerico() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaPhoneNaoNumerico.json"));
	}
	
	@E("^tenho dados validos de uma pessoa ja cadastrada com o mesmo CPF$")
	public void tenho_dados_validos_de_uma_pessoa_ja_cadastrada_com_o_mesmo_CPF() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaPessoaJaCadastradaCPF.json"));
	}

	@E("^tenho dados validos de uma pessoa ja cadastrada com o mesmo telefone$")
	public void tenho_dados_validos_de_uma_pessoa_ja_cadastrada_com_o_mesmo_telefone() throws Throwable {
		api.setRequestBody(massa.recuperarMassaJson("massaPessoaJaCadastradaTelefone.json"));
	}

	@Quando("^realizo uma chamada ([\\w\\s/*]+)$")
	public void realizo_uma_chamada_POST(String chamada) throws Throwable {
		api.setMetodo(chamada);
	}

	@E("^o status e igual a ([\\w\\s/*]+)$")
	public void o_status_igual_a(String status) throws Throwable {
		Assert.assertEquals("A ultima resposta HTTP não teve o status esperado\n Era esperado " + status + " mas foi "
				+ api.getStatusCode() + ".", api.getStatusCode(), Integer.parseInt(status));
	}

	@Entao("^e apresentado o caminho da chamada$")
	public void e_apresentado_o_caminho_da_chamada() throws Throwable {
		System.out.println(api.getResponseUri() + "\n" + api.getResponseHeader());
	}

	@E("^e apresentado o retorno da chamada$")
	public void e_apresentado_o_retorno_da_chamada() throws Throwable {
		System.out.println(api.getResponseString());
	}

	@E("^valido se o campo \"([^\"]*)\" da resposta e igual \"([^\"]*)\"$")
	public void valido_se_o_campo_da_resposta_e_igual(String campo, String valor) throws Throwable {
		api.validoCampoValorResposta(campo, valor);
	}

	@E("^utilizo o ddd \"([^\"]*)\"$")
	public void utilizo_o_ddd(String ddd) throws Throwable {
		api.realizarReplaceUrl("{ddd}", ddd);
	}
/*
	@E("^utilizo o numero \"([^\"]*)\"$")
	public void utilizo_o_numero(String numero) throws Throwable {
		api.realizarReplaceUrl("{numero}", numero);
	}*/

}
