package automacao.funcionalidade;

import java.io.IOException;

import org.json.JSONObject;

import automacao.tela.TelaCadastro;
import automacao.util.CarregarMassaJson;

public class CadastrarUsuario extends TelaCadastro{
	
	private CarregarMassaJson massa = new CarregarMassaJson();
	private JSONObject massaJsonObject = new JSONObject();
	
	public void carregarMassa() throws IOException{
		massaJsonObject = massa.recuperarMassaJson("massaNovoUsuarioWeb.json");
	}
	

	public void preencherNome() {
		caixaNome().sendKeys(massaJsonObject.get("nome").toString());
	}

	public void preencherUltimoNome() {
		caixaUltimoNome().sendKeys(massaJsonObject.get("ultimoNome").toString());
	}

	public void preencherEmail() {
		caixaEmail().sendKeys(massaJsonObject.get("email").toString());
	}

	public void preencherEndereco() {
		caixaEndereco().sendKeys(massaJsonObject.get("endereco").toString());
	}

	public void preencherUniversidade() {
		caixaUniversidade().sendKeys(massaJsonObject.get("universidade").toString());
	}

	public void preencherProfissao() {
		caixaProfissao().sendKeys(massaJsonObject.get("profissao").toString());
	}

	public void preencherGenero() {
		caixaGenero().sendKeys(massaJsonObject.get("genero").toString());
	}

	public void preencherIdade() {
		caixaIdade().sendKeys(massaJsonObject.get("idade").toString());
	}

	public void clicarBotaoCriar() {
		botaoCriar().click();
	}
	
	public void validarTelaUsuarioCadastrado(){
		barraNoticia();
	}
	
	public String pegarMensagemUsuarioCadastrado(){
		return barraNoticia().getText();
	}

}
