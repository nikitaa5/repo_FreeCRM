package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseClass.BaseTest;
import util.TestUtil;

public class HomePage extends BaseTest {

	/*
	 * Understand what all things to verify on homepage
	 * create webelement for all elements present on the respecitive pag
	 */
	@FindBy(xpath="//td[contains(text(),'User: Nikita Tandel')]")
	WebElement activeUser;
	
//	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactMenu;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealMenu;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksMenu;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactSbMnu;
	
	//Constructor of Homapage to initialize
	public HomePage() {
		PageFactory.initElements(driver, this); //PageFactory class is an extension of Page Object design pattern
	}
	
	public String verifyHomePageTitle() {
		ExpectedConditions.visibilityOf(activeUser);
		return driver.getTitle();
	}
	
	public boolean verifyLoggedUser() { 
	//	return activeUser.getText();
		return activeUser.isDisplayed();
	}
	
	public ContactsPage clickOnContactMenu() {
		contactMenu.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsMenu() {
		dealMenu.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksMenu() {
		tasksMenu.click();
		return new TasksPage();
		
	}
	
	public ContactsPage clickOnContacts_NewContact() {
		Actions contact_mnu = new Actions(driver);
		contact_mnu.moveToElement(contactMenu).build().perform();
		newContactSbMnu.click();
		return new ContactsPage();
		
	}
	
}
