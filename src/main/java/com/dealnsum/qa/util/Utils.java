package com.dealnsum.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.dealnsum.qa.base.TestBase;

public class Utils extends TestBase {
	
	public static long Page_load_timeout=30;
	public static  long implicit_wait=30;
	public static  long explicit_wait=30;
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public void SwitchToFrame(String FrameName){
		driver.switchTo().frame("FrameName");
	}
	
	public Utils(String FilePath){
		try{
			File file=new File(FilePath);
			FileInputStream fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public String GetExcelData(String SheetName,int rownum,int cellnum){
		sheet=wb.getSheet(SheetName);
		XSSFRow row=sheet.getRow(rownum);
		String data=row.getCell(cellnum).getStringCellValue();
		return data;
	}
	public int GetRowCount(int SheetIndex){
		int row=wb.getSheetAt(SheetIndex).getLastRowNum();
		row=row+1;
		return row;
	}
	public void GetScreenShot(String ImageName) throws IOException{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File fileloc=new File("C:\\Users\\Admin\\workspace\\DealNsumAutomation\\Screenshot");
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String ActualImg=ImageName+fileloc+"_"+sdf.format(cal.getTime())+".png";
		File file=new File(ActualImg);
		FileUtils.copyFile(srcfile, file);
	}

	
}
