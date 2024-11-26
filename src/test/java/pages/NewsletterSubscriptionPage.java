package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterSubscriptionPage {
	WebDriver driver;
	
public 	NewsletterSubscriptionPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}
@FindBy(xpath="//input[@value='0']")
private WebElement noNewLetter;
@FindBy(xpath="//input[@value='1']")
private WebElement yesNewsLetter; 
public boolean isNoNewsletterOption() {
	
	return noNewLetter.isSelected();
}
public boolean isYesNewsletterOption() {
	
	return yesNewsLetter.isSelected();
}
}
