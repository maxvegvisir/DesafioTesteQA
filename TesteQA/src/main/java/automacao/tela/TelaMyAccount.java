package automacao.tela;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automacao.util.ChromeContext;

public class TelaMyAccount extends ChromeContext {
	
	public WebElement textoInformacaoConta() {
		return getDriver().findElement(By.xpath("//p[@class=\"info-account\"]"));
	}
	
	public WebElement linkHome() {
		return getDriver().findElement(By.xpath("//a[@title=\"Home\"]"));
	}
}