package automacao.funcionalidade;

import java.io.IOException;
import org.json.JSONObject;

import automacao.tela.TelaHome;
import automacao.tela.TelaAuthentication;
import automacao.tela.TelaCreateAnAccount;
import automacao.tela.TelaMyAccount;

import automacao.util.CarregarMassaJson;

public class CriarConta {
	
	public CriarConta () throws IOException {
		carregarMassa();
	}
	
	// Telas
	private TelaHome telaHome = new TelaHome();
	private TelaAuthentication telaAuthentication = new TelaAuthentication();
	private TelaCreateAnAccount telaCreateAnAccount = new TelaCreateAnAccount();
	private TelaMyAccount telaMyAccount = new TelaMyAccount();
	
	// Massa JSON
	private CarregarMassaJson massa = new CarregarMassaJson();
	private JSONObject massaJsonObject = new JSONObject();
	
	// Dados da massa
	public void carregarMassa() throws IOException{
		massaJsonObject = massa.recuperarMassaJson("massaCriarConta.json");
	}	

	public void clicarLinkSignIn() {
		telaHome.linkSignIn().click();
	}
	
	public void preencherCampoEmailAddress() {
		telaAuthentication.campoEmailAddress().sendKeys(massaJsonObject.get("email").toString());
	}
	
	public void clicarBotaoCreateAnAccountn() {
		telaAuthentication.botaoCreateAnAccount().click();
	}
	
	public void criarContaEtapa1() {
		preencherCampoEmailAddress();
		clicarBotaoCreateAnAccountn();		
	}
	
	public void selecionarCampoTitle() {
		String textoTitle = massaJsonObject.get("title").toString();
		
		if(textoTitle.equals("Mr.")) {
			telaCreateAnAccount.campoTitle1().click();
		} else if (textoTitle.equals("Mrs.")) {
			telaCreateAnAccount.campoTitle2().click();
		}
	}
	
	public void preencherCampoFirstName() {
		telaCreateAnAccount.campoFirstName().sendKeys(massaJsonObject.get("firstName").toString());
	}
	
	public void preencherCampoLastName() {
		telaCreateAnAccount.campoLastName().sendKeys(massaJsonObject.get("lastName").toString());
	}
	
	public void preencherCampoPassword() {
		telaCreateAnAccount.campoPassword().sendKeys(massaJsonObject.get("password").toString());
	}
	
	public void selecionarCampoDateOfBirthDay() {
		telaCreateAnAccount.campoDateOfBirthDay().selectByValue(massaJsonObject.get("dateOfBirthDay").toString());
	}
	
	public void selecionarCampoDateOfBirthMonth() {
		telaCreateAnAccount.campoDateOfBirthMonth().selectByValue(massaJsonObject.get("dateOfBirthMonth").toString());
	}
	
	public void selecionarCampoDateOfBirthYear() {
		telaCreateAnAccount.campoDateOfBirthYear().selectByValue(massaJsonObject.get("dateOfBirthYear").toString());
	}	
	
	public void selecionarCampoNewsletter() {		
		String textoNewsletter = massaJsonObject.get("newsletter").toString();
		
		if(textoNewsletter.equals("S")) {
			telaCreateAnAccount.campoNewsletter().click();
		}
	}
	
	public void selecionarCampoOffers() {		
		String textoOffers = massaJsonObject.get("offers").toString();
		
		if(textoOffers.equals("S")) {
			telaCreateAnAccount.campoOffers().click();
		}
	}
	
	public void preencherCampoCompany() {
		telaCreateAnAccount.campoCompany().sendKeys(massaJsonObject.get("company").toString());
	}
	
	public void preencherCampoAddress1() {
		telaCreateAnAccount.campoAddress1().sendKeys(massaJsonObject.get("address1").toString());
	}
	
	public void preencherCampoAddress2() {
		telaCreateAnAccount.campoAddress2().sendKeys(massaJsonObject.get("address2").toString());
	}
	
	public void preencherCampoCity() {
		telaCreateAnAccount.campoCity().sendKeys(massaJsonObject.get("city").toString());
	}
	
	public void selecionarCampoState() {
		telaCreateAnAccount.campoState().selectByValue(massaJsonObject.get("state").toString());
	}
	
	public void preencheCampoPostalCode() {
		telaCreateAnAccount.campoPostalCode().sendKeys(massaJsonObject.get("postCode").toString());
	}
	
	public void preencherCampoAdditionalInformation() {
		telaCreateAnAccount.campoAdditionalInformation().sendKeys(massaJsonObject.get("additionalInformation").toString());
	}
	
	public void preencherCampoPhone() {
		telaCreateAnAccount.campoPhone().sendKeys(massaJsonObject.get("homePhone").toString());
	}
	
	public void preencherCampoPhoneMobile() {
		telaCreateAnAccount.campoPhoneMobile().sendKeys(massaJsonObject.get("mobilePhone").toString());
	}
	
	public void clicarBotaoRegister() throws InterruptedException {
		telaCreateAnAccount.botaoRegister().click();
		
		Thread.sleep(5000);
	}
	
	public void criarContaEtapa2() throws InterruptedException {
		Thread.sleep(5000);
		
		selecionarCampoTitle();
		preencherCampoFirstName();
		preencherCampoLastName();
		preencherCampoPassword();
		selecionarCampoDateOfBirthDay();
		selecionarCampoDateOfBirthMonth();
		selecionarCampoDateOfBirthYear();
		selecionarCampoNewsletter();
		selecionarCampoOffers();
		preencherCampoCompany();
		preencherCampoAddress1();
		preencherCampoAddress2();
		preencherCampoCity();
		selecionarCampoState();
		preencheCampoPostalCode();
		preencherCampoAdditionalInformation();
		preencherCampoPhone();
		preencherCampoPhoneMobile();
	}
	
	public String validarMensagemCriarConta() throws InterruptedException {
		Thread.sleep(5000);
		
		return telaMyAccount.textoInformacaoConta().getText().toString();	
	}
}