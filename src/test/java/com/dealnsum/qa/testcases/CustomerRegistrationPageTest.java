package com.dealnsum.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dealnsum.qa.base.TestBase;
import com.dealnsum.qa.pages.HomePage;
import com.dealnsum.qa.pages.HomePageBeforeLogin;
import com.dealnsum.qa.pages.LoginPage;
import com.dealnsum.qa.pages.RegistrationPage;
import com.dealnsum.qa.util.Utils;

public class CustomerRegistrationPageTest extends TestBase {
	HomePageBeforeLogin beforeloginhomepage;
	LoginPage loginpage;
	RegistrationPage registrationpage;
	HomePage homepage;

	public CustomerRegistrationPageTest(){
		super();
	}
    @BeforeMethod()
    public void SetUp(){
    	getbrowser("Chrome");
    	homepage=new HomePage();
    	beforeloginhomepage=new HomePageBeforeLogin();
    	loginpage=beforeloginhomepage.ClickOnSigninSignUpButton();
    	registrationpage=loginpage.ClickOnSignUpButton();
  
    }
    @Test(priority=3)
    public void VerifyCustomerTabPreSelected(){
    	Boolean actual=registrationpage.VerifyCustomerTab();
    	Assert.assertTrue(actual);
    	
    }
    @Test(priority=2)
    public void VerifyCustomerTabLableName(){
    	Boolean acctual=registrationpage.GetCustomerTabLableName();
    	Assert.assertTrue(acctual);
    }	
    @DataProvider(name="registrationdata")
    public Object[][] PassData(){
    	Utils util=new Utils("src\\main\\java\\com\\dealnsum\\qa\\testdata\\testdata.xlsx");
    	int row=util.GetRowCount(0);
    	Object[][] data=new Object[row][4];
    	for(int i=0;i<row;i++){
    		data[i][0]=util.GetExcelData("Sheet1", i, 0);
    		data[i][1]=util.GetExcelData("Sheet1", i, 1);
    		data[i][2]=util.GetExcelData("Sheet1", i, 2);
    		data[i][3]=util.GetExcelData("Sheet1", i, 3);
    	}
    	return data;
    }
  
    
    @Test(dataProvider="registrationdata")
    public void VerifyCustomerRegistration(String EmailId,String Name,String Password,String PhoneNumber){
    	registrationpage=new RegistrationPage();
    	registrationpage.RegisterNewCustomer(EmailId, Name, Password,PhoneNumber);
    	
    }
   
    
    
    
    @AfterMethod()
    public void TearDown(){
    	driver.quit();
    }

}
