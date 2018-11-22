package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {

	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	public void clickOnLogoutLink() {
		logout.click();
	}
}
