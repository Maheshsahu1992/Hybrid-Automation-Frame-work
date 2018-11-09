package com.dealnsum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dealnsum.qa.base.TestBase;

public class HomePageBeforeLogin extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),' Login/Signup')]")
	WebElement SigninSignUpButton;
	
	public HomePageBeforeLogin(){
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage ClickOnSigninSignUpButton(){
		SigninSignUpButton.click();
		return new LoginPage();
	}

}
