package ExcelSheetData_RestAssured;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData_From_Excel {
	

	public static XSSFWorkbook excel;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	
	public ReadData_From_Excel(String XPath, String SheetName) {
		
	try {
		//String projDir = System.getProperty("user.dir");
		//String XPath = projDir+"\\ExcelData\\Data.xlsx";
		excel = new XSSFWorkbook(XPath);
		sheet = excel.getSheet(SheetName);

		//sheet = excel.getSheet("Sheet1");
		} catch (IOException exp) {
		System.out.println(exp.getMessage());
		}
		
	}
	
	public Object getData(int rowNum, int colNum) {
		//ArrayList<Object[]> info = new ArrayList<Object[]>();

		//String dataOfRow1 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();	//this statement can only get String value
		//System.out.println(dataOfRow1);
//		Row r = sheet.getRow(1);
//		Cell c = r.getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL);
//		if(cell.getCellTypeEnum() == CellType.STRING) {
//			String dataOfRow = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//		}else if (cell.getCellTypeEnum() == CellType.NUMERIC){
//			double dataOfRow = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
//		}
		DataFormatter formatter = new DataFormatter(); 
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(value);
		
		System.out.println("*****");
		return value;
		
		
		}
		
		public ArrayList<Object[]> ReadExcel(){
//			File file = new File(filePath);
//			FileInputStream inputStream = new FileInputStream(file);
//			excel = new XSSFWorkbook(inputStream);
//			sheet = excel.getSheet(SheetName);
			int id = 0;
			int profileID = 0;
			String name = null;
			String company = null;
			
			ArrayList<Object[]> mydata = new ArrayList<Object[]>();
			Object ob1[] = null;
			
			for(int rowNum = 1; rowNum<2; rowNum++) {
				for(int colNum = 0; colNum<4; colNum++) {
				
				switch(colNum) {
				case 0:
					id = intergerValue(rowNum, colNum);
					break;
				case 1:
					name= stringValue(rowNum, colNum);
					break;
				case 2:
					company =stringValue(rowNum, colNum);
					break;
				case 3:
					profileID = intergerValue(rowNum, colNum);
					break;
				}
				Object ob[] = {id , name, company, profileID};
				ob1 =ob;
				//mydata.add(new Object[] {id , name, company, profileID});
				//mydata.add(ob);
				}	
				mydata.add(ob1);
			}return mydata;
			
		}
	public static int intergerValue(int rowNum, int colNum) {
		int value;
		double d = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		value = (int)d;
		return value;
	}
	public static String stringValue(int rowNum, int colNum) {
		String value;
		value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	}
}

