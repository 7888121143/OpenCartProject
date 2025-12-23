package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("***** Starting TC002_LoginTest *****");
		
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("pwd"));
		lp.clickLogin();
		
		
		MyAccountPage ma = new MyAccountPage(driver);
		boolean targetPage = ma.isMyAccountPageExist();
		{
			Assert.assertEquals(targetPage, true,"Login Failed");
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC002_LoginTest *****");
	}
}

	
	

