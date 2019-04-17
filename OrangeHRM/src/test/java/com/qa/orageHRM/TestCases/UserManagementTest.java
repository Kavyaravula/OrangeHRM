package com.qa.orageHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.orangeHRM.Pages.HomePage;
import com.qa.orangeHRM.Pages.LoginPage;
import com.qa.orangeHRM.Pages.UserManagementPage;
import com.qa.orangeHRM.TestBase.TestBase;
import com.qa.orangeHRM.TestUtil.TestUtil;

public class UserManagementTest extends TestBase {
	public TestBase testbase;
	public LoginPage loginpage;
	public HomePage homepage;
	public UserManagementPage umpage;
	public TestUtil testutil;
	
	public UserManagementTest(){
		super();
	}
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String nameOfBrowser){
		testbase= new TestBase();
		testbase.selectBrowserAndOpenURL(nameOfBrowser);
		loginpage= new LoginPage();
		homepage=loginpage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
		umpage= new UserManagementPage();
		umpage.naviagteToAdminTab();
		
	}
	
	@Test(priority=1)
	public void verifyNavigationToAddUserScreen(){
		String AdduserPageHeading=umpage.naviagteToAddUserScreen();
		Assert.assertEquals(AdduserPageHeading, "Add User");
	}
	
	
	@DataProvider(name="UserDetails", parallel = true )
	public Object[][] getDataFromExcel(){
		testutil= new TestUtil();
		return testutil.readExcelDate("C:\\Users\\Chintu\\workspace\\OrangeHRM\\src\\main\\java\\com\\qa\\orangeHRM\\TestData\\AddUsers.xlsx");
	}
	
	@Test(priority=2, dataProvider="UserDetails", threadPoolSize = 2, invocationCount = 1)
	public void addUsers(String empNAME, String userNAME, String strPassword, String strConfirmPassword ){
		umpage.naviagteToAddUserScreen();
		umpage.enterUserDeatilsAndSave(empNAME, userNAME, strPassword, strConfirmPassword);
		
	}

	
	@AfterMethod
	public void tearDown3(){
		driver.quit();
	}
}
