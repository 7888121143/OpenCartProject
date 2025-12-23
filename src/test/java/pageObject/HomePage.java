package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);		//passing the driver to the parent class constructor
	}
	
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement lnkMyaccount;

@FindBy(xpath="//a[normalize-space()='Register']")
WebElement lnkRegister;

@FindBy(xpath="//a[normalize-space()='Login']")    //usrnm =aswapnil40@gmail.com, pass= Swap@777 
WebElement lnkLogin;

//Create action methods
public void clickMyAccount()
{
lnkMyaccount.click();
}
public void clickRegister()
{
	lnkRegister.click();
}
public void clickLogin()
{
	lnkLogin.click();
}

}
