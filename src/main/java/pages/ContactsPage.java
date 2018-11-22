package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseClass.BaseTest;



public class ContactsPage extends BaseTest {
/* Find elements by PageFActory
 * Set functionality methods 
 */
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	/*@FindBy(xpath="//a[contains(text(),'Naveen')]")
	WebElement contactPersonName;*/
	
	@FindBy(xpath="//input[@type='checkbox'][@name='contact_id']")
	WebElement contactChk;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement title_drpdwn;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName_txt;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName_txt;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company_txt;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement save_btn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactLabel() {
		return contactLabel.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		//Check checkbox where contact 
	WebElement contactPersonName =driver.findElement(By.xpath("//a[contains(text(),'" +name +"')]"));
	boolean personName =contactPersonName.isDisplayed();
	if (personName==true) {
		contactChk.click();
		}
	}
	
	public void createNewContact(String title, String firstName, String lastName, String company) {
		Select title_drp = new Select(title_drpdwn);
		title_drp.selectByVisibleText(title);
		
		firstName_txt.sendKeys(firstName);
		lastName_txt.sendKeys(lastName);
		company_txt.sendKeys(company);
		
		save_btn.click();
	}
	
}
