package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseTest;
import util.TestUtil;

public class LoginPage extends BaseTest{

	//Define Page factory i.e OR
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
//	@FindBy(xpath="//input[@type='submit'][@value='Login']")
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLnk;
	
	@FindBy(xpath="//input[contains(text(),'Logout')]")
	WebElement logout;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		//wait = new WebDriverWait(driver, TestUtil.IMPLICIT_WAIT);
	}
	
	//Actions:
	public String validateTitle() {
		return driver.getTitle();
	}
	
	//Login Credentials 
	public HomePage login(String us, String Pwd) {
		username.clear();
		username.sendKeys(us);
		password.clear();
		password.sendKeys(Pwd);
		loginBtn.sendKeys(Keys.ENTER);
		/*Actions actions = new Actions(driver);
		actions.moveToElement(loginBtn).click().build().perform();*/
		
		//This method should return Homepage class object [retun type becomes Homepage]
		return new HomePage();
	}
	
	public void clickLogoutLink() {
		logout.click();
	}
	
}
