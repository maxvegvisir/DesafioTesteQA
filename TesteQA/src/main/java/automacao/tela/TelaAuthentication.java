package automacao.tela;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automacao.util.ChromeContext;

public class TelaAuthentication extends ChromeContext {
	
	public WebElement campoEmailAddress() {
		return getDriver().findElement(By.xpath("//input[@id=\"email_create\"]"));
	}
	
	public WebElement botaoCreateAnAccount() {
		return getDriver().findElement(By.xpath("//button[@id=\"SubmitCreate\"]"));
	}
}
