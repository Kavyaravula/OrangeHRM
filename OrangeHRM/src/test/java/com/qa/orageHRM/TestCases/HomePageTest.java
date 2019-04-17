package com.qa.orageHRM.TestCases;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.orangeHRM.Pages.HomePage;
import com.qa.orangeHRM.Pages.LoginPage;
import com.qa.orangeHRM.TestBase.TestBase;

public class HomePageTest extends TestBase{
	public TestBase testbase;
	public LoginPage loginpage;
	public HomePage homepage;
	
	public HomePageTest(){
		super();
	}

	
	@BeforeMethod(groups={"Regression"})
	@Parameters({"browser"})
	
	public void setUp(String nameOfBrowser){
		testbase= new TestBase();
		testbase.selectBrowserAndOpenURL(nameOfBrowser);
		loginpage= new LoginPage();
		homepage=loginpage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1,groups={"Regression"})
	public void verifyHomepageLinks(){
		String[] expLinks= {"Admin","PIM","Leave","Time","Recruitment","Performance","Dashboard","Directory","Maintenance"};
		List<String> expLinksList= new ArrayList<String>(); 
		expLinksList= Arrays.asList(expLinks);
		boolean flag= expLinksList.containsAll(homepage.verifyLinks());
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2, groups={"Regression"})
	public void verifyMovetoJobTitlePage(){
		homepage.moveToJobTitles();
		Assert.assertTrue(homepage.verifyJobTitleInfo());
	}
	
	@AfterMethod(groups={"Regression"})
	public void tearDown(){
		driver.quit();
		
	}
}
