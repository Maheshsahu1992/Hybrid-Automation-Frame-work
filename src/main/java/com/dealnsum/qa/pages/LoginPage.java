package com.dealnsum.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dealnsum.qa.base.TestBase;
import com.dealnsum.qa.util.Utils;

public class LoginPage extends TestBase {
    
	//Page Factory/Object Repository
	
	@FindBy(xpath="//span[contains(text(),' Login/Signup')]")
	WebElement loginSignupButton;
	
	@FindBy(id="tabEmail")
	WebElement username;
	
	@FindBy(id="PwdViewer")
	WebElement password;
	
	@FindBy(id="Btnlogin")
	WebElement LoginButton;
	
	@FindBy(id="TabSignup")
	WebElement SignUpButton;
	
	@FindBy(xpath="//span[contains(text(),'show')]")
	WebElement ShowButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password')]")
	WebElement ForgetPasswordLink;
	
	@FindBy(xpath="//h3[contains(text(),'log into DealNSUM')]")
	WebElement LoginPageLogo;
	
	
	//Initialization Objects
	
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	//Actions/Methods
	
	public String ValidateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean PageLogo(){
		return LoginPageLogo.isDisplayed();
	}
	public HomePage Login(String UN,String PW){
		//loginSignupButton.click();
		username.sendKeys(UN);
		password.sendKeys(PW);
		LoginButton.click();
		return new HomePage();
	}
	public void ClickSignupSigniButton(){
		WebDriverWait wait=new WebDriverWait(driver,Utils.explicit_wait);
		WebElement ele=wait.until(ExpectedConditions.visibilityOf(loginSignupButton));
		ele.click();
	}
	public RegistrationPage ClickOnSignUpButton(){
		SignUpButton.click();
		return new RegistrationPage();
	}
	

}
