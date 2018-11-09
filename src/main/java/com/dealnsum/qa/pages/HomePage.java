package com.dealnsum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dealnsum.qa.base.TestBase;

public class HomePage extends TestBase {
	Actions act=new Actions(driver);
	
	@FindBy(xpath="//h4[contains(text(),'DNS’s Season of Sizzling Summer Deals')]//following::i[@class='fa fa-times'][1]")
	WebElement popup;
	
	@FindBy(xpath="//span[contains(text(),'Mahesh')]")
	WebElement UserNameLable;
	
	@FindBy(xpath="//img[@src='/assets/images/NewSite/list-menu.png']")
	WebElement MenuButton;
	
	@FindBy(xpath="//a[contains(text(),'Cards')]")
	WebElement CardsButton;
	
	@FindBy(xpath="//a[@id='MyAccount']//img[@src='/assets/images/NewSite/icon-user.png']")
	WebElement MyAccountButton;
	
	@FindBy(xpath="//a[@href='/Account/Settings']")
	WebElement SettingButton;
	
	
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
    public void ClosePopup(){
    	popup.click();
    }
    public String VerifyHomePageTitle(){
    	return driver.getTitle();
    }
    public CardsPage ClickOnCardsMenu(){
    	WebDriverWait wait=new WebDriverWait(driver,30);
    	WebElement element=wait.until(ExpectedConditions.visibilityOf(CardsButton));
    	element.click();
    	return new CardsPage();
    	
    }
    public void MoveToMyAccount(){
    	act.moveToElement(MyAccountButton);
    }
    public Boolean VerifyUserName(){
    	act.moveToElement(MyAccountButton).moveToElement(UserNameLable).perform();
    	return UserNameLable.isDisplayed();
    }
    public MySettingPage ClickOnSettingButton(){
        act.moveToElement(MyAccountButton).moveToElement(SettingButton).click().perform();
        return new MySettingPage();
    }
    public void ClickOnMenuButton(){
    	MenuButton.click();
    }
  
    


}
