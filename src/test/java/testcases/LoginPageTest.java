package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class LoginPageTest extends BaseTest {
	LoginPage loginpage;
	HomePage homepage ; //Homepage object
//	TestUtil testUtil;
	//Create constructor with super keyword
	public LoginPageTest() {
		/*super keyword calls Constructor of parent class, where we have initialise properties
		 * This helps to void 'Null pointer expception when initialization() is called with 'prop' object
		 */
		super(); 
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	//	testUtil = new TestUtil();
	}

	@Test(priority =1)
	public void VerifyLoginPageTitleTest() {
		String pageTitle = loginpage.validateTitle();
		Assert.assertEquals(pageTitle, "#1 Free CRM software in the cloud for sales and service");
		
	}
	
	@Test(priority=2)
	public void validLoginTest() {
		
		//Chat screen pop-up
		/*WebElement chatScr = driver.findElement(By.xpath("//div[@class='intercom-chat-card intercom-chat-card-borderless intercom-chat-card-with-avatar']"));
		if(chatScr.isDisplayed()==true) {
			System.out.println("Chat Screen Interrupt");
			driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']")).click();
		}*/
		/*
		 * This becomes like Homepage homepage = new Homepage [login() returns homepage object]
		 * So we write homepage = loginpage.login();
		 */
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		
//		loginpage.clickLogoutLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
