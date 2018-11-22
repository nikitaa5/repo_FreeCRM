package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.ContactsPage;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TasksPage;
import util.TestUtil;

public class HomePageTest extends BaseTest{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskpage;
	
	public HomePageTest() {
		super(); //will call Base class constructor and property will get initaited
	}
	
	@BeforeMethod
	public void setUp() {
	//initialize browser and open site
		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		dealspage = new DealsPage();
		contactspage = new ContactsPage();
		taskpage = new TasksPage();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		
		System.out.println("Home Page setup method executed : " +homepage.verifyHomePageTitle());
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String ActualHomePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(ActualHomePageTitle, "CRMPRO", "Title not found.");
	}
	
	@Test(priority=2)
	public void activeUserTest() {
		testUtil.switchToFrame();
		boolean Username = homepage.verifyLoggedUser();
		Assert.assertTrue(Username);
	}
	
	@Test(priority=5)
	public void clickMenuContactsTest() {
		testUtil.switchToFrame();
		//As clickOnContactMenu () is return 'ContactsPage object . We will store following in the contactsPage object
		contactspage = homepage.clickOnContactMenu();
		
	}
	
	@Test(priority=3)
	public void clickMenuDealsTest() {
		testUtil.switchToFrame();
		dealspage = homepage.clickOnDealsMenu();
	}
	
	@Test(priority=4)
	public void clickMenuTasksTest() {
		testUtil.switchToFrame();
		taskpage = homepage.clickOnTasksMenu();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
