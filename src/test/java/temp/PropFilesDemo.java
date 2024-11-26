package temp;

import java.io.FileReader;
import java.util.Properties;

public class PropFilesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop=null;
		FileReader fr;
		try {
			prop=new Properties();
			fr = new FileReader("C:\\Users\\DELL\\eclipse-workspace\\Frameworks\\FrameWorks\\src\\test\\java\\temp\\Experiment.properties");
			prop.load(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("experience"));
		System.out.println(prop.getProperty("place"));
		System.out.println(prop.getProperty("working"));
		
	}

}
