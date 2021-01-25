package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChallengeBase {

	static public WebDriverWait wait;
	static public  WebDriver driver;
	static String Website_URL = "https://www.rpachallenge.com";	

	public void driverConfig() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get(Website_URL);

	}

	public static ArrayList<String> Excel(int rownum) throws IOException
	{
		File file = new File("Files//challenge.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb =  new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);

		ArrayList<String> datalist = new ArrayList<String>();
		/*firstName,lastName, companyName, roleName, address,email, Phno;*/
		XSSFRow row;
		String data = null;
		int cellnum;
		row = sh.getRow(rownum);
		for(cellnum=0;cellnum<row.getLastCellNum();cellnum++)
		{
			DataFormatter formatter = new DataFormatter();	
			data = formatter.formatCellValue(row.getCell(cellnum));

			datalist.add(data);
		}
		return datalist;	
	}


}


