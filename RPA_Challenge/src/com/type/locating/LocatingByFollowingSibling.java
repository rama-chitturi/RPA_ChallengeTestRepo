package com.type.locating;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.base.ChallengeBase;

public class LocatingByFollowingSibling extends ChallengeBase {


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

	public static ChallengeBase cbObj;
	public static LocatingByFollowingSibling cfsObj ;


	public LocatingByFollowingSibling() throws IOException
	{
		PageFactory.initElements(ChallengeBase.driver, this);	
	}

	public static void main(String[] args) throws IOException
	{
		cbObj = new ChallengeBase();
		cbObj.driverConfig();
		cfsObj = new LocatingByFollowingSibling(); // to Initate elements
		cfsObj.challengeMethod();
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
