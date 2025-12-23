package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")	//getting data provider from different class
	public void verify_login_DDT(String email,String pwd,String exp)
	{
		
		logger.info("**** starting TC003_LoginDDT ****");
		try
		{
		//HomePage
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage ma = new MyAccountPage(driver);
		boolean targetPage = ma.isMyAccountPageExist();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				ma.cliclLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(false);
				ma.cliclLogout();
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** starting TC003_LoginDDT ****");
	}
	
}
