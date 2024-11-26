package testsPack;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.AccountSuccess;
import pages.LandingPage;
import pages.NewsletterSubscriptionPage;
import pages.RegisterPage;
import utilitiesPackage.Utilities;

public class RegisterTest extends Base {
	
	public WebDriver driver;
	LandingPage landingpage;
	RegisterPage registerpage;
	AccountSuccess accountsuccess;

	
@AfterMethod
public void tearDown() {
	driver.quit();
}
@BeforeMethod
public void setUp() {
	
	driver=openApplicationURLInTheBrowser(prop.getProperty("browser"));
	
	 landingpage=new LandingPage(driver);
	landingpage.clickonMyAccount();
	
	registerpage=landingpage.clickOnRegister();
	
	//driver.findElement(By.className("caret")).click();
	//driver.findElement(By.linkText("Register")).click();
	
}
	
	
@Test(priority=2)
	public void verifyRegisteredAccounts() {
		// TODO Auto-generated method stub
	
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("firstname"));
		registerpage.enterLastName(prop.getProperty("lastname"));		
		registerpage.enterEmailAddress(Utilities.generateNewEmail());		
		registerpage.enterTelephoneNumber(prop.getProperty("telephonenumber"));		
		registerpage.enterPassword(prop.getProperty("validpassword"));
		registerpage.enterPasswordConfirm(prop.getProperty("validpassword"));		
		registerpage.selectPrivacyPolicy();
		accountsuccess=registerpage.enterContinue();
		//registerpage.enterContinue();
		
		accountsuccess=new AccountSuccess(driver);
		Assert.assertTrue(accountsuccess.isLogoutOptionAvailable());
		Assert.assertTrue(accountsuccess.isSuccessAvailable());
		
		String expectedline1="Your Account Has Been Created!";
		String expectedline2="Congratulations! Your new account has been successfully created!";
		String expectedline3="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedline4="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedline5="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		String expectedline6=" contact us.";
		
		String actuallines=accountsuccess.isContentDisplayed();
		
		Assert.assertTrue(actuallines.contains(expectedline1));
		Assert.assertTrue(actuallines.contains(expectedline2));
		Assert.assertTrue(actuallines.contains(expectedline3));
		Assert.assertTrue(actuallines.contains(expectedline4));
		Assert.assertTrue(actuallines.contains(expectedline5));
		Assert.assertTrue(actuallines.contains(expectedline6));
		
		driver=accountsuccess.clickContinueButton();
		
		AccountPage accountpage=new AccountPage(driver);
		Assert.assertTrue(accountpage.navigatedToAccountPage());
		
		
		

	}
