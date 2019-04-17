package com.qa.orangeHRM.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangeHRM.TestBase.TestBase;

public class UserManagementPage extends TestBase {
	
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']")
	private WebElement adminTab;
	
	@FindBy(name="btnAdd")
	private WebElement userAddBtn;
	
	@FindBy(xpath="//h1[@id='UserHeading']")
	private WebElement userAddPageInfo;
	
	@FindAll({@FindBy(xpath="//input[contains(@class,'formInputText')]")})
	private List<WebElement> addUserFields;
	
	@FindBy(name="btnSave")
	private WebElement addUserSaveBtn;
	
	public UserManagementPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void naviagteToAdminTab(){
		adminTab.click();
	}
	
	public String naviagteToAddUserScreen(){
		userAddBtn.click();
		return userAddPageInfo.getText();
	}
	
	public void enterUserDeatilsAndSave(String empname, String userName, String password, String confirmPassword){
		
		ArrayList<String> userData= new ArrayList<String>();
		userData.add(empname);
		userData.add(userName);
		userData.add(password);
		userData.add(password);
		
		for(int i=0; i<addUserFields.size();i++ ){
			addUserFields.get(i).sendKeys(userData.get(i));
			addUserSaveBtn.click();
		}
	}
}
