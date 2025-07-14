package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import SELENIUM.SELENIUM_PROJECT.BaseClass;

public class ExcelUtil extends BaseClass{
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js; 
	/*public ArrayList<String> getData() throws IOException 
	{
	ArrayList<String> a =new ArrayList<String>();
	FileInputStream fis=new FileInputStream("D:/Automation/SELENIUM_PROJECT/src/main/java/Utilities/sheetname.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

	int sheetsize=workbook.getNumberOfSheets();
	for(int i=0;i<sheetsize;i++)
	{
	if(workbook.getSheetName(i).equalsIgnoreCase("contactdata"))
	{
	XSSFSheet sheetindex=workbook.getSheetAt(i);
	Iterator<Row> rows=sheetindex.iterator();
	Row firstrow=rows.next();
	Iterator<Cell> ce=firstrow.cellIterator();

	int k=0;
	int col=0;
	while(ce.hasNext())
	{
	Cell value=ce.next();
	if(value.getStringCellValue().equalsIgnoreCase("firstname"))
	{
	col=k; 
	while(rows.hasNext())
	{
	Row r=rows.next();
	Iterator<Cell> rowvalue=r.cellIterator();
	while(rowvalue.hasNext())
	{
	//System.out.println(rowvalue.next().getStringCellValue());
	a.add(rowvalue.next().getStringCellValue());
	}
	}
	}
	k++;
	}
	System.out.println(col);

	}
	}
	return a;

	
	}*///getdata//
	public static String TESTDATA_SHEET_PATH = "D:/Automation/SELENIUM_PROJECT/src/main/java/Utilities/sheetname.xlsx";

	public static Object[][] getTestData(String sheetname) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException  {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) { 
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "--------" );
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) { 
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data; 
	} 
	
	
	
	
	

}
