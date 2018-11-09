package com.dealnsum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dealnsum.qa.base.TestBase;

public class CardsPage extends TestBase{
	
	Select sel;
	
	@FindBy(id="BusinessTypeList")
	WebElement BusinessTypesDropdown;
	
	@FindBy(id="selectVendor")
	WebElement VendorDropDown;
	
	@FindBy(xpath="//h2[contains(text(),'Cards')]")
	WebElement CardsTextName;
	
	public CardsPage(){
		PageFactory.initElements(driver,this);
	}
	public void ClickOnBusinessTypesDropdownTextBox(){
		BusinessTypesDropdown.click();
	}
	public void SelectBusinessTypes(String value){
		sel=new Select(BusinessTypesDropdown);
		sel.selectByValue(value);
	}
	public void SelectVendor(int indexnum){
		sel=new Select(VendorDropDown);
		sel.selectByIndex(indexnum);
	
	}
	public String GetCardsTextName(){
		return  CardsTextName.getText();
	}
	
	

}
