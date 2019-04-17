package com.qa.orangeHRM.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangeHRM.TestBase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy (xpath="//a[@id='welcome' and contains(text(),'Admin')]")
	public WebElement userInfodeatails;
	
	@FindAll({@FindBy(xpath="//a//b")})
	private List<WebElement> links;
	
	@FindBy(xpath="//b[contains(text(),'Admin')]")
	private WebElement btnAdmin;
	
	@FindBy(xpath="//a[@id='menu_admin_Job']")
	private WebElement btnJob;
	
	@FindBy(xpath="//a[contains(text(),'Job Titles')]")
	private WebElement btnJobTitles;
	
	@FindBy(xpath="//h1[contains(text(),'Job Titles')]")
	private WebElement jobTitlesInfo;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	public ArrayList<String> verifyLinks(){
		
		ArrayList<String> strLinks= new ArrayList<String>();
		for (int i=0; i< links.size();i++){
			strLinks.add(links.get(i).getText());
			
		}
		return strLinks;
	}
	
	public void moveToJobTitles(){
		Actions action = new Actions(driver);
		action.moveToElement(btnAdmin).build().perform();
		action.moveToElement(btnJob).build().perform();
		btnJobTitles.click();
		
		
	}
	
	public boolean verifyJobTitleInfo(){
		return jobTitlesInfo.isDisplayed();
		
	}
}
