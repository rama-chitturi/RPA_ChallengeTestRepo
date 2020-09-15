package com.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChallengeFollowingSibling {
	
	static WebDriverWait wait;
	static ChallengeFollowingSibling ch;
	static WebDriver driver;
	static String Website_URL = "https://www.rpachallenge.com";	
	
	@FindBy(xpath=".//button[text()='Start']") 
	WebElement startBtn;
	@FindBy(xpath=".//label[text()='First Name']/following-sibling::input")
	WebElement firstNameEle;	
	@FindBy(xpath=".//label[text()='Last Name']/following-sibling::input")
	 WebElement lastNameEle;
	@FindBy(xpath=".//label[text()='Email']/following-sibling::input")
	 WebElement emailELe;
	@FindBy(xpath=".//label[text()='Company Name']/following-sibling::input")
	 WebElement companyNameELe;
	@FindBy(xpath=".//label[text()='Role in Company']/following-sibling::input")
	 WebElement roleInCompanyEle;
	@FindBy(xpath=".//label[text()='Phone Number']/following-sibling::input")
	 WebElement phoneNumberEle;
	@FindBy(xpath=".//label[text()='Address']/following-sibling::input")
	 WebElement addressEle;
	@FindBy(xpath=".//input[@value='Submit']")
	 WebElement submitBtn;
	
	public ChallengeFollowingSibling(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
		System.out.println("Constructor called");
	}
		
	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    wait = new WebDriverWait(driver, 30);
	    driver.manage().window().maximize();
		ch = new ChallengeFollowingSibling(driver);
		ch.Chalenge_method();

	}
	public void Chalenge_method() throws IOException
	{
	driver.get(Website_URL);
	int count=1;
	ArrayList<String> data = ch.Excel(count);
	wait.until(ExpectedConditions.visibilityOf(startBtn)).click();
	while(count<=10)
	{
	firstNameEle.sendKeys(data.get(0));
	lastNameEle.sendKeys(data.get(1));
	companyNameELe.sendKeys(data.get(2));
	roleInCompanyEle.sendKeys(data.get(3));
	addressEle.sendKeys(data.get(4));
	emailELe.sendKeys(data.get(5));
	phoneNumberEle.sendKeys(data.get(6));
	submitBtn.click();
	count++;
	data = ch.Excel(count);
	}
	}
	
	public ArrayList<String> Excel(int rownum) throws IOException
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
