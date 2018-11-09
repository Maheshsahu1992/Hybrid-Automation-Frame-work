package com.dealnsum.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dealnsum.qa.base.TestBase;
import com.dealnsum.qa.pages.CardsPage;
import com.dealnsum.qa.pages.HomePage;
import com.dealnsum.qa.pages.HomePageBeforeLogin;
import com.dealnsum.qa.pages.LoginPage;

public class CardsPageTest extends TestBase {
	
	CardsPage cardspage;
	LoginPage loginpage;
	HomePageBeforeLogin hbl;
	HomePage homepage;
	
	public CardsPageTest(){
		super();
	}
	@BeforeMethod
	public void SetUp(){
		getbrowser("chrome");
		hbl=new HomePageBeforeLogin();
		hbl.ClickOnSigninSignUpButton();
		loginpage=new LoginPage();
		loginpage.Login(pr.getProperty("username"),pr.getProperty("password"));
		homepage=new HomePage();
		homepage.ClickOnMenuButton();
		cardspage=homepage.ClickOnCardsMenu();
		cardspage=new CardsPage();
		
	}
	@Test
	public void VerifyCardsTextName(){
		String actual=cardspage.GetCardsTextName();
		Assert.assertEquals(actual,"CARDS");
	}
	@Test
	public void VerifyFiltering() throws InterruptedException{
		cardspage.SelectBusinessTypes("2");
		Thread.sleep(6000);
		cardspage.SelectVendor(1);
		String Actual=driver.findElement(By.xpath("//h3[contains(text(),'ALLTYPENEW PLUS')]")).getText();
		Assert.assertEquals(Actual,"ALLTYPENEW PLUS");
	}
	
	@AfterMethod
	public void TearDown(){
		driver.quit();
	}
	

}
