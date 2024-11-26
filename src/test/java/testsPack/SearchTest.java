package testsPack;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.LandingPage;
import pages.SearchPage;

public class SearchTest extends Base{
	public WebDriver driver;
	
	
	
@BeforeMethod
	public void setUP() {
	driver=openApplicationURLInTheBrowser(prop.getProperty("browser"));
	
	}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
@Test(priority=1)	
public void verifySearchWithExistingProduct() {
	LandingPage landingPage=new LandingPage(driver);
	landingPage.searchboxField(prop.getProperty("validproductname"));
	driver=landingPage.clickonSearchButton();
	
	SearchPage searchPage=new SearchPage(driver);
	
	Assert.assertTrue(searchPage.validProductCheck());
	
}
@Test(priority=2,dependsOnMethods="verifySearchWithExistingProduct")
public void verifySearchNonExistingProduct() {
	
	LandingPage landingPage=new LandingPage(driver);
	landingPage.searchboxField(prop.getProperty("invalidproductname"));
	driver=landingPage.clickonSearchButton();
	SearchPage searchPage=new SearchPage(driver);
	String expectedmessage="There is no product that matches the search criteria.";
	Assert.assertEquals(searchPage.getNoProductMessage(),expectedmessage);
}
@Test(priority=3)
public void verifySearchWithoutProduct() {
	
	LandingPage landingPage=new LandingPage(driver);
	driver=landingPage.clickonSearchButton();
	SearchPage searchPage=new SearchPage(driver);
	String expectedmessage="There is no product that matches the search criteria.";
	Assert.assertEquals(searchPage.getNoProductMessage(),expectedmessage);
}
}
