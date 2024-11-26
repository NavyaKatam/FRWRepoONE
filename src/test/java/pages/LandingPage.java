package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;

public LandingPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(xpath="//span[normalize-space()='My Account']")
private WebElement MyAccountDropMenu;

@FindBy(linkText="Register")
private WebElement registerOption;

@FindBy(linkText="Login")
private WebElement loginOption;

@FindBy(name="search")
private WebElement searchField;

@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
private WebElement searchButton;

public void clickonMyAccount() {
	MyAccountDropMenu.click();
}
public RegisterPage clickOnRegister() {
	registerOption.click();
	return new RegisterPage(driver);
}
public void clickOnLogin() {
loginOption.click();
}

public WebDriver searchboxField(String searchText) {
	searchField.sendKeys(searchText);
	return driver;

}

public WebDriver clickonSearchButton() {
	searchButton.click();
	return driver;
}


}
