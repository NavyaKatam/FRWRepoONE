package temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIAPIDemo {
	
	public static void main(String[] args) throws IOException {
		
		File employeeDetailsFile=new File("C:\\Users\\DELL\\eclipse-workspace\\Frameworks\\FrameWorks\\src\\test\\java\\temp\\EmploysDemo.xlsx");
		FileInputStream fis= new FileInputStream(employeeDetailsFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheet("employees");
		
		int rowsCount=sheet.getLastRowNum()+1;
		System.out.println(rowsCount);
		
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		
		for (int r=0;r<rowsCount;r++) {
			
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0;c<cellCount;c++) {
				XSSFCell cell = row.getCell(c);
				CellType celltype = cell.getCellType();
				switch(celltype) {
				
				case NUMERIC:
					System.out.print(cell.getNumericCellValue()+"--- ");
					break;
				case STRING:
					System.out.print(cell.getStringCellValue()+"--- ");
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue()+"--- ");
					break;
					
				default:
					break;
				}
				
				
			}
			
			System.out.println( );
		}
		
		workbook.close();
	}

}
