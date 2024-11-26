package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(linkText="Edit your account information")
	private WebElement editYourAccount;
@FindBy(linkText="Subscribe / unsubscribe to newsletter")
private WebElement subscribenewsletter;
@FindBy(linkText="Logout")
private WebElement logoutOption; 

public boolean navigatedToAccountPage() {
	
	return editYourAccount.isDisplayed();
}
public WebDriver subscribeNewsLetter() {
	
	subscribenewsletter.click();
	return driver;
}
public boolean isUserLoggedin() {
	
	return logoutOption.isDisplayed();
}


}