@Test(priority=1)
public void verifyRegisteringaccountsUsingAllFields()
{
	
	RegisterPage registerpage=new RegisterPage(driver);
	AccountSuccess accountsuccess=new AccountSuccess(driver);
	registerpage.enterFirstName(prop.getProperty("firstname"));
	registerpage.enterLastName(prop.getProperty("lastname"));		
	registerpage.enterEmailAddress(Utilities.generateNewEmail());		
	registerpage.enterTelephoneNumber(prop.getProperty("telephonenumber"));		
	registerpage.enterPassword(prop.getProperty("validpassword"));
	registerpage.enterPasswordConfirm(prop.getProperty("validpassword"));
	registerpage.newsLetterYes();
	registerpage.selectPrivacyPolicy();
	registerpage.enterContinue();
	Assert.assertTrue(accountsuccess.isLogoutOptionAvailable());
	Assert.assertTrue(accountsuccess.isSuccessAvailable());	
	String expectedline1="Your Account Has Been Created!";
	String expectedline2="Congratulations! Your new account has been successfully created!";
	String expectedline3="You can now take advantage of member privileges to enhance your online shopping experience with us.";
	String expectedline4="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
	String expectedline5="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
	String expectedline6=" contact us.";
	String actuallines=accountsuccess.isContentDisplayed();
	Assert.assertTrue(actuallines.contains(expectedline1));
	Assert.assertTrue(actuallines.contains(expectedline2));
	Assert.assertTrue(actuallines.contains(expectedline3));
	Assert.assertTrue(actuallines.contains(expectedline4));
	Assert.assertTrue(actuallines.contains(expectedline5));
	Assert.assertTrue(actuallines.contains(expectedline6));
	driver=accountsuccess.clickContinueButton();
	AccountPage accountpage=new AccountPage(driver);
	Assert.assertTrue(accountpage.navigatedToAccountPage());
	
}
@Test(priority=3)
public void verifyRegistrationBySayingNewsletterNo() {
	
	RegisterPage registerpage=new RegisterPage(driver);
	AccountSuccess accountsuccess=new AccountSuccess(driver);
	registerpage.enterFirstName(prop.getProperty("firstname"));
	registerpage.enterLastName(prop.getProperty("lastname"));		
	registerpage.enterEmailAddress(Utilities.generateNewEmail());		
	registerpage.enterTelephoneNumber(prop.getProperty("telephonenumber"));		
	registerpage.enterPassword(prop.getProperty("validpassword"));
	registerpage.enterPasswordConfirm(prop.getProperty("validpassword"));
	registerpage.newsLetterNo();
	registerpage.selectPrivacyPolicy();
	registerpage.enterContinue();
	Assert.assertTrue(accountsuccess.isLogoutOptionAvailable());
	Assert.assertTrue(accountsuccess.isSuccessAvailable());	
	String expectedline1="Your Account Has Been Created!";
	String expectedline2="Congratulations! Your new account has been successfully created!";
	String expectedline3="You can now take advantage of member privileges to enhance your online shopping experience with us.";
	String expectedline4="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
	String expectedline5="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
	String expectedline6=" contact us.";
	String actuallines=accountsuccess.isContentDisplayed();
	Assert.assertTrue(actuallines.contains(expectedline1));
	Assert.assertTrue(actuallines.contains(expectedline2));
	Assert.assertTrue(actuallines.contains(expectedline3));
	Assert.assertTrue(actuallines.contains(expectedline4));
	Assert.assertTrue(actuallines.contains(expectedline5));
	Assert.assertTrue(actuallines.contains(expectedline6));
	driver=accountsuccess.clickContinueButton();
	AccountPage accountpage=new AccountPage(driver);
	Assert.assertTrue(accountpage.navigatedToAccountPage());
	driver=accountpage.subscribeNewsLetter();
	
	NewsletterSubscriptionPage newsletterSubscriptionPage=new NewsletterSubscriptionPage(driver);
	
	Assert.assertTrue(newsletterSubscriptionPage.isNoNewsletterOption());
	
	
}
@Test(priority=4)
public void verifyRegistrationBySayingNewsletterYes() {
	
	RegisterPage registerpage=new RegisterPage(driver);
	AccountSuccess accountsuccess=new AccountSuccess(driver);
	registerpage.enterFirstName(prop.getProperty("firstname"));
	registerpage.enterLastName(prop.getProperty("lastname"));		
	registerpage.enterEmailAddress(Utilities.generateNewEmail());		
	registerpage.enterTelephoneNumber(prop.getProperty("telephonenumber"));		
	registerpage.enterPassword(prop.getProperty("validpassword"));
	registerpage.enterPasswordConfirm(prop.getProperty("validpassword"));
	registerpage.newsLetterYes();
	registerpage.selectPrivacyPolicy();
	registerpage.enterContinue();
	Assert.assertTrue(accountsuccess.isLogoutOptionAvailable());
	Assert.assertTrue(accountsuccess.isSuccessAvailable());	
	String expectedline1="Your Account Has Been Created!";
	String expectedline2="Congratulations! Your new account has been successfully created!";
	String expectedline3="You can now take advantage of member privileges to enhance your online shopping experience with us.";
	String expectedline4="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
	String expectedline5="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
	String expectedline6=" contact us.";
	String actuallines=accountsuccess.isContentDisplayed();
	Assert.assertTrue(actuallines.contains(expectedline1));
	Assert.assertTrue(actuallines.contains(expectedline2));
	Assert.assertTrue(actuallines.contains(expectedline3));
	Assert.assertTrue(actuallines.contains(expectedline4));
	Assert.assertTrue(actuallines.contains(expectedline5));
	Assert.assertTrue(actuallines.contains(expectedline6));
	driver=accountsuccess.clickContinueButton();
	AccountPage accountpage=new AccountPage(driver);
	Assert.assertTrue(accountpage.navigatedToAccountPage());
	accountpage.subscribeNewsLetter();
	
	NewsletterSubscriptionPage newsletterSubscriptionPage=new NewsletterSubscriptionPage(driver);
	Assert.assertTrue(newsletterSubscriptionPage.isYesNewsletterOption());
	
	
}
	
}
