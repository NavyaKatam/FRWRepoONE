package temp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserDemo {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		
		String browserName="edge";
		if(browserName.equals("chrome")) {
			 driver=new ChromeDriver();
		}else if(browserName.equals("firefox")){
			 driver=new FirefoxDriver();
		}else if(browserName.equals("edge")) {
		
		 driver=new EdgeDriver();
		}else if(browserName.equals("ie")) {
			 driver = new InternetExplorerDriver();
		}else if(browserName.equals("safari")) {
			 driver=new SafariDriver();
	}
	
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		
		String pageTitle=driver.getTitle();
		if(pageTitle.equals("Your Store")) {
			System.out.println("Test Pass");
			
		}else {
			System.out.println("Test Fail");
		}
		driver.quit();
	}
	

}
