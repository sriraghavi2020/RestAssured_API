package ExcelSheetData_RestAssured;

import java.util.ArrayList;

public class Test_ReadData_From_Excel {
public static void main(String[] args) {
	
	
	String projDir = System.getProperty("user.dir");
	String filePath = projDir+"\\ExcelData\\Data.xlsx";
	String SheetName = "Sheet1";
	ReadData_From_Excel data = new ReadData_From_Excel(filePath, SheetName);
	//data_PostCall data = new data_PostCall(XPath, SheetName);
	ArrayList<Object[]> testData = null;
	
			 testData = data.ReadExcel();
	
		System.out.println(testData);
	}
	
}

