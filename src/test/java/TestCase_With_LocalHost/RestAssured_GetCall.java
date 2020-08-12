package TestCase_With_LocalHost;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class RestAssured_GetCall {

	@Test
	public void Test_GetCall_data() {
		baseURI = "http://localhost:3000";
		given().param("name", "Peter").
		get("/data").then().statusCode(200).log().all();
		
		
	}
	@Test
	public void Test_GetCall_Profile() {
		baseURI = "http://localhost:3000";
		
		given().param("job", "Testing").
		get("/profile").then().statusCode(200).log().all();
	}
}
