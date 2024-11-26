package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccess {
	WebDriver driver;
	
public AccountSuccess(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}
@FindBy(linkText="Logout")
private WebElement logoutOption;
@FindBy(linkText="Success")
private WebElement successBreadcrum; 
@FindBy(id="content")
private WebElement contentdisplay;
@FindBy(linkText="Continue")
private WebElement continueButton;

public boolean isLogoutOptionAvailable() {
	
	return logoutOption.isDisplayed();
}
public boolean isSuccessAvailable() {
	
	return successBreadcrum.isDisplayed();
	
}
public String isContentDisplayed() {
	
	return contentdisplay.getText();
}
public WebDriver clickContinueButton()
{
	
	 continueButton.click();
	return driver;
}


}
