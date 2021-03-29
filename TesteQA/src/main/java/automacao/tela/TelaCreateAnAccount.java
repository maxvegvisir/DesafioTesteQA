package automacao.tela;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import automacao.util.ChromeContext;

public class TelaCreateAnAccount extends ChromeContext {
	
	public WebElement campoTitle1() {		
		return getDriver().findElement(By.xpath("//div//span//input[@id=\"id_gender1\"]"));
	}
	
	public WebElement campoTitle2() {
		return getDriver().findElement(By.xpath("//div//span//input[@id=\"id_gender2\"]"));
	}
	
	public WebElement campoFirstName() {
		return getDriver().findElement(By.xpath("//input[@id=\"customer_firstname\"]"));
	}
	
	public WebElement campoLastName() {
		return getDriver().findElement(By.xpath("//input[@id=\"customer_lastname\"]"));
	}
	
	public WebElement campoPassword() {
		return getDriver().findElement(By.xpath("//input[@id=\"passwd\"]"));
	}

	public Select campoDateOfBirthDay() {
		return new Select(getDriver().findElement(By.xpath("//select[@id=\"days\"]")));
	}
	
	public Select campoDateOfBirthMonth() {
		return new Select(getDriver().findElement(By.xpath("//select[@id=\"months\"]")));
	}
	
	public Select campoDateOfBirthYear() {
		return new Select(getDriver().findElement(By.xpath("//select[@id=\"years\"]")));
	}
	
	public WebElement campoNewsletter() {
		return getDriver().findElement(By.xpath("//input[@id=\"newsletter\"]"));
	}
	
	public WebElement campoOffers() {
		return getDriver().findElement(By.xpath("//input[@id=\"optin\"]"));
	}
	
	public WebElement campoCompany() {
		return getDriver().findElement(By.xpath("//input[@id=\"company\"]"));
	}
	
	public WebElement campoAddress1() {
		return getDriver().findElement(By.xpath("//input[@id=\"address1\"]"));
	}
	
	public WebElement campoAddress2() {
		return getDriver().findElement(By.xpath("//input[@id=\"address2\"]"));
	}
	
	public WebElement campoCity() {
		return getDriver().findElement(By.xpath("//input[@id=\"city\"]"));
	}
	
	public Select campoState() {
		return new Select(getDriver().findElement(By.xpath("//select[@id=\"id_state\"]")));
	}
	
	public WebElement campoPostalCode() {
		return getDriver().findElement(By.xpath("//input[@id=\"postcode\"]"));
	}
	
	public WebElement campoAdditionalInformation() {
		return getDriver().findElement(By.xpath("//textarea[@id=\"other\"]"));
	}
	
	public WebElement campoPhone() {
		return getDriver().findElement(By.xpath("//input[@id=\"phone\"]"));
	}
	
	public WebElement campoPhoneMobile() {
		return getDriver().findElement(By.xpath("//input[@id=\"phone_mobile\"]"));
	}
	
	public WebElement botaoRegister() {
		return getDriver().findElement(By.xpath("//button[@id=\"submitAccount\"]"));
	}	
}