package com.dealnsum.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dealnsum.qa.base.TestBase;
import com.dealnsum.qa.pages.HomePage;
import com.dealnsum.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		getbrowser("chrome");
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void VarifyLoginPageTitle(){
		String actualresult=loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(actualresult,"DealNSum 2.0");
	}
	@Test(priority=2)
	public void VarifyLoginPageLogo(){
	loginpage.ClickSignupSigniButton();
	boolean actual=loginpage.PageLogo();
	Assert.assertTrue(actual);
	
	}
	@Test(priority=3)
	public void VarifyLogin(){
	loginpage.ClickSignupSigniButton();	
	homepage=loginpage.Login(pr.getProperty("username"),pr.getProperty("password"));
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
