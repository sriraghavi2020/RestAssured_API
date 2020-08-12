package TestCase_DataDriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataForPost.UserData;
import ExcelSheetData_RestAssured.ReadData_From_Excel;
import io.restassured.http.ContentType;
public class TestCase_PostCall_DataProvider extends UserData{




	//Sample1 with dimensions

	//@Test(dataProvider = "DataForPost")

	//Sample2 without dimensions
	@DataProvider
	public Iterator<Object[]> getData() {
		String projDir = System.getProperty("user.dir");
		String filePath = projDir+"\\ExcelData\\Data.xlsx";
		String SheetName = "Sheet1";
		ReadData_From_Excel data = new ReadData_From_Excel(filePath, SheetName);
		//data_PostCall data = new data_PostCall(XPath, SheetName);
		ArrayList<Object[]> testData = null;
		
				 testData = data.ReadExcel();
			System.out.println(testData);
		return testData.iterator();
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "getData")
	public void Test_PostCall(int id, String name, String company, int profileID) {
		

		JSONObject payLoad = new JSONObject();

		payLoad.put("id", id);

		payLoad.put("name", name);

		payLoad.put("company", company);

		payLoad.put("profileID",profileID);
		
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(payLoad.toJSONString()).post("/data").then().statusCode(201).log().all();
	}

}
