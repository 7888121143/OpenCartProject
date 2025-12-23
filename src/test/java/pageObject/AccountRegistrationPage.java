package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement txtconfirmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkpolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void settelephone(String tel)
	{
		txttelephone.sendKeys(tel);
	}
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void setconfirmpassword(String pwd)
	{
		txtconfirmpassword.sendKeys(pwd);
	}
	public void setPrivacyPolicy()
	{
		chkpolicy.click();
	}
	public void clickContinue()
	{
		//sol 1
		btncontinue.click();
	
		//sol 2
		//btncontinue.submit();
	
		//sol 3
		//Actions act = new Actions(driver);
		//act.moveToElement(btncontinue).click().perform();
	
		//sol 4
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click()",btncontinue);
	
		//sol 5
		//btncontinue.sendKeys(Keys.RETURN);
		
	}
	
	public String getConfirmationmsg() {
		try {
			return (msgconfirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	
}













