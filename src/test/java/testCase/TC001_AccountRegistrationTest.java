package testCase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
		
	@Test(groups={"Regression","Master"})
	public void verify_account_registratin()
	{
		logger.info("***** starting TC001_AccountRegistrationTest *****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Click on MyAccount");
		hp.clickRegister();
		logger.info("Click on Register Link");
		
		AccountRegistrationPage regpage =new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details...");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.settelephone(randomNumber());
		
		String password= randomAlphaNumeric();
		
		regpage.setpassword(password);
		regpage.setconfirmpassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message...");
		String confmsg= regpage.getConfirmationmsg();
		if(confmsg.equals("Your Account Has Been to Created!"))
		{
		Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed...");
			logger.debug("debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been to Created!");
		}
		catch(Exception e)
		{
		
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	
		
}







