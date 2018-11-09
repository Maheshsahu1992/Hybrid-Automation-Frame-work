package com.dealnsum.qa.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dealnsum.qa.base.TestBase;
import com.dealnsum.qa.pages.HomePage;
import com.dealnsum.qa.pages.LoginPage;
import com.dealnsum.qa.pages.MySettingPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	MySettingPage mysettingpage;
	public HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		getbrowser("chrome");
		loginpage=new LoginPage();
		loginpage.ClickSignupSigniButton();
		homepage=loginpage.Login(pr.getProperty("username"),pr.getProperty("password"));
	}
	@Test(priority=1)
	public void  VerifyHomePageTitle(){	
		String actual= homepage.VerifyHomePageTitle();
		Assert.assertEquals(actual,"DealNSum 2.0");
	}
	@Test(priority=2)
	public void VerifyUser() throws InterruptedException{
		homepage.MoveToMyAccount();
		boolean acctual=homepage.VerifyUserName();
		Assert.assertTrue(acctual);
		
	}
	@Test(priority=3)
	public void VerifySettingButton() throws InterruptedException{
		Thread.sleep(5000);
		mysettingpage=homepage.ClickOnSettingButton();
		Thread.sleep(5000);
		
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
    

}
