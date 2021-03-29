package automacao.tela;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automacao.util.ChromeContext;

public class TelaCadastro extends ChromeContext{
	
	private WebElement nome;
	private WebElement ultimoNome;
	private WebElement email;
	private WebElement endereco;
	private WebElement universidade;
	private WebElement profissao;
	private WebElement genero;
	private WebElement idade;
	private WebElement criar;
	private WebElement barraNoticia;
	
	
	
	
	public WebElement barraNoticia(){
		barraNoticia = getDriver().findElement(By.xpath("//p[@id='notice']"));
		return barraNoticia;
	}
	
	
	public WebElement caixaNome(){
		nome = getDriver().findElement(By.xpath("//input[@id='user_name']"));
		return nome;
	}
	
	public WebElement caixaUltimoNome(){
		ultimoNome = getDriver().findElement(By.xpath("//input[@id='user_lastname']"));
		return ultimoNome;
	}
	
	public WebElement caixaEmail(){
		email = getDriver().findElement(By.xpath("//input[@id='user_email']"));
		return email;
	}
	
	public WebElement caixaEndereco(){
		endereco = getDriver().findElement(By.xpath("//input[@id='user_address']"));
		return endereco;
	}
	
	public WebElement caixaUniversidade(){
		universidade = getDriver().findElement(By.xpath("//input[@id='user_university']"));
		return universidade;
	}
	
	public WebElement caixaProfissao(){
		profissao = getDriver().findElement(By.xpath("//input[@id='user_profile']"));
		return profissao;
	}
	
	public WebElement caixaGenero(){
		genero = getDriver().findElement(By.xpath("//input[@id='user_gender']"));
		return genero;
	}
	
	public WebElement caixaIdade(){
		idade = getDriver().findElement(By.xpath("//input[@id='user_age']"));
		return idade;
	}
	
	public WebElement botaoCriar(){
		criar = getDriver().findElement(By.xpath("//input[@value='Criar']"));
		return criar;
	}
	

}
