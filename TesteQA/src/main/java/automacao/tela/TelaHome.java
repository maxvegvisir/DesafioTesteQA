package automacao.tela;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automacao.util.ChromeContext;

public class TelaHome extends ChromeContext {
	
	public WebElement linkSignIn() {
		return getDriver().findElement(By.xpath("//a[@class=\"login\"]"));
	}
	
	public WebElement linkSignOut() {
		return getDriver().findElement(By.xpath("//a[@class=\"logout\"]"));
	}
}
