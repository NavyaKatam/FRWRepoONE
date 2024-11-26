package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
public RegisterPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(id="input-firstname")
private WebElement firstName;

@FindBy(id="input-lastname")
private WebElement lastname;

@FindBy(id="input-email")
private WebElement emailaddress;
@FindBy(id="input-telephone")
private WebElement telephonenumber;
@FindBy(id="input-password")
private WebElement password ;
@FindBy(id="input-confirm")
private WebElement passwordconfirm;
@FindBy(xpath="//input[@value='0']")
private WebElement newsLetterno;
@FindBy(xpath="//label[normalize-space()='Yes']")
private WebElement newsletteryes;
@FindBy(name="agree")
private WebElement privacyPolicy;
@FindBy(xpath="//input[@value='Continue']")
private WebElement entercontinue;


public void enterFirstName(String firstNameText) {
firstName.sendKeys(firstNameText);	
}
public void enterLastName(String lastnameText) {
	lastname.sendKeys(lastnameText);
}
public void enterEmailAddress(String emailText) {
emailaddress.sendKeys(emailText);
}

public void enterTelephoneNumber(String telePhoneText) {
	telephonenumber.sendKeys(telePhoneText);
}

public void enterPassword(String passwordText) {
password.sendKeys(passwordText);
}

public void enterPasswordConfirm(String passwordText) {
	passwordconfirm.sendKeys(passwordText);
}

public void newsLetterNo() {
	newsLetterno.click();
}
public void newsLetterYes() {

	newsletteryes.click();
}

public void selectPrivacyPolicy() {
	
	privacyPolicy.click();
}

public  AccountSuccess enterContinue() {
	
entercontinue.click();
return new AccountSuccess(driver);
}
}

