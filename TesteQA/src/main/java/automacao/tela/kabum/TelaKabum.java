package automacao.tela.kabum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automacao.util.ChromeContext;

public class TelaKabum extends ChromeContext {
	
	public WebElement barraPesquisa() {
		return getDriver().findElement(By.xpath("//input[@class=\"sprocura\"]"));
	}
	
	public WebElement botaoPesquisar(){
		return getDriver().findElement(By.xpath("//input[@id=\"bt-busca\"]"));
	}
	
	public Integer recuperaQntItensPagina(){
		return getDriver().findElements(By.xpath("//div[@id=\"listagem-produtos\"]//div[@class=\"sc-fzqARJ eITELq\"]")).size();
	}
	
	public String recuperarItemEstaDisponivel(int i) {
		return getDriver().findElement(By.xpath("//div[@id=\"listagem-produtos\"]//div[@class=\"sc-fzqARJ eITELq\"]["+i+"]//div[@class=\"sc-fznKkj fEpBwY\"]//img")).getAttribute("src");
	}
	
	public String recuperarPrecoCheio(int i) {
		return getDriver().findElement(By.xpath("//div[@id=\"listagem-produtos\"]//div[@class=\"sc-fzqARJ eITELq\"]["+i+"]//div[@class=\"sc-fznxsB ksiZrQ\"]")).getText();
	}
	
	public String recuperarPrecoDesconto(int i) {
		return getDriver().findElement(By.xpath("//div[@id=\"listagem-produtos\"]//div[@class=\"sc-fzqARJ eITELq\"]["+i+"]//div[@class=\"sc-fznWqX qatGF\"]")).getText();
	}
	
	public String recuperarTextoLinkItem(int i) {
		//div[@id="listagem-produtos"]//div[@class="sc-fzqARJ eITELq"][1]//div[@class="sc-fzozJi dIEkef"]//a
		return getDriver().findElement(By.xpath("//div[@id=\"listagem-produtos\"]//div[@class=\"sc-fzqARJ eITELq\"]["+i+"]//div[@class=\"sc-fzozJi dIEkef\"]//a")).getText();
	}
	
	public boolean verificaPaginacaoProximo() {
		try {
			return getDriver().findElement(By.xpath("//div[@class=\"sc-fznWOq hEjrXm\"]")).isEnabled();
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public WebElement botaoPaginacaoProximo() {
		return getDriver().findElement(By.xpath("//div[@class=\"sc-fznWOq hEjrXm\"]"));
	}

}
