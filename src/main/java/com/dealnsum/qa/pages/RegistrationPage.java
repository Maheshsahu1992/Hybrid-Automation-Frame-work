package com.dealnsum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dealnsum.qa.base.TestBase;

public class RegistrationPage extends TestBase {
	
	//CUSTOMER RELATED WEBELEMENT DETAILS
	@FindBy(xpath="//label[@for='tab1']")
	WebElement CustomerTabButton;
	
	@FindBy(xpath="//h3[contains(text(),'New Customer')]")
	WebElement NewCustomerLableName;
	
	@FindBy(xpath="//h5[contains(text(),'Enter your details. No credit card required.')]")
	WebElement EnterYourDetailsLableName;
	
	@FindBy(xpath="//span[contains(text(),'Already have account ?')]")
	WebElement AlreadyHaveAccountLableName;
	
	@FindBy(id="tabSignin")
	WebElement SignInButtonInCustomerTab;
	
	@FindBy(xpath="//span[contains(text(),'show')and @onclick='myFunction()']")
	WebElement ShowButtonInCustomerTab;
	
	@FindBy(id="SubmitButton")
	WebElement CreateAccountButton;
	
	@FindBy(xpath="(//a[contains(text(),'Terms of Use')])[1]")
	WebElement TermsOfUseLink;
	
	@FindBy(xpath="(//a[contains(text(),'Privacy Policy')])[1]")
	WebElement PrivacyPolicyLink;	
	
	@FindBy(xpath="(//p[contains(text(),'By clicking 'Create account' I agree to DealNSum ')])[1]")
	WebElement LableNameOfTermsAndConditions;
	
	@FindBy(id="EmailId")
	WebElement EmailField;
	
	@FindBy(xpath="//input[@id='Name'and@ name='ObjCustomer.FirstName']")
	WebElement NameField;
	
	@FindBy(xpath="//input[@id='PwdViewer' and@ name='ObjCustomer.Password']")
	WebElement PasswordField;
	
	@FindBy(xpath="//input[@id='cust-phone-number-field' and@ name='ObjCustomer.Phone']")
	WebElement ContactNumberField;
	
	//VENDOR RELATED WEBELEMENTS DETAILS
	
	@FindBy(xpath="//label[@for='tab2']")
	WebElement VendorTabButton;
	
	public RegistrationPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean GetCustomerTabLableName(){
		return NewCustomerLableName.isDisplayed();
	}
	public LoginPage ClickOnSignInButton(){
		SignInButtonInCustomerTab.click();
		return new LoginPage();
	}
	public Boolean VerifyCustomerTab(){
		return CustomerTabButton.isSelected();
	}
	public HomePage RegisterNewCustomer(String EmailId,String Name,String Password,String PhoneNumber){
		EmailField.sendKeys(EmailId);
		NameField.sendKeys(Name);
		PasswordField.sendKeys(Password);
		ContactNumberField.sendKeys(PhoneNumber);
		CreateAccountButton.click();
		return new HomePage();
	}

}
