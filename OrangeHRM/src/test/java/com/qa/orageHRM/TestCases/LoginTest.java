package com.qa.orageHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.orangeHRM.Pages.HomePage;
import com.qa.orangeHRM.Pages.LoginPage;
import com.qa.orangeHRM.TestBase.TestBase;

public class LoginTest extends TestBase {
	public LoginPage loginpage;
	public TestBase testbase;
	public HomePage homepage;
	public LoginTest(){
		super();
	}
	
	@BeforeMethod (groups={"Regression","Smoke"})
	@Parameters({"browser"})
	public void setUp(String strBrowser){
		testbase= new TestBase();
		testbase.selectBrowserAndOpenURL(strBrowser);
		loginpage= new LoginPage();
	}
	
	@Test(priority=1,enabled=true, groups={"Regression"})
	
	public void verifyLogoTest(){
		
		boolean flag=loginpage.verifyOrangeHRMLogo();
		Assert.assertTrue(flag);	
		
	}

	@Test(priority=2, groups={"Regression","Smoke"})
	public void verifyLoginTest(){
		homepage=loginpage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean falg=homepage.userInfodeatails.isDisplayed();
		Assert.assertTrue(falg);
	}
	
	@AfterMethod (groups={"Regression","Smoke"})
	
	public void tearDown(){
		driver.quit();
	}
}
