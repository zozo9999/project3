package project2.project2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data_driven {

//Identify Testcases coloum by scanning the entire 1st row
//once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
//after you grab purchase testcase row = pull all the data of that row and feed into test

	public ArrayList<String> getData(String testcaseName) throws IOException {
//fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\Junghwan Shin\\OneDrive\\바탕 화면\\잡종\\Book2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
//Identify Testcases coloum by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("testCase")) {
						coloumn = k;
					}
					k++;
				}
				System.out.println(coloumn);
//once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
//after you grab purchase testcase row = pull all the data of that row and feed into test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellTypeEnum() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return a;
	}
	
	public ArrayList<String> excel(String uname) throws IOException {
		String username = "";
		String passwords = "";
		ArrayList<String> lists_uname = new ArrayList<>();
		ArrayList<String> lists_pwd = new ArrayList<>();

		File file = new File("C:\\Users\\Junghwan Shin\\OneDrive\\바탕 화면\\잡종\\Book2.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		String filename = "Book2.xlsx";
		String fileExtensionName = filename.substring(filename.indexOf("."));
			if(fileExtensionName.equals(".xlsx"))	{
				guru99Workbook = new XSSFWorkbook(inputStream);
			} else if(fileExtensionName.equals(".xls")){
				guru99Workbook = new HSSFWorkbook(inputStream);
			}
			Sheet guru99Sheet = guru99Workbook.getSheet("Sheet1");
			DataFormatter formatter = new DataFormatter();
			for (int i=1; i <= guru99Sheet.getLastRowNum(); i++) {
		        Row r = guru99Sheet.getRow(i);
		        if (r == null) { 
		           // empty row, skip
		        } else {
		        	if(uname.equalsIgnoreCase("username")) {
		        		username = formatter.formatCellValue(r.getCell(1));
		        		lists_uname.add(username);
		    
		        	} else if (uname.equalsIgnoreCase("password")) {
		        		passwords =  formatter.formatCellValue(r.getCell(2));
		        		lists_pwd.add(passwords);
		     
		        	}
		        }
			}
			if(uname.equalsIgnoreCase("username")) {
	    		return lists_uname;	
			} else {
		   		return lists_pwd;	
			}
			 
//		System.out.println(lists_uname);
//		System.out.println(lists_pwd);		
	}

	public static void main(String[] args) throws IOException {

		data_driven d = new data_driven();
//		ArrayList<String> b = d.getData("login");
		
		ArrayList<String> c = d.excel("password");
		System.out.println(c);
//		System.out.println(b);
	}

}