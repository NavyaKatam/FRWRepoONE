package testsPack;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.LandingPage;
import pages.LoginPage;
import utilitiesPackage.MyXLSReader;
import utilitiesPackage.Utilities;

public class LoginTest extends Base {
	
	public WebDriver driver;
	
@BeforeMethod
public void setUp()
{	
	driver=openApplicationURLInTheBrowser(prop.getProperty("browser"));
	
	LandingPage landingpage=new LandingPage(driver);
	landingpage.clickonMyAccount();
	landingpage.clickOnLogin();
	
}
@AfterMethod
public void tearDown() {
	driver.quit();
}


@Test(priority=1,dataProvider="datasupplier")
public void verifyLoginUsingValidCredentials(HashMap<String,String> hMap) {
	LoginPage loginpage=new LoginPage(driver);
	Assert.assertTrue(loginpage.loginpageBreadcrum());
	loginpage.inputEmail(hMap.get("UserName"));
	loginpage.inputPassword(hMap.get("Password"));	
	loginpage.loginButton();
	
	AccountPage accountpage=new AccountPage(driver);
		
		Assert.assertTrue(accountpage.isUserLoggedin());
		Assert.assertTrue(accountpage.navigatedToAccountPage());
	}

@DataProvider(name="datasupplier")
public Object[][] supplyTestData()  {
	MyXLSReader myxlsreader=null;
	Object[][] data = null;
	try {
	 myxlsreader=new MyXLSReader(System.getProperty("user.dir")+"\\src\\test\\resources\\TutorialsNinjaData.xlsx");
	data= Utilities.getTestData(myxlsreader, "Login Test", "Data");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return data;
	
}

@Test(priority=2)
public void invalidCrendentials()
{
	LoginPage loginpage=new LoginPage(driver);
	loginpage.inputEmail(Utilities.generateNewEmail());
	loginpage.inputPassword(prop.getProperty("invalidpassword"));	
	loginpage.loginButton();
	
	
	String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
	String actualMessage=loginpage.verifyErrorMessage();
	Assert.assertTrue(actualMessage.contains(expectedMessage));
	
}
@Test(priority=3)
public void invalidEmail() {
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.inputEmail(Utilities.generateNewEmail());
	loginpage.inputPassword(prop.getProperty("invalidpassword"));	
	loginpage.loginButton();
	
	
	Assert.assertTrue(loginpage.checkErrorMessage());
	String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
	String actualMessage=loginpage.verifyErrorMessage();
	Assert.assertTrue(actualMessage.contains(expectedMessage));
}
@Test(priority=4)
public void invalidPassword() {
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.inputEmail(Utilities.generateNewEmail());
	loginpage.inputPassword(prop.getProperty("invalidpassword"));	
	loginpage.loginButton();
	
	
	
	String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
	String actualMessage=loginpage.verifyErrorMessage();
	Assert.assertTrue(actualMessage.contains(expectedMessage));
	
}
@Test(priority=5)
public void emptyCredentials() {
	LoginPage loginpage=new LoginPage(driver);
	loginpage.loginButton();
	
	String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
	String actualMessage=loginpage.verifyErrorMessage();
	Assert.assertTrue(actualMessage.contains(expectedMessage));
	
}

}
