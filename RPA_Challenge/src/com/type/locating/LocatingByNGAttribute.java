package com.type.locating;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.ChallengeBase;

public class LocatingByNGAttribute extends ChallengeBase {


	public static ChallengeBase cbObj;
	public static LocatingByNGAttribute cengObj ;


	@FindBy(xpath=".//button[text()='Start']") 
	WebElement startBtn;
	@FindBy(xpath=".//input[@ng-reflect-name=\"labelFirstName\"]")
	WebElement firstNameEle;	
	@FindBy(xpath=".//input[@ng-reflect-name=\"labelLastName\"]")
	WebElement lastNameEle;
	@FindBy(xpath=".//input[@ng-reflect-name=\"labelEmail\"]")
	WebElement emailELe;
	@FindBy(xpath=".//input[@ng-reflect-name=\"labelCompanyName\"]")
	WebElement companyNameELe;
	@FindBy(xpath=".//input[@ng-reflect-name=\"labelRole\"]")
	WebElement roleInCompanyEle;
	@FindBy(xpath=".//input[@ng-reflect-name=\"labelPhone\"]")
	WebElement phoneNumberEle;
	@FindBy(xpath=".//input[@ng-reflect-name=\"labelAddress\"]")
	WebElement addressEle;
	@FindBy(xpath=".//input[@value='Submit']")
	WebElement submitBtn;



	public LocatingByNGAttribute() throws IOException
	{
		PageFactory.initElements(ChallengeBase.driver, this);	
	}

	public static void main(String[] args) throws IOException
	{
		cbObj = new ChallengeBase();
		cbObj.driverConfig();
		cengObj = new LocatingByNGAttribute(); // To initiate elements
		cengObj.challengeMethod();
	}

	public void challengeMethod() throws IOException
	{

		int count=1;
		ChallengeBase.wait.until(ExpectedConditions.visibilityOf(startBtn)).click();

		while(count<=10)
		{
			ArrayList<String> data = ChallengeBase.Excel(count);
			firstNameEle.sendKeys(data.get(0));
			lastNameEle.sendKeys(data.get(1));
			companyNameELe.sendKeys(data.get(2));
			roleInCompanyEle.sendKeys(data.get(3));
			addressEle.sendKeys(data.get(4));
			emailELe.sendKeys(data.get(5));
			phoneNumberEle.sendKeys(data.get(6));
			submitBtn.click();
			count++;

		}
	}
}


