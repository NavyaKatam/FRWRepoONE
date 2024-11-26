package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);

}

@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Login']")
private WebElement loginBreadcrum; 
@FindBy(id="input-email")
private WebElement inputEmailText;
@FindBy(id="input-password")
private WebElement inputPasswordText;
@FindBy(xpath="//input[@value='Login']")
private WebElement loginclick; 
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
private WebElement errorMessage; 
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
private WebElement errormessage;
public 	 boolean loginpageBreadcrum() {
	
	return loginBreadcrum.isDisplayed();
	
}
public void inputEmail(String emailText){
	
inputEmailText.sendKeys(emailText);
}
public void inputPassword(String passwordText) {

inputPasswordText.sendKeys(passwordText);
}

public void loginButton() {
	
	loginclick.click();

}

public String verifyErrorMessage() {
	
	return errorMessage.getText();
}

public boolean checkErrorMessage()
{
	
	return errormessage.isDisplayed();
}

}
