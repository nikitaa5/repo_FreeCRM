package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class ContactsPageTest extends BaseTest{

	String sheetname = "ContactDetails"; // if this variable is set private the application throws null pointer exception
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		contactPage = new ContactsPage();
		
	}
	
	/*@Test(priority=1)
	public void verifyContactLabelTest() {
		Assert.assertTrue(contactPage.verifyContactLabel(),"Contact label not found");
	}*/
	
	//To Call data from excel file we need data provider which is always to be added inside testcase
	@DataProvider
	public Object[][] getContactTestData() {
		System.out.println("Inside Data Provider : getContactTestDAta");
		Object[][] Contactdata = TestUtil.getTestData(sheetname);
		return Contactdata;
	}
	
	@Test(priority=1, dataProvider="getContactTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
		System.out.println("Data getting called from excel file");
		testUtil.switchToFrame();
		homePage.clickOnContacts_NewContact();
//		contactPage.createNewContact("Mr.", "Micheal", "Jackson", "Dell");
		contactPage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

