package utilitiesPackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

public class Utilities {
public static String  generateNewEmail() {
		
		Date date=new Date();
		System.out.println(date);
		String datestring = date.toString();
		String modifiedstring = datestring.replaceAll(" ", "");
		//System.out.println(modifiedstring);
		modifiedstring=modifiedstring.replaceAll(":","");
		//System.out.println(modifiedstring);
		String newemail = modifiedstring+"@gmail.com";
		 return newemail;

	}
public static Properties loadpropertiesFile() {
	Properties prop=null;
	
	try {
		prop=new Properties();
		
			FileReader fr=new FileReader("C:\\Users\\DELL\\eclipse-workspace\\Frameworks\\FrameWorks\\src\\test\\resources\\AppData.properties");
		prop.load(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return prop;
	
}

public static Properties testDataProperties() {
	Properties prop=null;
	
	try {
		prop=new Properties();
		
			FileReader fr=new FileReader("C:\\Users\\DELL\\eclipse-workspace\\Frameworks\\FrameWorks\\src\\test\\resources\\TestData.properties");
		prop.load(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return prop;
	
}

@DataProvider(name="hashDataProvider")
public static Object[][] getTestData(MyXLSReader xls_received, String testName, String sheetName) throws Exception{
	
	MyXLSReader xls = xls_received;

	String testCaseName = testName;
	
	String testDataSheet = sheetName;
	
	int testStartRowNumber=1;		
	
	while(!(xls.getCellData(testDataSheet, 1, testStartRowNumber).equals(testCaseName))){
		
		testStartRowNumber++;
		
	}
	
	int columnStartRowNumber = testStartRowNumber+1;
	int dataStartRowNumber = testStartRowNumber+2;
	
	int rows=0;
	while(!(xls.getCellData(testDataSheet, 1, dataStartRowNumber+rows).equals(""))){
		
		rows++;
		
	}
	
	//Total number of columns in the required test
	int columns=1;
	
	while(!(xls.getCellData(testDataSheet, columns, columnStartRowNumber).equals(""))){
		
		columns++;
		
	}
	
	Object[][] obj = new Object[rows][1];
	
	HashMap<String,String> map = null;
	
	//Reading the data in the test
	for(int i=0,row=dataStartRowNumber;row<dataStartRowNumber+rows;row++,i++){
		
		map = new HashMap<String,String>();
		
		for(int j=0,column=1;column<columns;column++,j++){
			
			String key=xls.getCellData(testDataSheet, column, columnStartRowNumber);
			
			String value=xls.getCellData(testDataSheet, column, row);
			
			map.put(key,value);
			
		}
		
		obj[i][0]=map;
	
	}	
	
	return obj;


}

public static  String takeScreenshot(WebDriver driver, String testName) {
	TakesScreenshot tsDriver = (TakesScreenshot)driver;
	File scrFile=tsDriver.getScreenshotAs(OutputType.FILE);
	String screenshotPath=null;
	try {
		 screenshotPath=System.getProperty("user.dir")+"\\target\\screenshots\\"+testName+".png";
		FileHandler.copy(scrFile,new File(screenshotPath));
	} catch (IOException e) {
		e.printStackTrace();
	}
	return screenshotPath;
}
}
