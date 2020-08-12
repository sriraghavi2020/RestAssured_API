package TestCase_DataDriven;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import DataForPost.UserData;

public class TestCase_DeleteCall extends UserData{
	
	@Parameters({"userID"})
	@Test
	public void Test_DeleteCAll(int userID) {
		baseURI = "http://localhost:3000";
		
		given().delete("/data/"+userID).then().log().all();
		
	}

}
