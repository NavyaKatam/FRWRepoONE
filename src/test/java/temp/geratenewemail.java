package temp;

import java.util.Date;

public class geratenewemail {

		public String  generateNewEmail() {
		
		Date date=new Date();
		System.out.println(date);
		String datestring = date.toString();
		String modifiedstring = datestring.replaceAll(" ", "");
		System.out.println(modifiedstring);
		modifiedstring=modifiedstring.replaceAll(":","");
		System.out.println(modifiedstring);
		String newemail = modifiedstring+"@gmail.com";
		 return newemail;

	}

}
