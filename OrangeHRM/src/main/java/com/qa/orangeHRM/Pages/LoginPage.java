package com.qa.orangeHRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangeHRM.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//img[@src='/webres_5ca6658021cd89.53008077/themes/default/images/login/logo.png']")
	private WebElement oragneHRMLogo;
	
	@FindBy(name="txtUsername")
	private WebElement userName;
	
	@FindBy(name="txtPassword")
	private WebElement passwordIP;
	
	@FindBy(xpath="//input[@name='Submit' and @class='button']")
	private WebElement loginBtn;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOrangeHRMLogo(){
		return oragneHRMLogo.isDisplayed();
	}
	
	public HomePage verifyLogin(String struUsername, String strPassword){
		userName.sendKeys(struUsername);
		passwordIP.sendKeys(strPassword);
		loginBtn.click();
		return new HomePage();
		
	}
}
