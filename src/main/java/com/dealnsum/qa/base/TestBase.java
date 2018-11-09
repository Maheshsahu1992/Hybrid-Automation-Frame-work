package com.dealnsum.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.dealnsum.qa.util.Utils;
import com.dealnsum.qa.util.WebEventListner;

public class TestBase {

	public static WebDriver driver;
	public static Properties pr;
	public static EventFiringWebDriver edriver;
    static WebEventListner webeventlister;
	
	public TestBase(){
		try{
			pr=new Properties();
			FileInputStream fis=new FileInputStream("src\\main\\java\\com\\dealnsum\\qa\\config\\config.properties");
			pr.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void getbrowser(String Name){
		if(Name.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(Name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","GeckoDriver ver 0.14.0\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		edriver=new EventFiringWebDriver(driver);
		webeventlister=new WebEventListner();
		edriver.register(webeventlister);
		driver=edriver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Utils.Page_load_timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.implicit_wait,TimeUnit.SECONDS);
		driver.get(pr.getProperty("url"));
		
	}
	public static String GetExcelData(String path,String SheetName,int rownum,int cellnum) throws IOException{
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(SheetName);
		String data=sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		//XSSFRow row=sh.getRow(rownum);
		//String data=row.getCell(cellnum).getStringCellValue();
		return data;
		
	}
	public void GetScreenShot(String ImageName) throws IOException{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation="C:\\Users\\Admin\\workspace\\DealNsumAutomation\\Screenshot\\";
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String ActualImg=imagelocation+ImageName+"_"+sdf.format(cal.getTime())+".png";
		File file=new File(ActualImg);
		FileUtils.copyFile(srcfile, file);
	}
	public void GetConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con=DriverManager.getConnection("jdbc:mysql://13.90.209.170//DnSDemo", "DnSdev", "dns@12345");
		Statement st=con.createStatement();
		ResultSet se=st.executeQuery("");
        
		
		
	}
	public static void main(String[]args) throws ClassNotFoundException, SQLException{
		TestBase tb=new TestBase();
		tb.GetConnection();
	}



	
}
