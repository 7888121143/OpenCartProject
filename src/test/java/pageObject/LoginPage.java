package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtEmailPassword;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnLogin;
	
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		txtEmailPassword.sendKeys(pwd);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	
}
